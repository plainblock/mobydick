package io.github.plainblock.mobydick.presentation.component.atom;

import java.awt.Font;
import javax.swing.JButton;

public class CustomButton extends JButton {

    public CustomButton() {
        this(null, 14);
    }

    public CustomButton(String text) {
        this(text, 14);
    }

    public CustomButton(String text, int fontSize) {
        super(text);
        setFont(new Font("Dialog", Font.BOLD, fontSize));
    }

}
