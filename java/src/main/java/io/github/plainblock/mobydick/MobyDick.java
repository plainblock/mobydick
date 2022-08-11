package io.github.plainblock.mobydick;

import java.io.IOException;
import javax.swing.JFrame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import io.github.plainblock.mobydick.presentation.view.MobyDickView;

//public class MobyDick extends Application {
    public class MobyDick {

    private static final String TITLE = "MobyDick Java edition";
    private static final String FXML = "moby-dick.fxml";
    private static final String CSS = "moby-dick.css";
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    public static void main(String[] args) {
        MobyDickView view = new MobyDickView(TITLE, WIDTH, HEIGHT);
//        launch(args);
    }

//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader root = new FXMLLoader(MobyDick.class.getResource(FXML));
//
//        Scene scene = new Scene(root.load(), WIDTH, HEIGHT);
//        scene.getStylesheets().add(MobyDick.class.getResource(CSS).toExternalForm());
//
//        stage.setTitle(TITLE);
//        stage.setScene(scene);
//        stage.show();
//    }

}