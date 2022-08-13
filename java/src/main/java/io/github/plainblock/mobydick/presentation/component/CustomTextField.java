package io.github.plainblock.mobydick.presentation.component;

import javax.swing.JTextField;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CustomTextField extends JTextField implements UndoableEditListener, KeyListener {

    private final UndoManager undoManager = new UndoManager();

    public CustomTextField() {
        this(null);
    }

    public CustomTextField(String text) {
        Document doc = getDocument();
        doc.addUndoableEditListener(this);
        addKeyListener(this);
        if (text != null) {
            setText(text);
        }
    }

    @Override
    public void undoableEditHappened(UndoableEditEvent event) {
        undoManager.addEdit(event.getEdit());
    }

    @Override
    public void keyTyped(KeyEvent event) {
    }

    @Override
    public void keyPressed(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_Z -> executeUndo(event);
            case KeyEvent.VK_Y -> executeRedo(event);
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
    }

    private void executeUndo(KeyEvent event) {
        if (event.isControlDown() && undoManager.canUndo()) {
            undoManager.undo();
            event.consume();
        }
    }

    private void executeRedo(KeyEvent event) {
        if (event.isControlDown() && undoManager.canRedo()) {
            undoManager.redo();
            event.consume();
        }
    }

}
