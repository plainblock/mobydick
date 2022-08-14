package io.github.plainblock.mobydick.infrastructure.google.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DownloadAccess {

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("volumeId")
    private String volumeId;

    @JsonProperty("restricted")
    private boolean restricted;

    @JsonProperty("deviceAllowed")
    private boolean deviceAllowed;

    @JsonProperty("justAcquired")
    private boolean justAcquired;

    @JsonProperty("maxDownloadDevices")
    private int maxDownloadDevices;

    @JsonProperty("downloadsAcquired")
    private int downloadsAcquired;

    @JsonProperty("nonce")
    private String nonce;

    @JsonProperty("source")
    private String source;

    @JsonProperty("reasonCode")
    private String reasonCode;

    @JsonProperty("message")
    private String message;

    @JsonProperty("signature")
    private String signature;

}
