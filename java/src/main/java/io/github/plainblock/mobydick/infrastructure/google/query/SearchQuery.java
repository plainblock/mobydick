package io.github.plainblock.mobydick.infrastructure.google.query;

import java.security.InvalidParameterException;

public record SearchQuery(String keyword, String title, String author, String publisher, String subject, String isbn, String lccn, String oclc) {

    public SearchQuery {
        if (isBlank(keyword) && isBlank(title) && isBlank(author) && isBlank(publisher) && isBlank(subject) && isBlank(isbn) && isBlank(lccn) && isBlank(oclc)) {
            throw new InvalidParameterException("At least one query parameter is required");
        }
    }

    public String toParam() {
        boolean requirePlusMarker = false;
        StringBuilder sb = new StringBuilder("?q=");
        if (!isBlank(keyword)) {
            sb.append(keyword.trim());
            requirePlusMarker = true;
        }
        if (!isBlank(title)) {
            sb.append(toParam("intitle", title, requirePlusMarker));
            requirePlusMarker = true;
        }
        if (!isBlank(author)) {
            sb.append(toParam("inauthor", author, requirePlusMarker));
            requirePlusMarker = true;
        }
        if (!isBlank(publisher)) {
            sb.append(toParam("inpublisher", publisher, requirePlusMarker));
            requirePlusMarker = true;
        }
        if (!isBlank(subject)) {
            sb.append(toParam("subject", subject, requirePlusMarker));
            requirePlusMarker = true;
        }
        if (!isBlank(isbn)) {
            sb.append(toParam("isbn", isbn, requirePlusMarker));
            requirePlusMarker = true;
        }
        if (!isBlank(lccn)) {
            sb.append(toParam("lccn", lccn, requirePlusMarker));
            requirePlusMarker = true;
        }
        if (!isBlank(oclc)) {
            sb.append(toParam("oclc", oclc, requirePlusMarker));
        }
        return sb.toString();
    }

    private static boolean isBlank(String target) {
        if (target == null || target.isBlank()) {
            return true;
        }
        return false;
    }

    private String toParam(String key, String value, boolean plusMarker) {
        if (plusMarker) {
            return "+" + key + ":" + value.trim();
        }
        return key + ":" + value.trim();
    }

}
