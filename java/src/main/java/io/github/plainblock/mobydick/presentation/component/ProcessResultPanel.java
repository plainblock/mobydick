package io.github.plainblock.mobydick.presentation.component;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProcessResultPanel extends JPanel {

    private JLabel resultMessage;
    private JLabel processTime;

    public ProcessResultPanel() {
        super();
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[]{50, 400, 50};
        layout.rowHeights = new int[]{20};
        setLayout(layout);
        initResultMessage(layout);
        initProcessTime(layout);
    }

    public void setResultMessage(String message) {
        resultMessage.setText(message);
    }

    public void setProcessTime(String time) {
        processTime.setText(time);
    }

    private void initResultMessage(GridBagLayout layout) {
        resultMessage = new JLabel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        layout.setConstraints(resultMessage, gbc);
        add(resultMessage);
    }

    private void initProcessTime(GridBagLayout layout) {
        processTime = new JLabel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.EAST;
        layout.setConstraints(processTime, gbc);
        add(processTime);
    }

}
