package io.github.plainblock.mobydick.infrastructure.google.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchInfo {

    @JsonProperty("textSnippet")
    private String textSnippet;

    public String getTextSnippet() {
        return textSnippet;
    }

}
