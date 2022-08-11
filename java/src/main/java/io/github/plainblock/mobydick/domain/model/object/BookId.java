package io.github.plainblock.mobydick.domain.model.object;

import java.security.InvalidParameterException;
import java.util.UUID;

public record BookId(String value) {

    public BookId {
        if (value == null || value.isBlank()) {
            throw new InvalidParameterException("BookId must have string value");
        }
    }

    public static BookId generate() {
        return new BookId(UUID.randomUUID().toString());
    }

}
