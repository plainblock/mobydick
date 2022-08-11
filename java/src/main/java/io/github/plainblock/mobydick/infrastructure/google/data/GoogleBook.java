package io.github.plainblock.mobydick.infrastructure.google.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleBook {

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("totalItems")
    private int totalItems;

    @JsonProperty("items")
    private List<GoogleBookItem> items;

    public String getKind() {
        return kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public List<GoogleBookItem> getItems() {
        return items;
    }

}
