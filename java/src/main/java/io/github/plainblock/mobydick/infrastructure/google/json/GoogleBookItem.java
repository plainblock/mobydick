package io.github.plainblock.mobydick.infrastructure.google.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.model.object.BookStatus;
import io.github.plainblock.mobydick.domain.model.object.ISBN;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleBookItem {

    @JsonProperty("id")
    private String id;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("etag")
    private String etag;

    @JsonProperty("selfLink")
    private String selfLink;

    @JsonProperty("volumeInfo")
    private VolumeInfo volumeInfo;

    @JsonProperty("saleInfo")
    private SaleInfo saleInfo;

    @JsonProperty("accessInfo")
    private AccessInfo accessInfo;

    @JsonProperty("searchInfo")
    private SearchInfo searchInfo;

    public Book toBook() {
        String isbn = volumeInfo.getISBN();
        if (isbn == null || isbn.isBlank()) {
            return new Book(null, null, volumeInfo.getTitle(), volumeInfo.getAuthor(), volumeInfo.getPublisher(), volumeInfo.getPublishedDate(), volumeInfo.getPreviewLink(), BookStatus.NOT_PURCHASED, null, null);
        }
        return new Book(null, new ISBN(isbn), volumeInfo.getTitle(), volumeInfo.getAuthor(), volumeInfo.getPublisher(), volumeInfo.getPublishedDate(), volumeInfo.getPreviewLink(), BookStatus.NOT_PURCHASED, null, null);
    }

}
