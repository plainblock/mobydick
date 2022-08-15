package io.github.plainblock.mobydick.service;

import java.util.ArrayList;
import java.util.List;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.model.object.BookStatus;
import io.github.plainblock.mobydick.domain.repository.InternalRepository;

public class ManagementService {

    private final InternalRepository internalRepository;

    private List<Book> managedBooks = new ArrayList<>();

    public ManagementService(InternalRepository internalRepository) {
        this.internalRepository = internalRepository;
    }

    public List<Book> getManagedBooks() {
        return managedBooks;
    }

    public String loadBooks(String title, String author, BookStatus status) {
        managedBooks = internalRepository.filterBooks(title, author, null, null, status);
        if (managedBooks.isEmpty()) {
            return "条件にあう書籍が見つかりませんでした";
        }
        return String.format("%d件見つかりました", managedBooks.size());
    }

    public String registerBook(Book book, BookStatus status) {
        List<Book> registered = internalRepository.filterBooks(book.getTitle(), book.getAuthor(), book.getPublisher(), book.getIsbn(), null);
        if (registered.isEmpty()) {
            book.create(internalRepository, status);
            return "本棚に登録しました";
        }
        return "既に本棚に登録済みです";
    }

    public String updateBookStatus(int index, BookStatus status) {
        managedBooks.get(index).update(internalRepository, status);
        return "ステータスを更新しました";
    }

}
