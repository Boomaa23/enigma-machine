package com.boomaa.enigma.display;

import com.boomaa.enigma.logic.DisplayHelpers;
import com.boomaa.enigma.logic.Listeners;
import com.boomaa.enigma.util.Rotor;
import com.boomaa.enigma.util.RotorType;
import com.boomaa.enigma.network.UDPClient;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.IOException;
import java.net.URL;

import static com.boomaa.enigma.display.DisplayElements.*;
import com.boomaa.enigma.display.DisplayElements.*;

public class Display extends DisplayHelpers {
    public static Rotor ROTOR_A = new Rotor(RotorType.I, 'A'),
            ROTOR_B = new Rotor(RotorType.II, 'A'),
            ROTOR_C = new Rotor(RotorType.III, 'A');
    public static String[] PLUGBOARD = {};

    public static void main(String[] args) {
        UDPClient client = new UDPClient();
        client.start();
        initFrame();
        initSettingsPanel();
        initSendPanel();
        addComponents(MAIN_PANEL, SETTINGS_PANEL, SEND_PANEL, RECEIVE_PANEL);
        FRAME.add(MAIN_PANEL);
        FRAME.setVisible(true);

        System.out.println(ROTOR_A.toString() + ROTOR_B + ROTOR_C);
    }

    public static void initFrame() {
        try {
            FRAME.setIconImage(ImageIO.read(new URL(ICON_URL)));
            FRAME.setSize(600, 400);
            FRAME.setLocationRelativeTo(null);
            FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            MAIN_PANEL.setLayout(new BoxLayout(MAIN_PANEL, BoxLayout.Y_AXIS));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initSendPanel() {
        FRAME.getRootPane().setDefaultButton(Send.BUTTON);
        Send.BUTTON.addActionListener(new Listeners.SendCipheredMessage());
        addComponents(SEND_PANEL, Send.LABEL, Send.MSG_FIELD, Send.ADDR_FIELD, Send.BUTTON);
    }

    private static void initSettingsPanel() {
        DisplayHelpers.updateCurrentPositions();
        RotorPos.BUTTON.addActionListener(new Listeners.ChangeRotorPositions());
        RotorPos.ROTOR_A.addMouseListener(new Listeners.ClearTextField(RotorPos.ROTOR_A));
        RotorPos.ROTOR_B.addMouseListener(new Listeners.ClearTextField(RotorPos.ROTOR_B));
        RotorPos.ROTOR_C.addMouseListener(new Listeners.ClearTextField(RotorPos.ROTOR_C));
        Plugboard.BUTTON.addActionListener(e -> { PLUGBOARD = Plugboard.INPUT.getText().split(", "); });
        addComponents(SETTINGS_PANEL, RotorPos.LABEL, RotorPos.ROTOR_A, RotorPos.ROTOR_B, RotorPos.ROTOR_C, RotorPos.BUTTON,
                DisplayHelpers.SPACER, Plugboard.LABEL, Plugboard.INPUT, Plugboard.BUTTON);
    }
}