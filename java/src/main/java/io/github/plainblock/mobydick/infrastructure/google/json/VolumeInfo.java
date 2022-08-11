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
    private List<IndustryIdentifier> IndustryIdentifiers;

    @JsonProperty("readingModes")
    private ReadingMode readingModes;

    @JsonProperty("pageCount")
    private int pageCount;

    @JsonProperty("printType")
    private String printType;

    @JsonProperty("categories")
    private List<String> categories;

    @JsonProperty("maturityRating")
    private String maturityRating;

    @JsonProperty("allowAnonLogging")
    private boolean allowAnonLogging;

    @JsonProperty("contentVersion")
    private String contentVersion;

    @JsonProperty("language")
    private String language;

    @JsonProperty("previewLink")
    private String previewLink;

    @JsonProperty("infoLink")
    private String infoLink;

    @JsonProperty("canonicalVolumeLink")
    private String canonicalVolumeLink;

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public List<String> getAuthors() {
        return authors;
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

    public List<IndustryIdentifier> getIndustryIdentifiers() {
        return IndustryIdentifiers;
    }

    public String getISBN() {
        String isbn10 = null;
        for (IndustryIdentifier ii : IndustryIdentifiers) {
            if (ii.getType().equals("ISBN_13")) {
                return ii.getIdentifier();
            } else if (ii.getType().equals("ISBN_10")) {
                isbn10 = ii.getIdentifier();
            }
        }
        return isbn10;
    }

    public ReadingMode getReadingModes() {
        return readingModes;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getPrintType() {
        return printType;
    }

    public String getMaturityRating() {
        return maturityRating;
    }

    public boolean isAllowAnonLogging() {
        return allowAnonLogging;
    }

    public String getContentVersion() {
        return contentVersion;
    }

    public String getLanguage() {
        return language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public String getCanonicalVolumeLink() {
        return canonicalVolumeLink;
    }

}
