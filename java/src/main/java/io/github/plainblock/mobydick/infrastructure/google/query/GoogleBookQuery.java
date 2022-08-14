package io.github.plainblock.mobydick.infrastructure.google.query;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;

public record GoogleBookQuery(String keyword, String title, String author, String publisher, String subject, String isbn, String lccn, String oclc, Integer number, Integer index) {

    public GoogleBookQuery {
        if (isBlank(keyword) && isBlank(title) && isBlank(author) && isBlank(publisher) && isBlank(subject) && isBlank(isbn) && isBlank(lccn) && isBlank(oclc)) {
            throw new InvalidParameterException("At least one query parameter is required");
        }
        if (number == null) {
            number = 10;
        }
        if (index == null) {
            index = 0;
        }
    }

    public String toParam() {
        boolean requirePlusMarker = false;
        StringBuilder sb = new StringBuilder("?q=");
        if (!isBlank(keyword)) {
            sb.append(encode(keyword));
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
        if (number != null) {
            sb.append(String.format("&maxResults=%d", number));
        }
        if (index != null) {
            sb.append(String.format("&startIndex=%d", index));
        }
        return sb.toString();
    }

    private static boolean isBlank(String target) {
        return target == null || target.isBlank();
    }

    private String toParam(String key, String value, boolean plusMarker) {
        if (plusMarker) {
            return "+" + key + ":" + encode(value);
        }
        return key + ":" + encode(value);
    }

    private String encode(String value) {
        return URLEncoder.encode(value.trim(), StandardCharsets.UTF_8).replace("+", "%20");
    }

}
