package io.github.plainblock.mobydick.presentation.component.atom;

import java.awt.Font;
import javax.swing.JButton;

public class CustomButton extends JButton {

    public CustomButton() {
        this(null);
    }

    public CustomButton(String text) {
        super(text);
        setFont(new Font("Dialog", Font.BOLD, 14));
    }

}
