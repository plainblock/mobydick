package io.github.plainblock.mobydick;

import javax.swing.JFrame;

import io.github.plainblock.mobydick.presentation.controller.MobyDickController;
import io.github.plainblock.mobydick.factory.MobyDickFactory;

public class MobyDick extends JFrame {

    private static final String TITLE = "MobyDick Java edition";
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    private MobyDickController ctrl;

    public static void main(String[] args) {
        MobyDick main = new MobyDick();
        main.start();
    }

    private void start() {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ctrl = MobyDickFactory.getMobyDickController();
        ctrl.linkView(MobyDickFactory.getMobyDickView());
        add(ctrl.getView());
        setVisible(true);
    }

}