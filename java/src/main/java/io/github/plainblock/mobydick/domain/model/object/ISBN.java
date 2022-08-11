package io.github.plainblock.mobydick.domain.model.object;

import java.security.InvalidParameterException;

public record ISBN(String value) {

    public ISBN {
        if (value == null || value.isBlank()) {
            throw new InvalidParameterException("ISBN must have string value");
        }
        value = value.trim().replaceAll("-", "");
    }

}
