package io.github.plainblock.mobydick.domain.repository;

import java.util.List;
import java.util.Optional;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.model.object.ISBN;

public interface ExternalRepository {

    List<Book> searchBooks(String title, String author, String publisher);

    List<Book> searchBooks(String title, String author, String publisher, int page);

    List<Book> searchBooks(String title, String author, String publisher, int number, int page);

    Optional<Book> fetchBook(ISBN isbn);

}
