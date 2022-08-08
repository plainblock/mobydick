package io.github.plainblock.mobydick;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MobyDick extends Application {

    private static final String TITLE = "MobyDick Java edition";
    private static final String FXML = "moby-dick.fxml";
    private static final String CSS = "moby-dick.css";
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader root = new FXMLLoader(MobyDick.class.getResource(FXML));

        Scene scene = new Scene(root.load(), WIDTH, HEIGHT);
        scene.getStylesheets().add(MobyDick.class.getResource(CSS).toExternalForm());

        stage.setTitle(TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}