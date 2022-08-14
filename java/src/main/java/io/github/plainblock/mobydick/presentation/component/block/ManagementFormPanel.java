package io.github.plainblock.mobydick.presentation.component.block;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import io.github.plainblock.mobydick.domain.model.object.BookStatus;
import io.github.plainblock.mobydick.presentation.component.atom.CustomButton;
import io.github.plainblock.mobydick.presentation.component.atom.CustomComboBox;
import io.github.plainblock.mobydick.presentation.component.atom.CustomTextField;
import io.github.plainblock.mobydick.presentation.component.atom.CustomTextLabel;

public class ManagementFormPanel extends JPanel {

    private CustomComboBox<String> statusInputBox;
    private CustomTextField keywordInputField;
    private CustomButton searchButton;

    public ManagementFormPanel() {
        super();
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[]{100, 300, 100};
        setLayout(layout);
        initStatusInputLabel(layout);
        initStatusInputBox(layout);
        initKeywordInputLabel(layout);
        initKeywordInputField(layout);
        initSearchButton(layout);
    }

    public String getStatusValue() {
        return Objects.requireNonNull(statusInputBox.getSelectedItem()).toString();
    }

    public String getKeywordValue() {
        return keywordInputField.getText();
    }

    public void initSearchButtonAction(ActionListener listener, String command) {
        searchButton.addActionListener(listener);
        searchButton.setActionCommand(command);
    }

    private void initStatusInputLabel(GridBagLayout layout) {
        CustomTextLabel statusInputLabel = new CustomTextLabel("ステータス");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = 1;
        layout.setConstraints(statusInputLabel, gbc);
        add(statusInputLabel);
    }

    private void initStatusInputBox(GridBagLayout layout) {
        statusInputBox = new CustomComboBox<>(BookStatus.toArray(true));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = 1;
        layout.setConstraints(statusInputBox, gbc);
        add(statusInputBox);
    }

    private void initKeywordInputLabel(GridBagLayout layout) {
        CustomTextLabel keywordInputLabel = new CustomTextLabel("キーワード");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = 1;
        layout.setConstraints(keywordInputLabel, gbc);
        add(keywordInputLabel);
    }

    private void initKeywordInputField(GridBagLayout layout) {
        keywordInputField = new CustomTextField();
        keywordInputField.setEditable(true);
        keywordInputField.setBorder(new BevelBorder(BevelBorder.LOWERED));
        keywordInputField.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = 1;
        layout.setConstraints(keywordInputField, gbc);
        add(keywordInputField);
    }

    private void initSearchButton(GridBagLayout layout) {
        searchButton = new CustomButton("検索");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = 1;
        layout.setConstraints(searchButton, gbc);
        add(searchButton);
    }

}
