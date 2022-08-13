package io.github.plainblock.mobydick.domain.model.object;

import java.util.ArrayList;
import java.util.List;

public enum BookStatus {
    NOT_PURCHASED(0, "未購入"),
    NOT_YET_READ(1, "積読"),
    ALREADY_READ(2, "既読"),
    ;
    private final int code;
    private final String label;

    BookStatus(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int code() {
        return code;
    }

    public String label() {
        return label;
    }

    public static BookStatus fromCode(int code) {
        for (BookStatus status : BookStatus.values()) {
            if (status.code == code) {
                return status;
            }
        }
        return null;
    }

    public static BookStatus fromLabel(String label) {
        for (BookStatus status : BookStatus.values()) {
            if (status.label.equals(label)) {
                return status;
            }
        }
        return null;
    }

    public static String[] toArray(boolean withAll) {
        List<String> list = new ArrayList<>();
        if (withAll) {
            list.add("すべて");
        }
        for (BookStatus status : BookStatus.values()) {
            list.add(status.label);
        }
        return list.toArray(new String[0]);
    }

}
