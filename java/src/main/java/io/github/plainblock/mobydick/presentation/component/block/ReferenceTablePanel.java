package io.github.plainblock.mobydick.presentation.component.block;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import io.github.plainblock.mobydick.presentation.component.atom.CustomButton;
import io.github.plainblock.mobydick.presentation.component.atom.CustomTable;
import io.github.plainblock.mobydick.presentation.component.atom.CustomText;
import io.github.plainblock.mobydick.presentation.component.atom.CustomTextLabel;

public class ReferenceTablePanel extends JPanel {

    public static final int ROW_COUNT = 10;
    private static final String[] COLUMNS = {"題名", "著者", "出版社", "出版日", "ISBN"};

    private CustomTable referenceTable;
    private CustomTextLabel pageLabel;
    private CustomButton backButton;
    private CustomButton nextButton;
    private CustomText titleText;
    private CustomText authorText;
    private CustomText publisherText;
    private CustomText publishedDateText;
    private CustomText isbnText;
    private CustomText urlText;
    private String[][] data;

    public ReferenceTablePanel() {
        super();
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[]{60, 220, 40, 280};
        setLayout(layout);
        initReferenceTable(layout);
        initPageLabel(layout);
        initBackButton(layout);
        initNextButton(layout);
        initTitleLabel(layout);
        initTitleText(layout);
        initAuthorLabel(layout);
        initAuthorText(layout);
        initPublisherLabel(layout);
        initPublisherText(layout);
        initPublishedDateLabel(layout);
        initPublishedDateText(layout);
        initIsbnLabel(layout);
        initIsbnText(layout);
        initUrlLabel(layout);
        initUrlText(layout);
        resetSelectedValue();
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
            this.data = null;
            return;
        }
        referenceTable.setModel(new DefaultTableModel(tableData, COLUMNS));
        pageLabel.setText(String.valueOf(page));
        this.data = tableData;
    }

    public void assignBackButtonAction(ActionListener listener, String command) {
        backButton.addActionListener(listener);
        backButton.setActionCommand(command);
    }

    public void assignNextButtonAction(ActionListener listener, String command) {
        nextButton.addActionListener(listener);
        nextButton.setActionCommand(command);
    }

    private void setSelectedValue(int index) {
        if (index < 0 || this.data == null) {
            resetSelectedValue();
            return;
        }
        String title = data[index][0];
        String author = data[index][1];
        String publisher = data[index][2];
        String publishedDate = data[index][3];
        String isbn = data[index][4];
        String url = data[index][5];
        titleText.setText(title);
        authorText.setText(author);
        publisherText.setText(publisher);
        publishedDateText.setText(publishedDate);
        isbnText.setText(isbn);
        urlText.setText(url);
    }

    private void resetSelectedValue() {
        titleText.setText("");
        authorText.setText("");
        publisherText.setText("");
        publishedDateText.setText("");
        isbnText.setText("");
        urlText.setText("");
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
        gbc.gridwidth = 4;
        layout.setConstraints(scrollPane, gbc);
        add(scrollPane);
    }

    private void initPageLabel(GridBagLayout layout) {
        pageLabel = new CustomTextLabel(String.valueOf(0));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        layout.setConstraints(pageLabel, gbc);
        add(pageLabel);
    }

    private void initBackButton(GridBagLayout layout) {
        backButton = new CustomButton("◀", 10);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        layout.setConstraints(backButton, gbc);
        add(backButton);
    }

    private void initNextButton(GridBagLayout layout) {
        nextButton = new CustomButton("▶", 10);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(nextButton, gbc);
        add(nextButton);
    }

    private void initTitleLabel(GridBagLayout layout) {
        CustomTextLabel titleLabel = new CustomTextLabel("題名：");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(titleLabel, gbc);
        add(titleLabel);
    }

    private void initTitleText(GridBagLayout layout) {
        titleText = new CustomText();
        titleText.setPreferredSize(new Dimension(540, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(titleText, gbc);
        add(titleText);
    }

    private void initAuthorLabel(GridBagLayout layout) {
        CustomTextLabel authorLabel = new CustomTextLabel("著者：");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(authorLabel, gbc);
        add(authorLabel);
    }

    private void initAuthorText(GridBagLayout layout) {
        authorText = new CustomText();
        authorText.setPreferredSize(new Dimension(540, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(authorText, gbc);
        add(authorText);
    }

    private void initPublisherLabel(GridBagLayout layout) {
        CustomTextLabel publisherLabel = new CustomTextLabel("出版社：");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(publisherLabel, gbc);
        add(publisherLabel);
    }

    private void initPublisherText(GridBagLayout layout) {
        publisherText = new CustomText();
        publisherText.setPreferredSize(new Dimension(540, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(publisherText, gbc);
        add(publisherText);
    }

    private void initPublishedDateLabel(GridBagLayout layout) {
        CustomTextLabel publishedDateLabel = new CustomTextLabel("出版日：");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(publishedDateLabel, gbc);
        add(publishedDateLabel);
    }

    private void initPublishedDateText(GridBagLayout layout) {
        publishedDateText = new CustomText();
        publishedDateText.setPreferredSize(new Dimension(540, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(publishedDateText, gbc);
        add(publishedDateText);
    }

    private void initIsbnLabel(GridBagLayout layout) {
        CustomTextLabel isbnLabel = new CustomTextLabel("ISBN：");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(isbnLabel, gbc);
        add(isbnLabel);
    }

    private void initIsbnText(GridBagLayout layout) {
        isbnText = new CustomText();
        isbnText.setPreferredSize(new Dimension(540, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(isbnText, gbc);
        add(isbnText);
    }

    private void initUrlLabel(GridBagLayout layout) {
        CustomTextLabel urlLabel = new CustomTextLabel("URL：");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(urlLabel, gbc);
        add(urlLabel);
    }

    private void initUrlText(GridBagLayout layout) {
        urlText = new CustomText();
        urlText.setPreferredSize(new Dimension(540, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(urlText, gbc);
        add(urlText);
    }

}
