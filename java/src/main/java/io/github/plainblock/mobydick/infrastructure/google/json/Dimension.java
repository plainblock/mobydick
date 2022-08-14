package io.github.plainblock.mobydick.infrastructure.google.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Dimension {

    @JsonProperty("height")
    private String height;

    @JsonProperty("width")
    private String width;

    @JsonProperty("thickness")
    private String thickness;

}
