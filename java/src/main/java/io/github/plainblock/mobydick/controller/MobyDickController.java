package io.github.plainblock.mobydick.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.factory.MobyDickFactory;
import io.github.plainblock.mobydick.service.ManagementService;
import io.github.plainblock.mobydick.service.ReferenceService;

public class MobyDickController {

    private final ReferenceService referenceService;
    private final ManagementService managementService;

    public MobyDickController() {
        this.referenceService = MobyDickFactory.getReferenceService();
        this.managementService = MobyDickFactory.getManagementService();
    }

    @FXML
    private Label welcomeText;

    @FXML
    private Label processingTime;

    @FXML
    private void onHelloButtonClick() {
        measureTime(() -> welcomeText.setText("Welcome to JavaFX Application!"));
    }

    @FXML
    private void onReference() {
        measureTime(() -> {
            Book book = referenceService.findByISBN("9780810102699");
            welcomeText.setText(book.getTitle() + ", " + book.getAuthor() + ", " + book.getPublisher());
        });
    }

    @FXML
    private void onManagement() {
        measureTime(() -> {
            Book book = managementService.findById("SAMPLE");
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