package io.github.plainblock.mobydick.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.factory.MobyDickFactory;
import io.github.plainblock.mobydick.presentation.view.MobyDickView;
import io.github.plainblock.mobydick.service.ManagementService;
import io.github.plainblock.mobydick.service.ReferenceService;

public class MobyDickController {

    private final ReferenceService reference;
    private final ManagementService management;

    private MobyDickView view;

    public MobyDickController() {
        this.reference = MobyDickFactory.getReferenceService();
        this.management = MobyDickFactory.getManagementService();
    }

    public MobyDickController(ReferenceService reference, ManagementService management) {
        this.reference = reference;
        this.management = management;
    }

    public void setup() {
        this.view = new MobyDickView();
    }

    public MobyDickView getView() {
        return view;
    }

    @FXML
    private Label welcomeText;

    @FXML
    private Label processingTime;

    @FXML
    public void onHelloButtonClick() {
        measureTime(() -> welcomeText.setText("Welcome to JavaFX Application!"));
    }

    @FXML
    public void onReference() {
        measureTime(() -> {
            Book book = reference.findByISBN("9780810102699");
            welcomeText.setText(book.getTitle() + ", " + book.getAuthor() + ", " + book.getPublisher());
        });
    }

    @FXML
    public void onManagement() {
        measureTime(() -> {
            Book book = management.findById("SAMPLE");
            welcomeText.setText(book.getTitle() + ", " + book.getStatus().label());
        });
    }

    private void measureTime(Runnable callback) {
        long start = System.currentTimeMillis();
        callback.run();
        long end = System.currentTimeMillis();
        processingTime.setText(String.format("%d ms", end - start));
    }

}