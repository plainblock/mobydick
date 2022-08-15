package io.github.plainblock.mobydick.presentation.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import io.github.plainblock.mobydick.presentation.component.block.ManagementButtonPanel;
import io.github.plainblock.mobydick.presentation.component.block.ManagementFormPanel;
import io.github.plainblock.mobydick.presentation.component.block.ManagementTablePanel;
import io.github.plainblock.mobydick.presentation.component.block.ProcessResultPanel;

public class ManagementView extends JPanel {

    private final ManagementFormPanel formPanel;
    private final ManagementTablePanel tablePanel;
    private final ManagementButtonPanel buttonPanel;
    private final ProcessResultPanel resultPanel;

    public ManagementView() {
        // Get instance
        super();
        formPanel = new ManagementFormPanel();
        tablePanel = new ManagementTablePanel();
        buttonPanel = new ManagementButtonPanel();
        resultPanel = new ProcessResultPanel();

        // Setup layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(1,10)));
        add(formPanel);
        add(Box.createRigidArea(new Dimension(1,10)));
        add(tablePanel);
        add(Box.createRigidArea(new Dimension(1,10)));
        add(buttonPanel);
        add(Box.createRigidArea(new Dimension(1,5)));
        add(resultPanel);
    }

    public String getStatusValue() {
        return formPanel.getStatusValue();
    }

    public int getSelectedIndex() {
        return tablePanel.getSelectedIndex();
    }

    public String getTitleValue() {
        return formPanel.getTitleValue();
    }

    public String getAuthorValue() {
        return formPanel.getAuthorValue();
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

    public void assignGetAction(ActionListener listener, String command) {
        formPanel.assignSearchButtonAction(listener, command);
    }

    public void assignWantToAction(ActionListener listener, String command) {
        buttonPanel.assignWantToReadButtonAction(listener, command);
    }

    public void assignNotYetAction(ActionListener listener, String command) {
        buttonPanel.assignNotYetReadButtonAction(listener, command);
    }

    public void assignAlreadyAction(ActionListener listener, String command) {
        buttonPanel.assignAlreadyReadButtonAction(listener, command);
    }

}
