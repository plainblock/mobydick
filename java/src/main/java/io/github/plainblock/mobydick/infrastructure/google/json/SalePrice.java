package io.github.plainblock.mobydick.infrastructure.google.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalePrice {

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("currencyCode")
    private String currencyCode;

}
