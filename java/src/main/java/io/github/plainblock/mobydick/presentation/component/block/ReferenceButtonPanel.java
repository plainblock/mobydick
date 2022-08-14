package io.github.plainblock.mobydick.presentation.component.block;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import io.github.plainblock.mobydick.domain.model.object.BookStatus;
import io.github.plainblock.mobydick.presentation.component.atom.CustomButton;

public class ReferenceButtonPanel extends JPanel {

    private JComboBox<String> statusBox;
    private CustomButton registerButton;

    public ReferenceButtonPanel() {
        super();
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        initStatusBox(layout);
        initRegisterButton(layout);
    }

    public String getStatusValue() {
        return Objects.requireNonNull(statusBox.getSelectedItem()).toString();
    }

    public void initRegisterButtonAction(ActionListener listener, String command) {
        registerButton.addActionListener(listener);
        registerButton.setActionCommand(command);
    }

    private void initStatusBox(GridBagLayout layout) {
        statusBox = new JComboBox<>(BookStatus.toArray(false));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(0, 0, 0, 5);
        layout.setConstraints(statusBox, gbc);
        add(statusBox);
    }

    private void initRegisterButton(GridBagLayout layout) {
        registerButton = new CustomButton("本棚登録");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        layout.setConstraints(registerButton, gbc);
        add(registerButton);
    }

}
