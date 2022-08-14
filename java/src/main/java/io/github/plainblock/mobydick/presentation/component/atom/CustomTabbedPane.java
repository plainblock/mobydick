package io.github.plainblock.mobydick.presentation.component.atom;

import java.awt.Font;
import javax.swing.JTabbedPane;

public class CustomTabbedPane extends JTabbedPane {

    public CustomTabbedPane() {
        this(TOP, WRAP_TAB_LAYOUT);
    }

    public CustomTabbedPane(int tabPlacement) {
        this(tabPlacement, WRAP_TAB_LAYOUT);
    }

    public CustomTabbedPane(int tabPlacement, int tabLayoutPolicy) {
        super(tabPlacement, tabLayoutPolicy);
        setFont(new Font("Dialog", Font.BOLD, 14));
    }

}
