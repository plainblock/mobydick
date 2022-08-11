package io.github.plainblock.mobydick.infrastructure.google.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReadingMode {

    @JsonProperty("text")
    private boolean text;

    @JsonProperty("image")
    private boolean image;

    public boolean isText() {
        return text;
    }

    public boolean isImage() {
        return image;
    }

}
