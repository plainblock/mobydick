package io.github.plainblock.mobydick.domain.model.object;

public enum BookStatus {
    WANT_TO_READ(0, "未読"),
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
        return BookStatus.WANT_TO_READ;
    }

}
