package io.github.plainblock.mobydick.domain.repository;

import java.util.List;
import java.util.Optional;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.model.object.BookId;
import io.github.plainblock.mobydick.domain.model.object.BookStatus;

public interface InternalRepository {

    List<Book> filterBooks(String title, String author, String publisher, BookStatus status);

    List<Book> getAllBooks();

    Optional<Book> getBook(BookId id);

    Book persist(Book book);

    void truncate(Book book);

}
