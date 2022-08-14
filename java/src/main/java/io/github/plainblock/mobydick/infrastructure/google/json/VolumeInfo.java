package io.github.plainblock.mobydick.infrastructure.google.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VolumeInfo {

    @JsonProperty("title")
    private String title;

    @JsonProperty("subtitle")
    private String subtitle;

    @JsonProperty("authors")
    private List<String> authors;

    @JsonProperty("publisher")
    private String publisher;

    @JsonProperty("publishedDate")
    private String publishedDate;

    @JsonProperty("description")
    private String description;

    @JsonProperty("industryIdentifiers")
    private List<IndustryIdentifier> industryIdentifiers;

    @JsonProperty("pageCount")
    private int pageCount;

    @JsonProperty("dimensions")
    private Dimension dimension;

    @JsonProperty("readingModes")
    private ReadingMode readingMode;

    @JsonProperty("printType")
    private String printType;

    @JsonProperty("categories")
    private List<String> categories;

    @JsonProperty("averageRating")
    private double averageRating;

    @JsonProperty("ratingsCount")
    private int ratingsCount;

    @JsonProperty("maturityRating")
    private String maturityRating;

    @JsonProperty("allowAnonLogging")
    private boolean allowAnonLogging;

    @JsonProperty("contentVersion")
    private String contentVersion;

    @JsonProperty("imageLinks")
    private ImageLink imageLink;

    @JsonProperty("language")
    private String language;

    @JsonProperty("mainCategory")
    private String mainCategory;

    @JsonProperty("previewLink")
    private String previewLink;

    @JsonProperty("infoLink")
    private String infoLink;

    @JsonProperty("canonicalVolumeLink")
    private String canonicalVolumeLink;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        if (authors == null || authors.isEmpty()) {
            return null;
        } else if (authors.size() == 1) {
            return authors.get(0);
        } else {
            StringBuilder sb = new StringBuilder(authors.get(0));
            for (int i = 1; i < authors.size(); i++) {
                sb.append(",");
                sb.append(authors.get(i));
            }
            return sb.toString();
        }
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getISBN() {
        if (industryIdentifiers == null || industryIdentifiers.isEmpty()) {
            return null;
        }
        String isbn10 = null;
        for (IndustryIdentifier ii : industryIdentifiers) {
            if (ii.getType().equals(IndustryIdentifier.IndustryIdentifierType.ISBN_13.name())) {
                return ii.getIdentifier();
            } else if (ii.getType().equals(IndustryIdentifier.IndustryIdentifierType.ISBN_10.name())) {
                isbn10 = ii.getIdentifier();
            }
        }
        return isbn10;
    }

    public String getPreviewLink() {
        return previewLink;
    }

}
