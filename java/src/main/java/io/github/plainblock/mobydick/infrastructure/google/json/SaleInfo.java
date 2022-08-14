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

    @JsonProperty("listPrice")
    private SalePrice listPrice;

    @JsonProperty("retailPrice")
    private SalePrice retailPrice;

    @JsonProperty("buyLink")
    private String buyLink;

    @JsonProperty("onSaleDate")
    private String onSaleDate;

}
