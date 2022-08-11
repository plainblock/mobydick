package io.github.plainblock.mobydick.presentation.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import io.github.plainblock.mobydick.controller.MobyDickController;
import io.github.plainblock.mobydick.factory.MobyDickFactory;

public class MobyDickView extends JFrame implements ActionListener {

    private final MobyDickController controller;

    public MobyDickView(String title, int width, int height) {
        controller = MobyDickFactory.getMobyDickController();
        setTitle(title);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setupWelcomeButton();
    }

    private void setupWelcomeButton() {
        JButton button = new JButton("Welcome");
        button.addActionListener(this);
        button.setActionCommand("welcome");
        Container contentPane = getContentPane();
        contentPane.add(button, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        switch (command) {
            case "welcome" -> controller.onHelloButtonClick();
            case "reference" -> controller.onReference();
            case "management" -> controller.onManagement();
        }
    }

}
