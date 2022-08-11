package io.github.plainblock.mobydick.infrastructure.google;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.model.object.ISBN;
import io.github.plainblock.mobydick.domain.repository.ExternalRepository;
import io.github.plainblock.mobydick.infrastructure.google.data.GoogleBook;
import io.github.plainblock.mobydick.infrastructure.google.query.SearchQuery;
import io.github.plainblock.mobydick.infrastructure.google.data.GoogleBookItem;

public class GoogleBooksApi implements ExternalRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleBooksApi.class);
    private static final String ENDPOINT = "https://www.googleapis.com/books/v1/volumes";
    private ObjectMapper mapper;

    public GoogleBooksApi() {
        mapper = new ObjectMapper();
    }

    @Override
    public List<Book> searchBooks(String title, String author, String publisher) {
        SearchQuery query = new SearchQuery(null, title, author, publisher, null, null, null, null);
        GoogleBook result = execute(null, query, GoogleBook.class);
        if (result == null || result.getItems().isEmpty()) {
            return new ArrayList<>();
        }
        return result.getItems().stream().map(GoogleBookItem::toBook).toList();
    }

    @Override
    public Optional<Book> fetchBook(ISBN isbn) {
        SearchQuery query = new SearchQuery(null, null, null, null, null, isbn.value(), null, null);
        GoogleBook result = execute(null, query, GoogleBook.class);
        if (result == null || result.getItems().isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(result.getItems().get(0).toBook());
    }

    private <T> T execute(String id, SearchQuery query, Class<T> clazz) {
        try {
            URL url = setupURL(id, query);
            LOGGER.debug("GET " + url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            InputStream response = connection.getInputStream();
            return mapper.readValue(response, clazz);
        } catch (IOException e) {
            LOGGER.error("Request is failed", e.fillInStackTrace());
        }
        return null;
    }

    private URL setupURL(String id, SearchQuery query) throws MalformedURLException {
        StringBuilder sb = new StringBuilder(ENDPOINT);
        if (id != null && !id.isBlank()) {
            sb.append("/");
            sb.append(id);
        }
        if (query != null) {
            sb.append(query.toParam());
        }
        return new URL(sb.toString());
    }

}
