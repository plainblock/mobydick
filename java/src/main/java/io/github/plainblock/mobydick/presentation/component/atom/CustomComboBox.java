package io.github.plainblock.mobydick.presentation.component.atom;

import java.awt.Font;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class CustomComboBox<E> extends JComboBox<E> {

    public CustomComboBox(ComboBoxModel<E> aModel) {
        super(aModel);
        setFont(new Font("Dialog", Font.BOLD, 14));
    }

    public CustomComboBox(E[] items) {
        super(items);
        setFont(new Font("Dialog", Font.BOLD, 14));
    }

    public CustomComboBox(Vector<E> items) {
        super(items);
        setFont(new Font("Dialog", Font.BOLD, 14));
    }

    public CustomComboBox() {
        super();
        setFont(new Font("Dialog", Font.BOLD, 14));
    }

}
