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

    private static final String[] COLUMNS = {"題名", "著者", "出版社", "ステータス"};

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
            managementTable.setModel(new DefaultTableModel(COLUMNS, 10));
            return;
        }
        managementTable.setModel(new DefaultTableModel(tableData, COLUMNS));
    }

    private void initManagementTable(GridBagLayout layout) {
        // Initialize table
        TableModel model = new DefaultTableModel(COLUMNS, 20);
        managementTable = new CustomTable(model);
        managementTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Setting pane
        JScrollPane scrollPane = new JScrollPane(managementTable);
        scrollPane.setPreferredSize(new Dimension(600, 300));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        layout.setConstraints(scrollPane, gbc);
        add(scrollPane);
    }

}
