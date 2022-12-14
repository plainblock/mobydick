package io.github.plainblock.mobydick.presentation.controller;

import java.awt.event.ActionEvent;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.model.object.BookStatus;
import io.github.plainblock.mobydick.presentation.view.ManagementView;
import io.github.plainblock.mobydick.service.ManagementService;

public class ManagementController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManagementController.class);
    private static final String GET = "get";
    private static final String NOT_PURCHASED = "notPurchased";
    private static final String NOT_YET_READ = "notYetRead";
    private static final String ALREADY_READ = "alreadyRead";

    private final ManagementService managementService;
    private final ManagementView managementView;

    public ManagementController(ManagementService managementService, ManagementView managementView) {
        this.managementService = managementService;
        this.managementView = managementView;
        this.managementView.assignGetAction(this, GET);
        this.managementView.assignWantToAction(this, NOT_PURCHASED);
        this.managementView.assignNotYetAction(this, NOT_YET_READ);
        this.managementView.assignAlreadyAction(this, ALREADY_READ);
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
        LOGGER.info("onGet");
        try {
            managementView.setProcessTime(
                    measureTime(() -> {
                        String title = managementView.getTitleValue();
                        String author = managementView.getAuthorValue();
                        BookStatus status = BookStatus.fromLabel(managementView.getStatusValue());
                        String message = managementService.loadBooks(title, author, status);
                        setBookData(managementService.getManagedBooks());
                        managementView.setResultMessage(message);
                    })
            );
        } catch (Exception e) {
            managementView.setResultMessage(formatErrorMessage(e));
            LOGGER.error("Error occurred!", e);
        }
    }

    private void onWantToRead() {
        LOGGER.info("onWantToRead");
        try {
            managementView.setProcessTime(
                    measureTime(() -> {
                        int index = managementView.getSelectedIndex();
                        if (index < 0) {
                            setIndexErrorMessage();
                            return;
                        }
                        String message = managementService.updateBookStatus(index, BookStatus.NOT_PURCHASED);
                        setBookData(managementService.getManagedBooks());
                        managementView.setResultMessage(message);
                    })
            );
        } catch (Exception e) {
            managementView.setResultMessage(formatErrorMessage(e));
            LOGGER.error("Error occurred!", e);
        }
    }

    private void onNotYetRead() {
        LOGGER.info("onNotYetRead");
        try {
            managementView.setProcessTime(
                    measureTime(() -> {
                        int index = managementView.getSelectedIndex();
                        if (index < 0) {
                            setIndexErrorMessage();
                            return;
                        }
                        String message = managementService.updateBookStatus(index, BookStatus.NOT_YET_READ);
                        setBookData(managementService.getManagedBooks());
                        managementView.setResultMessage(message);
                    })
            );
        } catch (Exception e) {
            managementView.setResultMessage(formatErrorMessage(e));
            LOGGER.error("Error occurred!", e);
        }
    }

    private void onAlreadyRead() {
        LOGGER.info("onAlreadyRead");
        try {
            managementView.setProcessTime(
                    measureTime(() -> {
                        int index = managementView.getSelectedIndex();
                        if (index < 0) {
                            setIndexErrorMessage();
                            return;
                        }
                        String message = managementService.updateBookStatus(index, BookStatus.ALREADY_READ);
                        setBookData(managementService.getManagedBooks());
                        managementView.setResultMessage(message);
                    })
            );
        } catch (Exception e) {
            managementView.setResultMessage(formatErrorMessage(e));
            LOGGER.error("Error occurred!", e);
        }
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

    private void setIndexErrorMessage() {
        managementView.setResultMessage("?????????????????????????????????????????????");
    }

}
