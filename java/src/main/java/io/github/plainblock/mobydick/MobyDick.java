package io.github.plainblock.mobydick;

import javax.swing.JFrame;

import io.github.plainblock.mobydick.presentation.component.atom.CustomTabbedPane;
import io.github.plainblock.mobydick.presentation.controller.ManagementController;
import io.github.plainblock.mobydick.factory.MobyDickFactory;
import io.github.plainblock.mobydick.presentation.controller.ReferenceController;

public class MobyDick extends JFrame {

    private static final String TITLE = "MobyDick Java edition";
    private static final int WIDTH = 640;
    private static final int HEIGHT = 660;

    public static void main(String[] args) {
        MobyDick main = new MobyDick();
        main.start();
    }

    private void start() {
        // Initialize display
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize controller
        ReferenceController referenceCtrl = MobyDickFactory.getReferenceController();
        ManagementController managementCtrl = MobyDickFactory.getManagementController();

        // Setup view
        CustomTabbedPane tabbedPane = new CustomTabbedPane();
        tabbedPane.add("書籍検索", referenceCtrl.getView());
        tabbedPane.add("本棚管理", managementCtrl.getView());
        add(tabbedPane);
        setVisible(true);
    }

}