package io.github.plainblock.mobydick.domain.model.entity;

import java.security.InvalidParameterException;
import java.util.MissingResourceException;

import io.github.plainblock.mobydick.domain.model.object.BookId;
import io.github.plainblock.mobydick.domain.model.object.BookStatus;
import io.github.plainblock.mobydick.domain.model.object.ISBN;
import io.github.plainblock.mobydick.domain.repository.InternalRepository;

public class Book {

    private BookId id;
    private final ISBN isbn;
    private final String title;
    private final String author;
    private final String publisher;
    private BookStatus status;

    public Book(BookId id, ISBN isbn, String title, String author, String publisher, BookStatus status) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.status = status;
    }

    public Book create(InternalRepository repo, BookStatus status) {
        if (status == null) {
            throw new InvalidParameterException("BookStatus is null");
        }
        BookId bookId = BookId.generate();
        while (isExisted(repo, bookId)) {
            bookId = BookId.generate();
        }
        this.id = bookId;
        this.status = status;
        return repo.persist(this);
    }

    public Book update(InternalRepository repo, BookStatus status) {
        if (status == null) {
            throw new InvalidParameterException("BookStatus is null");
        }
        if (this.id == null) {
            throw new InvalidParameterException("BookId is null");
        }
        this.status = status;
        return repo.persist(this);
    }

    public Book read(InternalRepository repo, BookId id) {
        return repo.getBook(id).orElseThrow(() -> new MissingResourceException("Target book is not found", Book.class.getName(), id.value()));
    }

    public void delete(InternalRepository repo) {
        if (this.id == null) {
            throw new InvalidParameterException("BookId is null");
        }
        repo.truncate(this);
    }

    public String[] toRowReferenceData() {
        if (isbn == null) {
            return new String[]{title, author, publisher, ""};
        }
        return new String[]{title, author, publisher, isbn.value()};
    }

    public String[] toRowManagementData() {
        return new String[]{title, author, publisher, status.label()};
    }

    public BookId getId() {
        return id;
    }

    public ISBN getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public BookStatus getStatus() {
        return status;
    }

    private static boolean isExisted(InternalRepository repo, BookId id) {
        return repo.getBook(id).isPresent();
    }

}
