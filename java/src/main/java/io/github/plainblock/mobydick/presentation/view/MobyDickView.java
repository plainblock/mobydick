package io.github.plainblock.mobydick.presentation.view;

import io.github.plainblock.mobydick.presentation.component.CustomTextField;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class MobyDickView extends JPanel {

    private JLabel titleInputLabel;
    private CustomTextField titleInputField;
    private JLabel authorInputLabel;
    private CustomTextField authorInputField;
    private JLabel publisherInputLabel;
    private CustomTextField publisherInputField;

    private JScrollPane referenceTablePanel;
    private JTable referenceTable;

    private JLabel titleLabel;
    private JLabel authorLabel;
    private JLabel publisherLabel;
    private JLabel isbnLabel;

    private JButton welcomeButton;
    private JButton referenceButton;
    private JButton managementButton;
    private JLabel processMessageLabel;
    private JLabel processTimeLabel;

    public MobyDickView() {
        super();
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        initTitleInput(layout);
        initAuthorInput(layout);
        initPublisherInput(layout);
        initReferenceTable(layout);
        initWelcomeButton(layout);
        initReferenceButton(layout);
        initManagementButton(layout);
        initProcessMessageLabel(layout);
        initProcessTimeLabel(layout);
    }

    private void initTitleInput(GridBagLayout layout) {
        titleInputLabel = new JLabel("Title");
        GridBagConstraints labelConst = new GridBagConstraints();
        labelConst.gridx = 0;
        labelConst.gridy = 0;
        labelConst.gridwidth = 1;
        labelConst.gridheight = 1;
        layout.setConstraints(titleInputLabel, labelConst);
        add(titleInputLabel);
        titleInputField = new CustomTextField();
        titleInputField.setEditable(true);
        titleInputField.setBorder(new BevelBorder(BevelBorder.LOWERED));
        titleInputField.setBackground(Color.WHITE);
        GridBagConstraints fieldConst = new GridBagConstraints();
        fieldConst.gridx = 0;
        fieldConst.gridy = 1;
        fieldConst.gridwidth = 10;
        fieldConst.gridheight = 1;
        fieldConst.fill = 1;
        layout.setConstraints(titleInputField, fieldConst);
        add(titleInputField);
    }

    private void initAuthorInput(GridBagLayout layout) {
        authorInputLabel = new JLabel("Author");
        GridBagConstraints labelConst = new GridBagConstraints();
        labelConst.gridx = 0;
        labelConst.gridy = 2;
        labelConst.gridwidth = 1;
        labelConst.gridheight = 1;
        layout.setConstraints(authorInputLabel, labelConst);
        add(authorInputLabel);
        authorInputField = new CustomTextField();
        authorInputField.setEditable(true);
        authorInputField.setBorder(new BevelBorder(BevelBorder.LOWERED));
        authorInputField.setBackground(Color.WHITE);
        GridBagConstraints fieldConst = new GridBagConstraints();
        fieldConst.gridx = 0;
        fieldConst.gridy = 3;
        fieldConst.gridwidth = 10;
        fieldConst.gridheight = 1;
        fieldConst.fill = 1;
        layout.setConstraints(authorInputField, fieldConst);
        add(authorInputField);
    }

    private void initPublisherInput(GridBagLayout layout) {
        publisherInputLabel = new JLabel("Publisher");
        GridBagConstraints labelConst = new GridBagConstraints();
        labelConst.gridx = 0;
        labelConst.gridy = 4;
        labelConst.gridwidth = 1;
        labelConst.gridheight = 1;
        layout.setConstraints(publisherInputLabel, labelConst);
        add(publisherInputLabel);
        publisherInputField = new CustomTextField();
        publisherInputField.setEditable(true);
        publisherInputField.setBorder(new BevelBorder(BevelBorder.LOWERED));
        publisherInputField.setBackground(Color.WHITE);
        GridBagConstraints fieldConst = new GridBagConstraints();
        fieldConst.gridx = 0;
        fieldConst.gridy = 5;
        fieldConst.gridwidth = 10;
        fieldConst.gridheight = 1;
        fieldConst.fill = 1;
        layout.setConstraints(publisherInputField, fieldConst);
        add(publisherInputField);
    }

    private void initReferenceTable(GridBagLayout layout) {
        String[] columns = {"Title", "Author", "Publisher", "ISBN"};
        TableModel model = new DefaultTableModel(columns, 10);
        referenceTable = new JTable(model);
        GridBagConstraints panelConst = new GridBagConstraints();
        panelConst.gridx = 0;
        panelConst.gridy = 6;
        panelConst.gridwidth = 10;
        panelConst.gridheight = 15;
        referenceTablePanel = new JScrollPane(referenceTable);
        referenceTablePanel.setPreferredSize(new Dimension(500, 100));
        layout.setConstraints(referenceTablePanel, panelConst);
        add(referenceTablePanel);
    }

    private void initWelcomeButton(GridBagLayout layout) {
        welcomeButton = new JButton("Welcome");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 25;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        layout.setConstraints(welcomeButton, gbc);
        add(welcomeButton);
    }

    private void initReferenceButton(GridBagLayout layout) {
        referenceButton = new JButton("Reference");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 25;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        layout.setConstraints(referenceButton, gbc);
        add(referenceButton);
    }

    private void initManagementButton(GridBagLayout layout) {
        managementButton = new JButton("Management");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 25;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        layout.setConstraints(managementButton, gbc);
        add(managementButton);
    }

    private void initProcessMessageLabel(GridBagLayout layout) {
        processMessageLabel = new JLabel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 26;
        gbc.gridwidth = 10;
        gbc.gridheight = 1;
        layout.setConstraints(processMessageLabel, gbc);
        add(processMessageLabel);
    }

    private void initProcessTimeLabel(GridBagLayout layout) {
        processTimeLabel = new JLabel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 27;
        gbc.gridwidth = 10;
        gbc.gridheight = 1;
        layout.setConstraints(processTimeLabel, gbc);
        add(processTimeLabel);
    }

    public CustomTextField getTitleInputField() {
        return titleInputField;
    }

    public CustomTextField getAuthorInputField() {
        return authorInputField;
    }

    public CustomTextField getPublisherInputField() {
        return publisherInputField;
    }

    public JTable getReferenceTable() {
        return referenceTable;
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
