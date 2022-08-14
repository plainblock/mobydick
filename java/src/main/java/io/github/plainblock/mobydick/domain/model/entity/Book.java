package io.github.plainblock.mobydick.domain.model.entity;

import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.MissingResourceException;

import io.github.plainblock.mobydick.domain.model.object.BookId;
import io.github.plainblock.mobydick.domain.model.object.BookStatus;
import io.github.plainblock.mobydick.domain.model.object.ISBN;
import io.github.plainblock.mobydick.domain.repository.InternalRepository;

public class Book {

    private BookId id;
    private ISBN isbn;
    private String title;
    private String author;
    private String publisher;
    private String publishedDate;
    private BookStatus status;
    private Date registerAt;
    private Date readAt;

    private Book() {
    }

    public Book(BookId id, ISBN isbn, String title, String author, String publisher, String publishedDate, BookStatus status, Date registerAt, Date readAt) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.status = status;
        this.registerAt = registerAt;
        this.readAt = readAt;
    }

    public Book create(InternalRepository repo, BookStatus status) {
        if (status == null) {
            throw new InvalidParameterException("BookStatus is null");
        }
        Date now = new Date();
        BookId bookId = BookId.generate();
        while (isExisted(repo, bookId)) {
            bookId = BookId.generate();
        }
        this.id = bookId;
        this.status = status;
        this.registerAt = now;
        if (this.status == BookStatus.ALREADY_READ) {
            this.readAt = now;
        }
        return repo.persist(this);
    }

    public Book update(InternalRepository repo, BookStatus status) {
        if (this.id == null) {
            throw new InvalidParameterException("BookId is null");
        }
        if (status == null) {
            throw new InvalidParameterException("BookStatus is null");
        }
        if (this.status == status) {
            return this;
        }
        Date now = new Date();
        this.status = status;
        if (this.status != BookStatus.ALREADY_READ) {
            this.readAt = null;
        } else if (this.readAt == null) {
            this.readAt = now;
        }
        if (this.registerAt == null) {
            this.registerAt = now;
        }
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
            return new String[]{title, author, publisher, publishedDate, ""};
        }
        return new String[]{title, author, publisher, publishedDate, isbn.value()};
    }

    public String[] toRowManagementData() {
        return new String[]{title, author, getRegisterAtString(), getReadAtString(), status.label()};
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

    public String getPublishedDate() {
        return publishedDate;
    }

    public BookStatus getStatus() {
        return status;
    }

    public Date getRegisterAt() {
        return registerAt;
    }

    public String getRegisterAtString() {
        if (registerAt == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(registerAt);
    }

    public Date getReadAt() {
        return readAt;
    }

    public String getReadAtString() {
        if (readAt == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(readAt);
    }

    private static boolean isExisted(InternalRepository repo, BookId id) {
        return repo.getBook(id).isPresent();
    }

}
