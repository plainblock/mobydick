package io.github.plainblock.mobydick.presentation.view;

import io.github.plainblock.mobydick.presentation.component.CustomTextField;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class MobyDickView extends JPanel {

    private CustomTextField isbnInputField;
    private JButton welcomeButton;
    private JButton referenceButton;
    private JButton managementButton;
    private JLabel processMessageLabel;
    private JLabel processTimeLabel;

    public MobyDickView() {
        super();
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        initIsbnInputField(layout);
        initWelcomeButton(layout);
        initReferenceButton(layout);
        initManagementButton(layout);
        initProcessMessageLabel(layout);
        initProcessTimeLabel(layout);
    }

    private void initIsbnInputField(GridBagLayout layout) {
        isbnInputField = new CustomTextField();
        isbnInputField.setPreferredSize(new Dimension(500, 20));
        isbnInputField.setEditable(true);
        isbnInputField.setBorder(new BevelBorder(BevelBorder.LOWERED));
        isbnInputField.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 10;
        gbc.gridheight = 1;
        layout.setConstraints(isbnInputField, gbc);
        add(isbnInputField);
    }

    private void initWelcomeButton(GridBagLayout layout) {
        welcomeButton = new JButton("Welcome");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        layout.setConstraints(welcomeButton, gbc);
        add(welcomeButton);
    }

    private void initReferenceButton(GridBagLayout layout) {
        referenceButton = new JButton("Reference");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        layout.setConstraints(referenceButton, gbc);
        add(referenceButton);
    }

    private void initManagementButton(GridBagLayout layout) {
        managementButton = new JButton("Management");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        layout.setConstraints(managementButton, gbc);
        add(managementButton);
    }

    private void initProcessMessageLabel(GridBagLayout layout) {
        processMessageLabel = new JLabel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 10;
        gbc.gridheight = 1;
        layout.setConstraints(processMessageLabel, gbc);
        add(processMessageLabel);
    }

    private void initProcessTimeLabel(GridBagLayout layout) {
        processTimeLabel = new JLabel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 10;
        gbc.gridheight = 1;
        layout.setConstraints(processTimeLabel, gbc);
        add(processTimeLabel);
    }

    public CustomTextField getIsbnInputField() {
        return isbnInputField;
    }

    public JButton getWelcomeButton() {
        return welcomeButton;
    }

    public JButton getReferenceButton() {
        return referenceButton;
    }

    public JButton getManagementButton() {
        return managementButton;
    }

    public JLabel getProcessMessageLabel() {
        return processMessageLabel;
    }

    public JLabel getProcessTimeLabel() {
        return processTimeLabel;
    }

}
