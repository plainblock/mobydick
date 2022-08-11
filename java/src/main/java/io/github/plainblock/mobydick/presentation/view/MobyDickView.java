package io.github.plainblock.mobydick.presentation.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import io.github.plainblock.mobydick.controller.MobyDickController;
import io.github.plainblock.mobydick.factory.MobyDickFactory;

public class MobyDickView extends JPanel  {

    private JButton welcomeButton;
    private JLabel processingTimeLabel;

    public MobyDickView() {

//        setTitle(title);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setupWelcomeButton();
//        setupProcessingTimeLabel();
        JPanel panel = new JPanel();
    }

    private void setupWelcomeButton() {
        welcomeButton = new JButton("Welcome");
        welcomeButton.setActionCommand("welcome");
//        Container contentPane = getContentPane();
//        contentPane.add(welcomeButton, BorderLayout.CENTER);
    }

    private void setupProcessingTimeLabel() {
        processingTimeLabel = new JLabel();
//        Container contentPane = getContentPane();
//        contentPane.add(processingTimeLabel, BorderLayout.CENTER);
    }

    private void measureTime(Runnable callback) {
        long start = System.currentTimeMillis();
        callback.run();
        long end = System.currentTimeMillis();
        processingTimeLabel.setText(String.format("%d ms", end - start));
    }

}
