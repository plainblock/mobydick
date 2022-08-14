package io.github.plainblock.mobydick.presentation.component.block;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ManagementTablePanel extends JPanel {

    private static final String[] COLUMNS = {"題名", "著者", "出版社", "ステータス"};

    private JTable managementTable;

    public ManagementTablePanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initManagementTable();
    }

    public int getSelectedIndex() {
        return managementTable.getSelectedRow();
    }

    public void setTableData(String[][] tableData) {
        if (tableData == null || tableData.length == 0) {
            managementTable.setModel(new DefaultTableModel(COLUMNS, 10));
            return;
        }
        managementTable.setModel(new DefaultTableModel(tableData, COLUMNS));
    }

    private void initManagementTable() {
        TableModel model = new DefaultTableModel(COLUMNS, 10);
        managementTable = new JTable(model);
        managementTable.setAutoCreateRowSorter(true);
        managementTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane managementTablePane = new JScrollPane(managementTable);
        managementTablePane.setPreferredSize(new Dimension(600, 300));
        managementTablePane.setMaximumSize(new Dimension(600, 300));
        add(managementTablePane);
    }

}
