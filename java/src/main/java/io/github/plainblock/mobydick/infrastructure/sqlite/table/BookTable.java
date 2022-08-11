package io.github.plainblock.mobydick.infrastructure.sqlite.table;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.model.object.BookId;
import io.github.plainblock.mobydick.domain.model.object.BookStatus;
import io.github.plainblock.mobydick.domain.model.object.ISBN;

public class BookTable {

    private String id;

    private String isbn;

    private String title;

    private String author;

    private String publisher;

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
