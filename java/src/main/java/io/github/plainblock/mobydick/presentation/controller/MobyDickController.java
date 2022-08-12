package io.github.plainblock.mobydick.presentation.controller;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.presentation.view.MobyDickView;
import io.github.plainblock.mobydick.service.ManagementService;
import io.github.plainblock.mobydick.service.ReferenceService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

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
            String title = view.getTitleInputField().getText();
            String author = view.getAuthorInputField().getText();
            String publisher = view.getPublisherInputField().getText();
            if (title.isBlank() && author.isBlank() && publisher.isBlank()) {
                view.getProcessMessageLabel().setText("No condition specified");
                return;
            }
            List<Book> books = reference.findWithCondition(title, author, publisher);
            if (books == null || books.isEmpty()) {
                view.getProcessMessageLabel().setText("Target book is not found");
                return;
            }
            String[] columns = {"Title", "Author", "Publisher", "ISBN"};
            String[][] data = new String[books.size()][4];
            for (int i = 0; i < books.size(); i++) {
                data[i] = books.get(i).toRowData();
            }
            DefaultTableModel model = new DefaultTableModel(data, columns);
            view.getReferenceTable().setModel(model);
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