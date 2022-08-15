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
        initPagingButton(layout);
        initTitleText(layout);
        initAuthorText(layout);
        initPublisherText(layout);
        initPublishedDateText(layout);
        initIsbnText(layout);
        initUrlText(layout);
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

    private void initPagingButton(GridBagLayout layout) {
        backButton = new CustomButton("◀", 10);
        GridBagConstraints backButtonConst = new GridBagConstraints();
        backButtonConst.gridx = 1;
        backButtonConst.gridy = 1;
        backButtonConst.anchor = GridBagConstraints.EAST;
        layout.setConstraints(backButton, backButtonConst);
        add(backButton);

        pageLabel = new CustomTextLabel(String.valueOf(0));
        GridBagConstraints labelConst = new GridBagConstraints();
        labelConst.gridx = 2;
        labelConst.gridy = 1;
        layout.setConstraints(pageLabel, labelConst);
        add(pageLabel);

        nextButton = new CustomButton("▶", 10);
        GridBagConstraints nextButtonConst = new GridBagConstraints();
        nextButtonConst.gridx = 3;
        nextButtonConst.gridy = 1;
        nextButtonConst.anchor = GridBagConstraints.WEST;
        layout.setConstraints(nextButton, nextButtonConst);
        add(nextButton);
    }

    private void initTitleText(GridBagLayout layout) {
        CustomTextLabel titleLabel = new CustomTextLabel("題名：");
        GridBagConstraints labelConst = new GridBagConstraints();
        labelConst.gridx = 0;
        labelConst.gridy = 2;
        labelConst.anchor = GridBagConstraints.WEST;
        layout.setConstraints(titleLabel, labelConst);
        add(titleLabel);

        titleText = new CustomText();
        titleText.setPreferredSize(new Dimension(540, 20));
        GridBagConstraints textConst = new GridBagConstraints();
        textConst.gridx = 1;
        textConst.gridy = 2;
        textConst.gridwidth = 3;
        textConst.anchor = GridBagConstraints.WEST;
        layout.setConstraints(titleText, textConst);
        add(titleText);
    }

    private void initAuthorText(GridBagLayout layout) {
        CustomTextLabel authorLabel = new CustomTextLabel("著者：");
        GridBagConstraints labelConst = new GridBagConstraints();
        labelConst.gridx = 0;
        labelConst.gridy = 3;
        labelConst.anchor = GridBagConstraints.WEST;
        layout.setConstraints(authorLabel, labelConst);
        add(authorLabel);

        authorText = new CustomText();
        authorText.setPreferredSize(new Dimension(540, 20));
        GridBagConstraints textConst = new GridBagConstraints();
        textConst.gridx = 1;
        textConst.gridy = 3;
        textConst.gridwidth = 3;
        textConst.anchor = GridBagConstraints.WEST;
        layout.setConstraints(authorText, textConst);
        add(authorText);
    }

    private void initPublisherText(GridBagLayout layout) {
        CustomTextLabel publisherLabel = new CustomTextLabel("出版社：");
        GridBagConstraints labelConst = new GridBagConstraints();
        labelConst.gridx = 0;
        labelConst.gridy = 4;
        labelConst.anchor = GridBagConstraints.WEST;
        layout.setConstraints(publisherLabel, labelConst);
        add(publisherLabel);

        publisherText = new CustomText();
        publisherText.setPreferredSize(new Dimension(540, 20));
        GridBagConstraints textConst = new GridBagConstraints();
        textConst.gridx = 1;
        textConst.gridy = 4;
        textConst.gridwidth = 3;
        textConst.anchor = GridBagConstraints.WEST;
        layout.setConstraints(publisherText, textConst);
        add(publisherText);
    }

    private void initPublishedDateText(GridBagLayout layout) {
        CustomTextLabel publishedDateLabel = new CustomTextLabel("出版日：");
        GridBagConstraints labelConst = new GridBagConstraints();
        labelConst.gridx = 0;
        labelConst.gridy = 5;
        labelConst.anchor = GridBagConstraints.WEST;
        layout.setConstraints(publishedDateLabel, labelConst);
        add(publishedDateLabel);

        publishedDateText = new CustomText();
        publishedDateText.setPreferredSize(new Dimension(540, 20));
        GridBagConstraints textConst = new GridBagConstraints();
        textConst.gridx = 1;
        textConst.gridy = 5;
        textConst.gridwidth = 3;
        textConst.anchor = GridBagConstraints.WEST;
        layout.setConstraints(publishedDateText, textConst);
        add(publishedDateText);
    }

    private void initIsbnText(GridBagLayout layout) {
        CustomTextLabel isbnLabel = new CustomTextLabel("ISBN：");
        GridBagConstraints labelConst = new GridBagConstraints();
        labelConst.gridx = 0;
        labelConst.gridy = 6;
        labelConst.anchor = GridBagConstraints.WEST;
        layout.setConstraints(isbnLabel, labelConst);
        add(isbnLabel);

        isbnText = new CustomText();
        isbnText.setPreferredSize(new Dimension(540, 20));
        GridBagConstraints textConst = new GridBagConstraints();
        textConst.gridx = 1;
        textConst.gridy = 6;
        textConst.gridwidth = 3;
        textConst.anchor = GridBagConstraints.WEST;
        layout.setConstraints(isbnText, textConst);
        add(isbnText);
    }

    private void initUrlText(GridBagLayout layout) {
        CustomTextLabel urlLabel = new CustomTextLabel("URL：");
        GridBagConstraints labelConst = new GridBagConstraints();
        labelConst.gridx = 0;
        labelConst.gridy = 7;
        labelConst.anchor = GridBagConstraints.WEST;
        layout.setConstraints(urlLabel, labelConst);
        add(urlLabel);

        urlText = new CustomText();
        urlText.setPreferredSize(new Dimension(540, 20));
        GridBagConstraints textConst = new GridBagConstraints();
        textConst.gridx = 1;
        textConst.gridy = 7;
        textConst.gridwidth = 3;
        textConst.anchor = GridBagConstraints.WEST;
        layout.setConstraints(urlText, textConst);
        add(urlText);
    }

}
