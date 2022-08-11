package io.github.plainblock.mobydick.infrastructure.google.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndustryIdentifier {

    @JsonProperty("type")
    private String type;

    @JsonProperty("identifier")
    private String identifier;

    public String getType() {
        return type;
    }

    public String getIdentifier() {
        return identifier;
    }

}
