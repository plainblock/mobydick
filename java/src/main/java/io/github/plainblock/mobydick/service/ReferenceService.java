package io.github.plainblock.mobydick.service;

import java.util.List;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.repository.ExternalRepository;

public class ReferenceService {

    private final ExternalRepository external;

    public ReferenceService(ExternalRepository external) {
        this.external = external;
    }

    public List<Book> findWithCondition(String title, String author, String publisher) {
        return external.searchBooks(title, author, publisher);
    }

}
