package io.github.plainblock.mobydick.presentation.component.atom;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.text.Document;

public class CustomText extends JTextField {

    public CustomText() {
        this(null, null, 0);
    }

    public CustomText(String text) {
        this(null, text, 0);
    }

    public CustomText(int columns) {
        this(null, null, columns);
    }

    public CustomText(String text, int columns) {
        this(null, text, columns);
    }

    public CustomText(Document doc, String text, int columns) {
        super(doc, text, columns);
        setFont(new Font("Dialog", Font.BOLD, 14));
        setBorder(null);
        setEnabled(true);
        setEditable(false);
        setAutoscrolls(false);
    }

}
