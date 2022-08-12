package io.github.plainblock.mobydick.presentation.controller;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.presentation.view.MobyDickView;
import io.github.plainblock.mobydick.service.ManagementService;
import io.github.plainblock.mobydick.service.ReferenceService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MobyDickController implements ActionListener {

    private final ReferenceService reference;
    private final ManagementService management;

    private MobyDickView view;

    public MobyDickController(ReferenceService reference, ManagementService management) {
        this.reference = reference;
        this.management = management;
    }

    public MobyDickView getView() {
        return view;
    }

    public void linkView(MobyDickView view) {
        this.view = view;
        this.view.getWelcomeButton().addActionListener(this);
        this.view.getWelcomeButton().setActionCommand("welcome");
        this.view.getReferenceButton().addActionListener(this);
        this.view.getReferenceButton().setActionCommand("reference");
        this.view.getManagementButton().addActionListener(this);
        this.view.getManagementButton().setActionCommand("management");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "welcome" -> onHelloButtonClick();
            case "reference" -> onReference();
            case "management" -> onManagement();
        }
    }

    private void onHelloButtonClick() {
        measureTime(() -> view.getProcessMessageLabel().setText("Welcome to Swing Application!"));
    }

    private void onReference() {
        measureTime(() -> {
            String isbn = view.getIsbnInputField().getText();
//            Book book = reference.findByISBN("9780810102699");
            Book book = reference.findByISBN(isbn);
            if (book != null) {
                view.getProcessMessageLabel().setText(book.getTitle() + ", " + book.getAuthor() + ", " + book.getPublisher());
            } else {
                view.getProcessMessageLabel().setText("Target book is not found");
            }
        });
    }

    private void onManagement() {
        measureTime(() -> {
            Book book = management.findById("SAMPLE");
            view.getProcessMessageLabel().setText(book.getTitle() + ", " + book.getStatus().label());
        });
    }

    private void measureTime(Runnable callback) {
        long start = System.currentTimeMillis();
        callback.run();
        long end = System.currentTimeMillis();
        view.getProcessTimeLabel().setText(String.format("%d ms", end - start));
    }

}