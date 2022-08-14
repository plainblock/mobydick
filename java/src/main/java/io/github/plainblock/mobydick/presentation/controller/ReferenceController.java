package io.github.plainblock.mobydick.presentation.controller;

import java.awt.event.ActionEvent;
import java.util.List;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.model.object.BookStatus;
import io.github.plainblock.mobydick.presentation.component.block.ReferenceTablePanel;
import io.github.plainblock.mobydick.presentation.view.ReferenceView;
import io.github.plainblock.mobydick.service.ManagementService;
import io.github.plainblock.mobydick.service.ReferenceService;

public class ReferenceController extends BaseController {

    private static final String FETCH = "fetch";
    private static final String BACK = "back";
    private static final String NEXT = "next";
    private static final String REGISTER = "register";

    private final ReferenceService referenceService;
    private final ManagementService managementService;
    private final ReferenceView referenceView;

    private String titleCache = "";
    private String authorCache = "";
    private String publisherCache = "";

    public ReferenceController(ReferenceService referenceService, ManagementService managementService, ReferenceView referenceView) {
        this.referenceService = referenceService;
        this.managementService = managementService;
        this.referenceView = referenceView;
        this.referenceView.initFetchAction(this, FETCH);
        this.referenceView.initBackAction(this, BACK);
        this.referenceView.initNextAction(this, NEXT);
        this.referenceView.initRegisterAction(this, REGISTER);
    }

    public ReferenceView getView() {
        return referenceView;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case FETCH -> onFetch();
            case BACK -> onBack();
            case NEXT -> onNext();
            case REGISTER -> onRegister();
        }
    }

    private void onFetch() {
        referenceView.setProcessTime(
                measureTime(() -> {
                    titleCache = referenceView.getTitleValue();
                    authorCache = referenceView.getAuthorValue();
                    publisherCache = referenceView.getPublisherValue();
                    if (titleCache.isBlank() && authorCache.isBlank() && publisherCache.isBlank()) {
                        referenceView.setResultMessage("検索条件を入力してください");
                        return;
                    }
                    String message = referenceService.findWithCondition(titleCache, authorCache, publisherCache, ReferenceTablePanel.ROW_COUNT, 1);
                    setBookData(referenceService.getFetchedBooks(), 1);
                    referenceView.setResultMessage(message);
                })
        );
    }

    private void onBack() {
        referenceView.setProcessTime(
                measureTime(() -> {
                    int page = referenceView.getSelectedPage();
                    if (page <= 1) {
                        return;
                    }
                    page --;
                    String message = referenceService.findWithCondition(titleCache, authorCache, publisherCache, ReferenceTablePanel.ROW_COUNT, page);
                    setBookData(referenceService.getFetchedBooks(), page);
                    referenceView.setResultMessage(message);
                })
        );
    }

    private void onNext() {
        referenceView.setProcessTime(
                measureTime(() -> {
                    int page = referenceView.getSelectedPage();
                    if (page == 0) {
                        return;
                    }
                    if (referenceService.getFetchedBooks().size() < ReferenceTablePanel.ROW_COUNT) {
                        return;
                    }
                    page ++;
                    String message = referenceService.findWithCondition(titleCache, authorCache, publisherCache, ReferenceTablePanel.ROW_COUNT, page);
                    setBookData(referenceService.getFetchedBooks(), page);
                    referenceView.setResultMessage(message);
                })
        );
    }

    private void onRegister() {
        referenceView.setProcessTime(
                measureTime(() -> {
                    int index = referenceView.getSelectedIndex();
                    if (index < 0) {
                        setIndexErrorMessage();
                        return;
                    }
                    Book book = referenceService.getFetchedBooks().get(index);
                    BookStatus status = BookStatus.fromLabel(referenceView.getStatusValue());
                    String message = managementService.registerBook(book, status);
                    referenceView.setResultMessage(message);
                })
        );
    }

    private void setBookData(List<Book> books, int page) {
        if (books == null || books.isEmpty()) {
            referenceView.setTableData(null, page);
        } else {
            String[][] data = new String[books.size()][4];
            for (int i = 0; i < books.size(); i++) {
                data[i] = books.get(i).toRowReferenceData();
            }
            referenceView.setTableData(data, page);
        }
    }

    private void setIndexErrorMessage() {
        referenceView.setResultMessage("登録する書籍を選択してください");
    }

}
