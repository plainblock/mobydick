package io.github.plainblock.mobydick.presentation.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import io.github.plainblock.mobydick.presentation.component.ManagementButtonPanel;
import io.github.plainblock.mobydick.presentation.component.ManagementFormPanel;
import io.github.plainblock.mobydick.presentation.component.ManagementTablePanel;
import io.github.plainblock.mobydick.presentation.component.ProcessResultPanel;

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
        add(resultPanel);
    }

    public String getStatusValue() {
        return formPanel.getStatusValue();
    }

    public String getKeywordValue() {
        return formPanel.getKeywordValue();
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

    public void initGetAction(ActionListener listener, String command) {
        formPanel.initSearchButtonAction(listener, command);
    }

    public void initWantToAction(ActionListener listener, String command) {
        buttonPanel.setWantToReadButtonAction(listener, command);
    }

    public void initNotYetAction(ActionListener listener, String command) {
        buttonPanel.setNotYetReadButtonAction(listener, command);
    }

    public void initAlreadyAction(ActionListener listener, String command) {
        buttonPanel.setAlreadyReadButtonAction(listener, command);
    }

}
