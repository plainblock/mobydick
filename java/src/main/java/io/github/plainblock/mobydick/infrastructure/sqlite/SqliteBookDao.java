package io.github.plainblock.mobydick.infrastructure.sqlite;

import java.util.List;
import java.util.Optional;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.model.object.BookId;
import io.github.plainblock.mobydick.domain.model.object.BookStatus;
import io.github.plainblock.mobydick.domain.repository.InternalRepository;

public class SqliteBookDao implements InternalRepository {

    @Override
    public List<Book> filterBooks(String title, String author, String publisher, BookStatus status) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public Optional<Book> getBook(BookId id) {
        return Optional.empty();
    }

    @Override
    public Book persist(Book book) {
        return null;
    }

    @Override
    public void truncate(Book book) {

    }

}
