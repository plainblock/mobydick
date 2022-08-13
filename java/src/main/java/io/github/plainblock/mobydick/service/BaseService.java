package io.github.plainblock.mobydick.service;

public class BaseService {

    String formatErrorMessage(Exception exception) {
        return String.format("処理中にエラーが発生しました：%s", exception.getMessage());
    }

}
