package io.github.plainblock.mobydick.infrastructure.sqlite.table;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.model.object.BookId;
import io.github.plainblock.mobydick.domain.model.object.BookStatus;
import io.github.plainblock.mobydick.domain.model.object.ISBN;

@Entity
@Table(name = "books")
public class BookTable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "published_date")
    private String publishedDate;

    @Column(name = "information")
    private String information;

    @Column(name = "status")
    private int status;

    @Column(name = "register_at")
    private Date registerAt;

    @Column(name = "read_at")
    private Date readAt;

    public Book toEntity() {
        if (isbn == null || isbn.isBlank()) {
            return new Book(new BookId(id), null, title, author, publisher, publishedDate, information, BookStatus.fromCode(status), registerAt, readAt);
        }
        return new Book(new BookId(id), new ISBN(isbn), title, author, publisher, publishedDate, information, BookStatus.fromCode(status), registerAt, readAt);
    }

    public static BookTable fromEntity(Book book) {
        BookTable table = new BookTable();
        table.id = book.getId().value();
        table.isbn = book.getIsbn().value();
        table.title = book.getTitle();
        table.author = book.getAuthor();
        table.publisher = book.getPublisher();
        table.publishedDate = book.getPublishedDate();
        table.information = book.getInformation();
        table.status = book.getStatus().code();
        table.registerAt = book.getRegisterAt();
        table.readAt = book.getReadAt();
        return table;
    }

}
