package io.github.plainblock.mobydick.infrastructure.google.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Available {

    @JsonProperty("isAvailable")
    private boolean available;

    public boolean isAvailable() {
        return available;
    }

}
