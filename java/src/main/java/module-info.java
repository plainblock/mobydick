module io.github.plainblock.mobydick {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens io.github.plainblock.mobydick to javafx.fxml;
    exports io.github.plainblock.mobydick;
}