package io.github.plainblock.mobydick.infrastructure.google.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessInfo {

    @JsonProperty("country")
    private String country;

    @JsonProperty("viewability")
    private String viewAbility;

    @JsonProperty("embeddable")
    private boolean embeddable;

    @JsonProperty("publicDomain")
    private boolean publicDomain;

    @JsonProperty("textToSpeechPermission")
    private String textToSpeechPermission;

    @JsonProperty("epub")
    private Available epub;

    @JsonProperty("pdf")
    private Available pdf;

    @JsonProperty("webReaderLink")
    private String webReaderLink;

    @JsonProperty("accessViewStatus")
    private String accessViewStatus;

    @JsonProperty("quoteSharingAllowed")
    private boolean quoteSharingAllowed;

    public String getCountry() {
        return country;
    }

    public String getViewAbility() {
        return viewAbility;
    }

    public boolean isEmbeddable() {
        return embeddable;
    }

    public boolean isPublicDomain() {
        return publicDomain;
    }

    public String getTextToSpeechPermission() {
        return textToSpeechPermission;
    }

    public boolean isEpubAvailable() {
        return epub.isAvailable();
    }

    public boolean isPdfAvailable() {
        return pdf.isAvailable();
    }

    public String getWebReaderLink() {
        return webReaderLink;
    }

    public String getAccessViewStatus() {
        return accessViewStatus;
    }

    public boolean isQuoteSharingAllowed() {
        return quoteSharingAllowed;
    }

}
