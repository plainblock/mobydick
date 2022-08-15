package io.github.plainblock.mobydick.presentation.component.block;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import io.github.plainblock.mobydick.presentation.component.atom.CustomButton;
import io.github.plainblock.mobydick.presentation.component.atom.CustomTextField;
import io.github.plainblock.mobydick.presentation.component.atom.CustomTextLabel;

public class ReferenceFormPanel extends JPanel {

    private CustomTextField titleInputField;
    private CustomTextField authorInputField;
    private CustomTextField publisherInputField;
    private CustomButton searchButton;

    public ReferenceFormPanel() {
        super();
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[]{100, 400, 100};
        layout.rowHeights = new int[]{30, 30, 30};
        setLayout(layout);
        initTitleInput(layout);
        initAuthorInput(layout);
        initPublisherInput(layout);
        initSearchButton(layout);
    }

    public String getTitleValue() {
        return titleInputField.getText();
    }

    public String getAuthorValue() {
        return authorInputField.getText();
    }

    public String getPublisherValue() {
        return publisherInputField.getText();
    }

    public void assignSearchButtonAction(ActionListener listener, String command) {
        searchButton.addActionListener(listener);
        searchButton.setActionCommand(command);
    }

    private void initTitleInput(GridBagLayout layout) {
        // Initialize label
        CustomTextLabel titleInputLabel = new CustomTextLabel("題名");
        GridBagConstraints labelConst = new GridBagConstraints();
        labelConst.gridx = 0;
        labelConst.gridy = 0;
        layout.setConstraints(titleInputLabel, labelConst);
        add(titleInputLabel);

        // Initialize field
        titleInputField = new CustomTextField();
        GridBagConstraints fieldConst = new GridBagConstraints();
        fieldConst.gridx = 1;
        fieldConst.gridy = 0;
        fieldConst.fill = 1;
        layout.setConstraints(titleInputField, fieldConst);
        add(titleInputField);
    }

    private void initAuthorInput(GridBagLayout layout) {
        // Initialize label
        CustomTextLabel authorInputLabel = new CustomTextLabel("著者");
        GridBagConstraints labelConst = new GridBagConstraints();
        labelConst.gridx = 0;
        labelConst.gridy = 1;
        layout.setConstraints(authorInputLabel, labelConst);
        add(authorInputLabel);

        // Initialize field
        authorInputField = new CustomTextField();
        GridBagConstraints fieldConst = new GridBagConstraints();
        fieldConst.gridx = 1;
        fieldConst.gridy = 1;
        fieldConst.fill = 1;
        layout.setConstraints(authorInputField, fieldConst);
        add(authorInputField);
    }

    private void initPublisherInput(GridBagLayout layout) {
        // Initialize label
        CustomTextLabel publisherInputLabel = new CustomTextLabel("出版社");
        GridBagConstraints labelConst = new GridBagConstraints();
        labelConst.gridx = 0;
        labelConst.gridy = 2;
        layout.setConstraints(publisherInputLabel, labelConst);
        add(publisherInputLabel);

        // Initialize field
        publisherInputField = new CustomTextField();
        GridBagConstraints fieldConst = new GridBagConstraints();
        fieldConst.gridx = 1;
        fieldConst.gridy = 2;
        fieldConst.fill = 1;
        layout.setConstraints(publisherInputField, fieldConst);
        add(publisherInputField);
    }

    private void initSearchButton(GridBagLayout layout) {
        searchButton = new CustomButton("検索");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridheight = 3;
        layout.setConstraints(searchButton, gbc);
        add(searchButton);
    }

}
