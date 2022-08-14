package io.github.plainblock.mobydick.presentation.component.block;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import io.github.plainblock.mobydick.presentation.component.atom.CustomTable;

public class ManagementTablePanel extends JPanel {

    private static final String[] COLUMNS = {"題名", "著者", "出版社", "ステータス"};

    private CustomTable managementTable;

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
        managementTable = new CustomTable(model);
        managementTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(managementTable);
        scrollPane.setPreferredSize(new Dimension(600, 300));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);
    }

}
