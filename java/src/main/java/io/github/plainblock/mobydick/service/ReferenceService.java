package io.github.plainblock.mobydick.service;

import java.util.List;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.model.object.ISBN;
import io.github.plainblock.mobydick.domain.repository.ExternalRepository;

public class ReferenceService {

    private final ExternalRepository external;

    public ReferenceService(ExternalRepository external) {
        this.external = external;
    }

    public Book findByISBN(String isbn) {
        return external.fetchBook(new ISBN(isbn)).orElseThrow();
    }

    public List<Book> findByTitle(String title) {
        return external.searchBooks(title, null, null);
    }

}
