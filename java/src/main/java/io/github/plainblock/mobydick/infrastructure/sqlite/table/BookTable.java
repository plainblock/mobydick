package io.github.plainblock.mobydick.infrastructure.sqlite.table;

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

    @Column(name = "status")
    private int status;

    public Book toEntity() {
        if (isbn == null || isbn.isBlank()) {
            return new Book(new BookId(id), null, title, author, publisher, BookStatus.fromCode(status));
        }
        return new Book(new BookId(id), new ISBN(isbn), title, author, publisher, BookStatus.fromCode(status));
    }

    public static BookTable fromEntity(Book book) {
        BookTable table = new BookTable();
        table.id = book.getId().value();
        table.isbn = book.getIsbn().value();
        table.title = book.getTitle();
        table.author = book.getAuthor();
        table.publisher = book.getPublisher();
        table.status = book.getStatus().code();
        return table;
    }

}
