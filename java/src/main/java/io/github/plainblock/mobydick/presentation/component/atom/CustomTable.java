package io.github.plainblock.mobydick.presentation.component.atom;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class CustomTable extends JTable {

    public CustomTable() {
        this(null, null, null);
    }

    public CustomTable(TableModel dm) {
        this(dm, null, null);
    }

    public CustomTable(TableModel dm, TableColumnModel cm) {
        this(dm, cm, null);
    }

    public CustomTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
        super(dm, cm, sm);
        customize();
    }

    public CustomTable(int numRows, int numColumns) {
        super(numRows, numColumns);
        customize();
    }

    public CustomTable(Vector<? extends Vector> rowData, Vector<?> columnNames) {
        super(rowData, columnNames);
        customize();
    }

    public CustomTable(final Object[][] rowData, final Object[] columnNames) {
        super(rowData, columnNames);
        customize();
    }

    private void customize() {
        setAutoCreateRowSorter(true);
        setRowHeight(20);
    }

}
