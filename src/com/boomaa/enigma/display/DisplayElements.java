package com.boomaa.enigma.display;

import com.boomaa.enigma.util.OverlayField;

import javax.swing.*;
import java.awt.*;

public interface DisplayElements {
    JFrame FRAME = new JFrame("Enigma Machine");
    JPanel MAIN_PANEL = new JPanel();

    JPanel SEND_PANEL = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel RECEIVE_PANEL = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel SETTINGS_PANEL = new JPanel(new FlowLayout(FlowLayout.CENTER));

    interface RotorPos {
        JLabel LABEL = new JLabel("Rotor Positions: ");
        JButton BUTTON = new JButton("Set");
        JTextField ROTOR_A = new JTextField(2);
        JTextField ROTOR_B = new JTextField(2);
        JTextField ROTOR_C = new JTextField(2);
    }

    interface Plugboard {
        JLabel LABEL = new JLabel("Plugboard: ");
        OverlayField INPUT = new OverlayField(" (e.g. AZ, BY, CX)", 12);
        JButton BUTTON = new JButton("Set");
    }

    interface Send {
        JLabel LABEL = new JLabel("Send a Message: ");
        JButton BUTTON = new JButton("Send");
        OverlayField MSG_FIELD = new OverlayField(" Message", 22);
        OverlayField ADDR_FIELD = new OverlayField(" Address", 9);
    }

    interface Receive {
    }
}
