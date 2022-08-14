package io.github.plainblock.mobydick.presentation.component;

import java.awt.Font;
import javax.swing.JLabel;

public class CustomTextLabel extends JLabel {

    public CustomTextLabel() {
        this(null);
    }

    public CustomTextLabel(String text) {
        super(text);
        setFont(new Font("Dialog", Font.BOLD, 14));
    }

}
