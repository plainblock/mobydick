package io.github.plainblock.mobydick.presentation.controller;

import java.awt.event.ActionEvent;
import java.util.List;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.model.object.BookStatus;
import io.github.plainblock.mobydick.presentation.view.ManagementView;
import io.github.plainblock.mobydick.service.ManagementService;

public class ManagementController extends BaseController {

    private static final String GET = "get";
    private static final String NOT_PURCHASED = "notPurchased";
    private static final String NOT_YET_READ = "notYetRead";
    private static final String ALREADY_READ = "alreadyRead";

    private final ManagementService managementService;

    private final ManagementView managementView;

    public ManagementController(ManagementService managementService, ManagementView managementView) {
        this.managementService = managementService;
        this.managementView = managementView;
        this.managementView.initGetAction(this, GET);
        this.managementView.initWantToAction(this, NOT_PURCHASED);
        this.managementView.initNotYetAction(this, NOT_YET_READ);
        this.managementView.initAlreadyAction(this, ALREADY_READ);
    }

    public ManagementView getView() {
        return managementView;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case GET -> onGet();
            case NOT_PURCHASED -> onWantToRead();
            case NOT_YET_READ -> onNotYetRead();
            case ALREADY_READ -> onAlreadyRead();
        }
    }

    private void onGet() {
        managementView.setProcessTime(
                measureTime(() -> {
                    String keyword = managementView.getKeywordValue();
                    BookStatus status = BookStatus.fromLabel(managementView.getStatusValue());
                    String message = managementService.loadBooks(keyword, status);
                    setBookData(managementService.getManagedBooks());
                    managementView.setResultMessage(message);
                })
        );
    }

    private void onWantToRead() {
        managementView.setProcessTime(
                measureTime(() -> {
                    int index = managementView.getSelectedIndex();
                    Book book = managementService.getManagedBooks().get(index);
                    String message = managementService.updateBookStatus(book, BookStatus.NOT_PURCHASED);
                    setBookData(managementService.getManagedBooks());
                    managementView.setResultMessage(message);
                })
        );
    }

    private void onNotYetRead() {
        managementView.setProcessTime(
                measureTime(() -> {
                    int index = managementView.getSelectedIndex();
                    Book book = managementService.getManagedBooks().get(index);
                    String message = managementService.updateBookStatus(book, BookStatus.NOT_YET_READ);
                    setBookData(managementService.getManagedBooks());
                    managementView.setResultMessage(message);
                })
        );
    }

    private void onAlreadyRead() {
        managementView.setProcessTime(
                measureTime(() -> {
                    int index = managementView.getSelectedIndex();
                    Book book = managementService.getManagedBooks().get(index);
                    String message = managementService.updateBookStatus(book, BookStatus.ALREADY_READ);
                    setBookData(managementService.getManagedBooks());
                    managementView.setResultMessage(message);
                })
        );
    }

    private void setBookData(List<Book> books) {
        if (books == null || books.isEmpty()) {
            managementView.setTableData(null);
        } else {
            String[][] data = new String[books.size()][4];
            for (int i = 0; i < books.size(); i++) {
                data[i] = books.get(i).toRowManagementData();
            }
            managementView.setTableData(data);
        }
    }
}
