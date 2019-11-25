package com.boomaa.enigma.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

@SuppressWarnings("serial")
public class OverlayField extends JTextField implements FocusListener {
    private final String overlay;
    private boolean showingOverlay;

    public OverlayField(final String overlay, final int col) {
        super(overlay, col);
        super.setForeground(Color.GRAY);
        this.overlay = overlay;
        this.showingOverlay = true;
        super.addFocusListener(this);
    }

    public void reset() {
        super.setVisible(false);
        super.setText(overlay);
        showingOverlay = true;
        super.setVisible(true);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (this.getText().isEmpty()) {
            super.setText("");
            showingOverlay = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().isEmpty()) {
            super.setText(overlay);
            showingOverlay = true;
        }
    }

    @Override
    public String getText() {
        return showingOverlay ? "" : super.getText();
    }
}
