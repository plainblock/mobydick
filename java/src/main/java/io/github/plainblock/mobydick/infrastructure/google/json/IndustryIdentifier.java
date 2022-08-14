package io.github.plainblock.mobydick.infrastructure.google.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndustryIdentifier {

    public enum IndustryIdentifierType {
        ISBN_10,
        ISBN_13,
        ISSN,
        OTHER,
        ;

        public static IndustryIdentifierType fromName(String name) {
            for (IndustryIdentifierType type : IndustryIdentifierType.values()) {
                if (type.name().equals(name)) {
                    return type;
                }
            }
            return null;
        }
    }

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
