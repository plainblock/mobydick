package io.github.plainblock.mobydick.infrastructure.google.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageLink {

    @JsonProperty("thumbnail")
    private String thumbnail;

    @JsonProperty("small")
    private String small;

    @JsonProperty("medium")
    private String medium;

    @JsonProperty("large")
    private String large;

    @JsonProperty("smallThumbnail")
    private String smallThumbnail;

    @JsonProperty("extraLarge")
    private String extraLarge;

}
