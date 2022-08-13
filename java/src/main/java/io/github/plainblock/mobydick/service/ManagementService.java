package io.github.plainblock.mobydick.service;

import java.util.ArrayList;
import java.util.List;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.model.object.BookStatus;

import io.github.plainblock.mobydick.domain.repository.InternalRepository;

public class ManagementService extends BaseService {

    private final InternalRepository internal;

    private List<Book> managedBooks = new ArrayList<>();
    private String keywordCache = "";

    public ManagementService(InternalRepository internal) {
        this.internal = internal;
    }

    public List<Book> getManagedBooks() {
        return managedBooks;
    }

    public String loadBooks(String keyword, BookStatus status) {
        try {
            keywordCache = keyword;
            managedBooks = internal.searchBooks(keyword, status);
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

    public String updateBookStatus(Book book, BookStatus status) {
        try {
            book.update(internal, status);
            managedBooks = internal.searchBooks(keywordCache, status);
            return "ステータスを更新しました";
        } catch (Exception e) {
            return formatErrorMessage(e);
        }
    }

}
