package io.github.plainblock.mobydick.presentation.component.block;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.JPanel;

import io.github.plainblock.mobydick.domain.model.object.BookStatus;
import io.github.plainblock.mobydick.presentation.component.atom.CustomButton;
import io.github.plainblock.mobydick.presentation.component.atom.CustomComboBox;
import io.github.plainblock.mobydick.presentation.component.atom.CustomTextField;
import io.github.plainblock.mobydick.presentation.component.atom.CustomTextLabel;

public class ManagementFormPanel extends JPanel {

    private CustomComboBox<String> statusInputBox;
    private CustomTextField titleInputField;
    private CustomTextField authorInputField;
    private CustomButton searchButton;

    public ManagementFormPanel() {
        super();
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[]{100, 400, 100};
        layout.rowHeights = new int[]{30, 30, 30};
        setLayout(layout);
        initStatusInput(layout);
        initTitleInput(layout);
        initAuthorInput(layout);
        initSearchButton(layout);
    }

    public String getStatusValue() {
        return Objects.requireNonNull(statusInputBox.getSelectedItem()).toString();
    }

    public String getTitleValue() {
        return titleInputField.getText();
    }

    public String getAuthorValue() {
        return authorInputField.getText();
    }

    public void assignSearchButtonAction(ActionListener listener, String command) {
        searchButton.addActionListener(listener);
        searchButton.setActionCommand(command);
    }

    private void initStatusInput(GridBagLayout layout) {
        // Initialize label
        CustomTextLabel statusInputLabel = new CustomTextLabel("ステータス");
        GridBagConstraints labelConst = new GridBagConstraints();
        labelConst.gridx = 0;
        labelConst.gridy = 0;
        layout.setConstraints(statusInputLabel, labelConst);
        add(statusInputLabel);

        // Initialize box
        statusInputBox = new CustomComboBox<>(BookStatus.toArray(true));
        GridBagConstraints boxConst = new GridBagConstraints();
        boxConst.gridx = 1;
        boxConst.gridy = 0;
        boxConst.fill = 1;
        layout.setConstraints(statusInputBox, boxConst);
        add(statusInputBox);
    }

    private void initTitleInput(GridBagLayout layout) {
        // Initialize label
        CustomTextLabel titleInputLabel = new CustomTextLabel("題名");
        GridBagConstraints labelConst = new GridBagConstraints();
        labelConst.gridx = 0;
        labelConst.gridy = 1;
        layout.setConstraints(titleInputLabel, labelConst);
        add(titleInputLabel);

        // Initialize field
        titleInputField = new CustomTextField();
        GridBagConstraints fieldConst = new GridBagConstraints();
        fieldConst.gridx = 1;
        fieldConst.gridy = 1;
        fieldConst.fill = 1;
        layout.setConstraints(titleInputField, fieldConst);
        add(titleInputField);
    }

    private void initAuthorInput(GridBagLayout layout) {
        // Initialize label
        CustomTextLabel authorInputLabel = new CustomTextLabel("著者");
        GridBagConstraints labelConst = new GridBagConstraints();
        labelConst.gridx = 0;
        labelConst.gridy = 2;
        layout.setConstraints(authorInputLabel, labelConst);
        add(authorInputLabel);

        // Initialize field
        authorInputField = new CustomTextField();
        GridBagConstraints fieldConst = new GridBagConstraints();
        fieldConst.gridx = 1;
        fieldConst.gridy = 2;
        fieldConst.fill = 1;
        layout.setConstraints(authorInputField, fieldConst);
        add(authorInputField);
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
