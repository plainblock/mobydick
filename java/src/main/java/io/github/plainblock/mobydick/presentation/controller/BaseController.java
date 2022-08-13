package io.github.plainblock.mobydick.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseController implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
    }

    String measureTime(Runnable callback) {
        long start = System.currentTimeMillis();
        callback.run();
        long end = System.currentTimeMillis();
        return String.format("%d ms", end - start);
    }

}
