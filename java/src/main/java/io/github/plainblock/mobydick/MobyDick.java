package io.github.plainblock.mobydick;

import java.io.IOException;
import javax.swing.JFrame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import io.github.plainblock.mobydick.controller.MobyDickController;
import io.github.plainblock.mobydick.factory.MobyDickFactory;
import io.github.plainblock.mobydick.presentation.view.MobyDickView;

//public class MobyDick extends Application {
    public class MobyDick extends JFrame {

    private static final String TITLE = "MobyDick Java edition";
    private static final String FXML = "moby-dick.fxml";
    private static final String CSS = "moby-dick.css";
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    private MobyDickController ctrl;

    public static void main(String[] args) {
        MobyDick main = new MobyDick();
        main.start();
//        MobyDickView view = new MobyDickView(TITLE, WIDTH, HEIGHT);
//        launch(args);
    }

    private void start() {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        ctrl = MobyDickFactory.getMobyDickController();
        ctrl.setup();
        add(ctrl.getView());
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