package io.github.plainblock.mobydick.presentation.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import io.github.plainblock.mobydick.presentation.component.block.ProcessResultPanel;
import io.github.plainblock.mobydick.presentation.component.block.ReferenceButtonPanel;
import io.github.plainblock.mobydick.presentation.component.block.ReferenceTablePanel;
import io.github.plainblock.mobydick.presentation.component.block.ReferenceFormPanel;

public class ReferenceView extends JPanel {

    private final ReferenceFormPanel formPanel;
    private final ReferenceTablePanel tablePanel;
    private final ReferenceButtonPanel buttonPanel;
    private final ProcessResultPanel resultPanel;

    public ReferenceView() {
        // Get instance
        super();
        formPanel = new ReferenceFormPanel();
        tablePanel = new ReferenceTablePanel();
        buttonPanel = new ReferenceButtonPanel();
        resultPanel = new ProcessResultPanel();

        // Setup layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(1,10)));
        add(formPanel);
        add(Box.createRigidArea(new Dimension(1,10)));
        add(tablePanel);
        add(Box.createRigidArea(new Dimension(1,10)));
        add(buttonPanel);
        add(resultPanel);
    }

    public String getTitleValue() {
        return formPanel.getTitleValue();
    }

    public String getAuthorValue() {
        return formPanel.getAuthorValue();
    }

    public String getPublisherValue() {
        return formPanel.getPublisherValue();
    }

    public String getStatusValue() {
        return buttonPanel.getStatusValue();
    }

    public int getSelectedIndex() {
        return tablePanel.getSelectedIndex();
    }

    public void setTableData(String[][] tableData) {
        tablePanel.setTableData(tableData);
    }

    public void setResultMessage(String message) {
        resultPanel.setResultMessage(message);
    }

    public void setProcessTime(String time) {
        resultPanel.setProcessTime(time);
    }

    public void initFetchAction(ActionListener listener, String command) {
        formPanel.initSearchButtonAction(listener, command);
    }

    public void initRegisterAction(ActionListener listener, String command) {
        buttonPanel.initRegisterButtonAction(listener, command);
    }

}
