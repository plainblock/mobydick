package io.github.plainblock.mobydick.service;

import java.util.ArrayList;
import java.util.List;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.repository.ExternalRepository;

public class ReferenceService {

    private final ExternalRepository externalRepository;

    private List<Book> fetchedBooks = new ArrayList<>();

    public ReferenceService(ExternalRepository externalRepository) {
        this.externalRepository = externalRepository;
    }

    public List<Book> getFetchedBooks() {
        return fetchedBooks;
    }

    public String findBooks(String title, String author, String publisher, int number, int page) {
        fetchedBooks = externalRepository.searchBooks(title, author, publisher, number, page);
        if (fetchedBooks.isEmpty()) {
            return "条件にあう書籍が見つかりませんでした";
        }
        return "";
    }

}
