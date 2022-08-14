package io.github.plainblock.mobydick.infrastructure.google.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessLink {

    @JsonProperty("downloadLink")
    private String downloadLink;

    @JsonProperty("acsTokenLink")
    private String accessTokenLink;

    @JsonProperty("isAvailable")
    private boolean available;

}
