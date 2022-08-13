package io.github.plainblock.mobydick.presentation.controller;

import java.awt.event.ActionEvent;
import java.util.List;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.model.object.BookStatus;
import io.github.plainblock.mobydick.presentation.view.ReferenceView;
import io.github.plainblock.mobydick.service.ManagementService;
import io.github.plainblock.mobydick.service.ReferenceService;

public class ReferenceController extends BaseController {

    private static final String FETCH = "fetch";
    private static final String REGISTER = "register";

    private final ReferenceService referenceService;
    private final ManagementService managementService;
    private final ReferenceView referenceView;

    public ReferenceController(ReferenceService referenceService, ManagementService managementService, ReferenceView referenceView) {
        this.referenceService = referenceService;
        this.managementService = managementService;
        this.referenceView = referenceView;
        this.referenceView.initFetchAction(this, FETCH);
        this.referenceView.initRegisterAction(this, REGISTER);
    }

    public ReferenceView getView() {
        return referenceView;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case FETCH -> onFetch();
            case REGISTER -> onRegister();
        }
    }

    private void onFetch() {
        referenceView.setProcessTime(
                measureTime(() -> {
                    String title = referenceView.getTitleValue();
                    String author = referenceView.getAuthorValue();
                    String publisher = referenceView.getPublisherValue();
                    if (title.isBlank() && author.isBlank() && publisher.isBlank()) {
                        referenceView.setResultMessage("検索条件を入力してください");
                        return;
                    }
                    String message = referenceService.findWithCondition(title, author, publisher);
                    setBookData(referenceService.getFetchedBooks());
                    referenceView.setResultMessage(message);
                })
        );
    }

    private void onRegister() {
        referenceView.setProcessTime(
                measureTime(() -> {
                    int index = referenceView.getSelectedIndex();
                    Book book = referenceService.getFetchedBooks().get(index);
                    BookStatus status = BookStatus.fromLabel(referenceView.getStatusValue());
                    String message = managementService.registerBook(book, status);
                    referenceView.setResultMessage(message);
                })
        );
    }

    private void setBookData(List<Book> books) {
        if (books == null || books.isEmpty()) {
            referenceView.setTableData(null);
        } else {
            String[][] data = new String[books.size()][4];
            for (int i = 0; i < books.size(); i++) {
                data[i] = books.get(i).toRowReferenceData();
            }
            referenceView.setTableData(data);
        }
    }

}
