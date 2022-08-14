package io.github.plainblock.mobydick.presentation.component.block;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

import io.github.plainblock.mobydick.presentation.component.atom.CustomTextLabel;

public class ProcessResultPanel extends JPanel {

    private CustomTextLabel resultMessage;
    private CustomTextLabel processTime;

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
        resultMessage = new CustomTextLabel(Color.RED);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        layout.setConstraints(resultMessage, gbc);
        add(resultMessage);
    }

    private void initProcessTime(GridBagLayout layout) {
        processTime = new CustomTextLabel(Color.GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.EAST;
        layout.setConstraints(processTime, gbc);
        add(processTime);
    }

}
