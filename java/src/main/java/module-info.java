module mobydick {
    requires java.persistence;
    requires javafx.controls;
    requires javafx.fxml;

    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires org.kordamp.bootstrapfx.core;
    requires org.slf4j;

    opens io.github.plainblock.mobydick to javafx.fxml;
    opens io.github.plainblock.mobydick.controller to javafx.fxml;
    opens io.github.plainblock.mobydick.infrastructure.google.json to com.fasterxml.jackson.databind;
    opens io.github.plainblock.mobydick.infrastructure.sqlite.table;

    exports io.github.plainblock.mobydick;
    exports io.github.plainblock.mobydick.controller;
}