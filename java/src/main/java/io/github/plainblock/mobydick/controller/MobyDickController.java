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
    private void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void onMobyDick() {
        Book book = referenceService.findByISBN("9780810102699");
        welcomeText.setText(book.getTitle());
    }

}