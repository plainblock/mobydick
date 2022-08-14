package io.github.plainblock.mobydick.infrastructure.google.json;

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
    private AccessLink epub;

    @JsonProperty("pdf")
    private AccessLink pdf;

    @JsonProperty("webReaderLink")
    private String webReaderLink;

    @JsonProperty("accessViewStatus")
    private String accessViewStatus;

    @JsonProperty("quoteSharingAllowed")
    private boolean quoteSharingAllowed;

    @JsonProperty("downloadAccess")
    private DownloadAccess downloadAccess;

}
