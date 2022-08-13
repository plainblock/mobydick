package io.github.plainblock.mobydick.service;

import java.util.ArrayList;
import java.util.List;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.repository.ExternalRepository;

public class ReferenceService extends BaseService {

    private final ExternalRepository external;

    private List<Book> fetchedBooks = new ArrayList<>();

    public ReferenceService(ExternalRepository external) {
        this.external = external;
    }

    public List<Book> getFetchedBooks() {
        return fetchedBooks;
    }

    public String findWithCondition(String title, String author, String publisher) {
        try {
            fetchedBooks = external.searchBooks(title, author, publisher);
            if (fetchedBooks.isEmpty()) {
                return "条件にあう書籍が見つかりませんでした";
            }
            return String.format("%d件見つかりました", fetchedBooks.size());
        } catch (Exception e) {
            return formatErrorMessage(e);
        }
    }

}
