module mobydick {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires org.kordamp.bootstrapfx.core;
    requires org.slf4j;

    opens io.github.plainblock.mobydick to javafx.fxml;
    opens io.github.plainblock.mobydick.infrastructure.google.data to com.fasterxml.jackson.databind;

    exports io.github.plainblock.mobydick;
    exports io.github.plainblock.mobydick.controller;
    opens io.github.plainblock.mobydick.controller to javafx.fxml;
}