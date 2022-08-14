package io.github.plainblock.mobydick.presentation.component.block;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import io.github.plainblock.mobydick.domain.model.object.BookStatus;
import io.github.plainblock.mobydick.presentation.component.atom.CustomButton;

public class ManagementButtonPanel extends JPanel {

    private CustomButton wantToReadButton;
    private CustomButton notYetReadButton;
    private CustomButton alreadyReadButton;

    public ManagementButtonPanel() {
        super();
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[]{100, 100, 100, 100, 100};
        layout.rowHeights = new int[]{100, 20};
        setLayout(layout);
        initWantToReadButton(layout);
        initNotYetReadButton(layout);
        initAlreadyReadButton(layout);
    }

    public void setWantToReadButtonAction(ActionListener listener, String command) {
        wantToReadButton.addActionListener(listener);
        wantToReadButton.setActionCommand(command);
    }

    public void setNotYetReadButtonAction(ActionListener listener, String command) {
        notYetReadButton.addActionListener(listener);
        notYetReadButton.setActionCommand(command);
    }

    public void setAlreadyReadButtonAction(ActionListener listener, String command) {
        alreadyReadButton.addActionListener(listener);
        alreadyReadButton.setActionCommand(command);
    }

    private void initWantToReadButton(GridBagLayout layout) {
        wantToReadButton = new CustomButton(BookStatus.NOT_PURCHASED.label());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        layout.setConstraints(wantToReadButton, gbc);
        add(wantToReadButton);
    }

    private void initNotYetReadButton(GridBagLayout layout) {
        notYetReadButton = new CustomButton(BookStatus.NOT_YET_READ.label());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        layout.setConstraints(notYetReadButton, gbc);
        add(notYetReadButton);
    }

    private void initAlreadyReadButton(GridBagLayout layout) {
        alreadyReadButton = new CustomButton(BookStatus.ALREADY_READ.label());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        layout.setConstraints(alreadyReadButton, gbc);
        add(alreadyReadButton);
    }

}
