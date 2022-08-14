package io.github.plainblock.mobydick.infrastructure.sqlite;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.model.object.BookId;
import io.github.plainblock.mobydick.domain.model.object.BookStatus;
import io.github.plainblock.mobydick.domain.model.object.ISBN;

public class SqliteBookDaoTest {

    private final SqliteBookDao dao = new SqliteBookDao();

    @Test
    void filterBooksTest() {
        List<Book> books = dao.filterBooks("Moby", null, null, null, null);
        books.forEach(b -> {
            Assertions.assertNotNull(b);
            System.out.println("[title: " + b.getTitle() + ", author: " + b.getAuthor() + ", publisher: " + b.getPublisher() + ", publishedDate: " + b.getPublishedDate() + "]");
        });
    }

    @Test
    void getAllBooksTest() {
        List<Book> books = dao.getAllBooks();
        books.forEach(b -> {
            Assertions.assertNotNull(b);
            System.out.println("[title: " + b.getTitle() + ", author: " + b.getAuthor() + ", publisher: " + b.getPublisher() + ", publishedDate: " + b.getPublishedDate() + "]");
        });
    }

    @Test
    void getBookTest() {
        Book book = dao.getBook(new BookId("SAMPLE")).orElseThrow();
        System.out.println("[title: " + book.getTitle() + ", author: " + book.getAuthor() + ", publisher: " + book.getPublisher() + ", publishedDate: " + book.getPublishedDate() + "]");
    }

    @Test
    void createTest() {
        Date now = new Date();
        Book target = new Book(new BookId("TEST"), new ISBN("1234567890"), "title", "author", "publisher", "2022-01-01", BookStatus.NOT_YET_READ, now, null);
        Book result = dao.persist(target);
        Assertions.assertNotNull(result);
        System.out.println("[title: " + result.getTitle() + ", author: " + result.getAuthor() + ", publisher: " + result.getPublisher() + ", publishedDate: " + result.getPublishedDate() + "]");
    }

    @Test
    void updateTest() {
        Date now = new Date();
        Book target = new Book(new BookId("TEST"), new ISBN("1234567890"), "test-title", "test-author", "test-publisher", "2022-07-01", BookStatus.ALREADY_READ, now, now);
        Book result = dao.persist(target);
        Assertions.assertNotNull(result);
        System.out.println("[title: " + result.getTitle() + ", author: " + result.getAuthor() + ", publisher: " + result.getPublisher() + ", publishedDate: " + result.getPublishedDate() + "]");
    }

    @Test
    void deleteTest() {
        Date now = new Date();
        Book target = new Book(new BookId("TEST"), new ISBN("1234567890"), "test-title", "test-author", "test-publisher", "2022-07-01", BookStatus.ALREADY_READ, now, now);
        dao.truncate(target);
        Assertions.assertTrue(dao.getBook(new BookId("TEST")).isEmpty());
    }

}
