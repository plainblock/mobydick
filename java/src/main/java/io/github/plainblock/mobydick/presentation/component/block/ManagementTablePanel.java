package io.github.plainblock.mobydick.presentation.component.block;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import io.github.plainblock.mobydick.presentation.component.atom.CustomTable;

public class ManagementTablePanel extends JPanel {

    private static final String[] COLUMNS = {"題名", "著者", "登録日", "読了日", "ステータス"};
    private static final int ROW_COUNT = 20;

    private CustomTable managementTable;

    public ManagementTablePanel() {
        super();
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        initManagementTable(layout);
    }

    public int getSelectedIndex() {
        return managementTable.getSelectedRow();
    }

    public void setTableData(String[][] tableData) {
        if (tableData == null || tableData.length == 0) {
            managementTable.setModel(new DefaultTableModel(COLUMNS, ROW_COUNT));
        } else {
            managementTable.setModel(new DefaultTableModel(tableData, COLUMNS));
        }
        adjustManagementTable();
    }

    private void initManagementTable(GridBagLayout layout) {
        // Initialize table
        TableModel model = new DefaultTableModel(COLUMNS, ROW_COUNT);
        managementTable = new CustomTable(model);
        managementTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        adjustManagementTable();

        // Setting pane
        JScrollPane scrollPane = new JScrollPane(managementTable);
        scrollPane.setPreferredSize(new Dimension(600, 390));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        layout.setConstraints(scrollPane, gbc);
        add(scrollPane);
    }

    private void adjustManagementTable() {
        managementTable.getColumnModel().getColumn(2).setMaxWidth(70);
        managementTable.getColumnModel().getColumn(2).setMinWidth(70);
        managementTable.getColumnModel().getColumn(3).setMaxWidth(70);
        managementTable.getColumnModel().getColumn(3).setMinWidth(70);
        managementTable.getColumnModel().getColumn(4).setMaxWidth(70);
        managementTable.getColumnModel().getColumn(4).setMinWidth(70);
    }

}
