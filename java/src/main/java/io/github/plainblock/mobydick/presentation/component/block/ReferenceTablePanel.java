package io.github.plainblock.mobydick.presentation.component.block;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import io.github.plainblock.mobydick.presentation.component.atom.CustomButton;
import io.github.plainblock.mobydick.presentation.component.atom.CustomTable;
import io.github.plainblock.mobydick.presentation.component.atom.CustomTextLabel;

public class ReferenceTablePanel extends JPanel {

    public static final int ROW_COUNT = 10;
    private static final String[] COLUMNS = {"題名", "著者", "出版社", "出版日", "ISBN"};

    private CustomTable referenceTable;
    private CustomTextLabel pageLabel;
    private CustomButton backButton;
    private CustomButton nextButton;
    private CustomTextLabel titleLabel;
    private CustomTextLabel authorLabel;
    private CustomTextLabel publisherLabel;
    private CustomTextLabel publishedDateLabel;
    private CustomTextLabel isbnLabel;

    public ReferenceTablePanel() {
        super();
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[]{280, 40, 280};
        setLayout(layout);
        initReferenceTable(layout);
        initPageLabel(layout);
        initBackButton(layout);
        initNextButton(layout);
        initTitleLabel(layout);
        initAuthorLabel(layout);
        initPublisherLabel(layout);
        initPublishedDateLabel(layout);
        initIsbnLabel(layout);
        initSelectedValue();
    }

    public int getSelectedIndex() {
        return referenceTable.getSelectedRow();
    }

    public int getSelectedPage() {
        return Integer.parseInt(pageLabel.getText());
    }

    public void setTableData(String[][] tableData, int page) {
        if (tableData == null || tableData.length == 0) {
            referenceTable.setModel(new DefaultTableModel(COLUMNS, ROW_COUNT));
            pageLabel.setText(String.valueOf(page));
            return;
        }
        referenceTable.setModel(new DefaultTableModel(tableData, COLUMNS));
        pageLabel.setText(String.valueOf(page));
    }

    public void initBackButtonAction(ActionListener listener, String command) {
        backButton.addActionListener(listener);
        backButton.setActionCommand(command);
    }

    public void initNextButtonAction(ActionListener listener, String command) {
        nextButton.addActionListener(listener);
        nextButton.setActionCommand(command);
    }

    private void setSelectedValue(int index) {
        if (index < 0) {
            initSelectedValue();
            return;
        }
        Object title = referenceTable.getValueAt(index, 0);
        Object author = referenceTable.getValueAt(index, 1);
        Object publisher = referenceTable.getValueAt(index, 2);
        Object publishedDate = referenceTable.getValueAt(index, 3);
        Object isbn = referenceTable.getValueAt(index, 4);
        titleLabel.setText(String.format("題名：%s", title != null ? title : ""));
        authorLabel.setText(String.format("著者：%s", author != null ? author : ""));
        publisherLabel.setText(String.format("出版社：%s", publisher != null ? publisher : ""));
        publishedDateLabel.setText(String.format("出版日：%s", publishedDate != null ? publishedDate : ""));
        isbnLabel.setText(String.format("ISBN：%s", isbn != null ? isbn : ""));
    }

    private void initReferenceTable(GridBagLayout layout) {
        // Initialize table
        TableModel model = new DefaultTableModel(COLUMNS, 10);
        referenceTable = new CustomTable(model);
        referenceTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        referenceTable.getSelectionModel().addListSelectionListener(event -> setSelectedValue(referenceTable.getSelectedRow()));

        // Setting pane
        JScrollPane scrollPane = new JScrollPane(referenceTable);
        scrollPane.setPreferredSize(new Dimension(600, 225));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        layout.setConstraints(scrollPane, gbc);
        add(scrollPane);
    }

    private void initPageLabel(GridBagLayout layout) {
        pageLabel = new CustomTextLabel(String.valueOf(0));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        layout.setConstraints(pageLabel, gbc);
        add(pageLabel);
    }

    private void initBackButton(GridBagLayout layout) {
        backButton = new CustomButton("◀", 10);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        layout.setConstraints(backButton, gbc);
        add(backButton);
    }

    private void initNextButton(GridBagLayout layout) {
        nextButton = new CustomButton("▶", 10);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(nextButton, gbc);
        add(nextButton);
    }

    private void initSelectedValue() {
        titleLabel.setText("題名：");
        authorLabel.setText("著者：");
        publisherLabel.setText("出版社：");
        publishedDateLabel.setText("出版日：");
        isbnLabel.setText("ISBN：");
    }

    private void initTitleLabel(GridBagLayout layout) {
        titleLabel = new CustomTextLabel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(titleLabel, gbc);
        add(titleLabel);
    }

    private void initAuthorLabel(GridBagLayout layout) {
        authorLabel = new CustomTextLabel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(authorLabel, gbc);
        add(authorLabel);
    }

    private void initPublisherLabel(GridBagLayout layout) {
        publisherLabel = new CustomTextLabel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(publisherLabel, gbc);
        add(publisherLabel);
    }

    private void initPublishedDateLabel(GridBagLayout layout) {
        publishedDateLabel = new CustomTextLabel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(publishedDateLabel, gbc);
        add(publishedDateLabel);
    }

    private void initIsbnLabel(GridBagLayout layout) {
        isbnLabel = new CustomTextLabel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(isbnLabel, gbc);
        add(isbnLabel);
    }

}
