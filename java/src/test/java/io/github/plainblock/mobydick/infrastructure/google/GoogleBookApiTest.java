package io.github.plainblock.mobydick.infrastructure.google;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.model.object.ISBN;

public class GoogleBookApiTest {

    private final GoogleBookApi api = new GoogleBookApi();

    @Test
    void searchBooksTest() {
        List<Book> books = api.searchBooks("Moby-Dick", null, null);
        books.forEach(b -> {
            Assertions.assertNotNull(b);
            System.out.println("[title: " + b.getTitle() + ", author: " + b.getAuthor() + ", publisher: " + b.getPublisher() + "]");
        });
    }

    @Test
    void fetchBookTest() {
        Book book = api.fetchBook(new ISBN("9780810102699")).orElseThrow(RuntimeException::new);
        System.out.println("[title: " + book.getTitle() + ", author: " + book.getAuthor() + ", publisher: " + book.getPublisher() + "]");
    }

}
