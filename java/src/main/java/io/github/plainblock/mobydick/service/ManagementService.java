package io.github.plainblock.mobydick.service;

import java.util.ArrayList;
import java.util.List;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.model.object.BookStatus;

import io.github.plainblock.mobydick.domain.repository.InternalRepository;

public class ManagementService extends BaseService {

    private final InternalRepository internal;

    private List<Book> managedBooks = new ArrayList<>();

    public ManagementService(InternalRepository internal) {
        this.internal = internal;
    }

    public List<Book> getManagedBooks() {
        return managedBooks;
    }

    public String loadBooks(String title, String author, BookStatus status) {
        try {
            managedBooks = internal.filterBooks(title, author, null, null, status);
            if (managedBooks.isEmpty()) {
                return "条件にあう書籍が見つかりませんでした";
            }
            return String.format("%d件見つかりました", managedBooks.size());
        } catch (Exception e) {
            return formatErrorMessage(e);
        }
    }

    public String registerBook(Book book, BookStatus status) {
        try {
            List<Book> registered = internal.filterBooks(book.getTitle(), book.getAuthor(), book.getPublisher(), book.getIsbn(), null);
            if (registered.isEmpty()) {
                book.create(internal, status);
                return "本棚に登録しました";
            }
            return "既に本棚に登録済みです";
        } catch (Exception e) {
            return formatErrorMessage(e);
        }
    }

    public String updateBookStatus(int index, BookStatus status) {
        try {
            managedBooks.get(index).update(internal, status);
            return "ステータスを更新しました";
        } catch (Exception e) {
            return formatErrorMessage(e);
        }
    }

}
