package io.github.plainblock.mobydick.presentation.component.atom;

import java.awt.Color;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JLabel;

public class CustomTextLabel extends JLabel {

    public CustomTextLabel() {
        this("", null, LEADING);
    }

    public CustomTextLabel(String text) {
        this(text, null, LEADING);
    }

    public CustomTextLabel(Color color) {
        this("", null, LEADING);
        setForeground(color);
    }

    public CustomTextLabel(String text, Color color) {
        this(text, null, LEADING);
        setForeground(color);
    }

    public CustomTextLabel(String text, int horizontalAlignment) {
        this(text, null, horizontalAlignment);
    }

    public CustomTextLabel(Icon image) {
        this(null, image, CENTER);
    }

    public CustomTextLabel(Icon image, int horizontalAlignment) {
        this(null, image, horizontalAlignment);
    }

    public CustomTextLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
        setFont(new Font("Dialog", Font.BOLD, 14));
    }

}
