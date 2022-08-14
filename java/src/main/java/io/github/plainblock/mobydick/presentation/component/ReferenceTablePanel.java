package io.github.plainblock.mobydick.presentation.component;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import io.github.plainblock.mobydick.presentation.component.atom.CustomTextLabel;

public class ReferenceTablePanel extends JPanel {

    private static final String[] COLUMNS = {"題名", "著者", "出版社", "ISBN"};

    private JTable referenceTable;
    private CustomTextLabel titleLabel;
    private CustomTextLabel authorLabel;
    private CustomTextLabel publisherLabel;
    private CustomTextLabel isbnLabel;

    public ReferenceTablePanel() {
        super();
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        initReferenceTable(layout);
        initTitleLabel(layout);
        initAuthorLabel(layout);
        initPublisherLabel(layout);
        initIsbnLabel(layout);
        initSelectedValue();
    }

    public int getSelectedIndex() {
        return referenceTable.getSelectedRow();
    }

    public void setTableData(String[][] tableData) {
        if (tableData == null || tableData.length == 0) {
            referenceTable.setModel(new DefaultTableModel(COLUMNS, 10));
            return;
        }
        referenceTable.setModel(new DefaultTableModel(tableData, COLUMNS));
    }

    private void setSelectedValue(int index) {
        Object title = referenceTable.getValueAt(index, 0);
        Object author = referenceTable.getValueAt(index, 1);
        Object publisher = referenceTable.getValueAt(index, 2);
        Object isbn = referenceTable.getValueAt(index, 3);
        titleLabel.setText(String.format("題名：%s", title != null ? title : ""));
        authorLabel.setText(String.format("著者：%s", author != null ? author : ""));
        publisherLabel.setText(String.format("出版社：%s", publisher != null ? publisher : ""));
        isbnLabel.setText(String.format("ISBN：%s", isbn != null ? isbn : ""));
    }

    private void initReferenceTable(GridBagLayout layout) {
        // Initialize table
        TableModel model = new DefaultTableModel(COLUMNS, 10);
        referenceTable = new JTable(model);
        referenceTable.setAutoCreateRowSorter(true);
        referenceTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        referenceTable.getSelectionModel().addListSelectionListener(event -> {
            int index = referenceTable.getSelectedRow();
            if (index >= 0) {
                setSelectedValue(index);
            }
        });
        referenceTable.setRowHeight(20);

        // Setting pane
        JScrollPane scrollPane = new JScrollPane(referenceTable);
        scrollPane.setPreferredSize(new Dimension(600, 225));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        layout.setConstraints(scrollPane, gbc);
        add(scrollPane);
    }

    private void initSelectedValue() {
        titleLabel.setText("題名：");
        authorLabel.setText("著者：");
        publisherLabel.setText("出版社：");
        isbnLabel.setText("ISBN：");
    }

    private void initTitleLabel(GridBagLayout layout) {
        titleLabel = new CustomTextLabel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(titleLabel, gbc);
        add(titleLabel);
    }

    private void initAuthorLabel(GridBagLayout layout) {
        authorLabel = new CustomTextLabel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(authorLabel, gbc);
        add(authorLabel);
    }

    private void initPublisherLabel(GridBagLayout layout) {
        publisherLabel = new CustomTextLabel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(publisherLabel, gbc);
        add(publisherLabel);
    }

    private void initIsbnLabel(GridBagLayout layout) {
        isbnLabel = new CustomTextLabel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        layout.setConstraints(isbnLabel, gbc);
        add(isbnLabel);
    }

}
