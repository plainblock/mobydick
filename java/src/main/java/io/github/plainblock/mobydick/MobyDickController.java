package io.github.plainblock.mobydick;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MobyDickController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

}