package io.github.plainblock.mobydick.infrastructure.google.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SaleInfo {

    @JsonProperty("country")
    private String country;

    @JsonProperty("saleability")
    private String saleAbility;

    @JsonProperty("isEbook")
    private boolean ebook;

    public String getCountry() {
        return country;
    }

    public String getSaleAbility() {
        return saleAbility;
    }

    public boolean isEbook() {
        return ebook;
    }

}
