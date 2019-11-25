package com.boomaa.enigma.logic;

import com.boomaa.enigma.display.Display;
import com.boomaa.enigma.display.DisplayElements;

import javax.swing.*;

public class DisplayHelpers {
    public static String ICON_URL = "https://is1-ssl.mzstatic.com/image/thumb/Purple123/v4/08/98/b6/0898b62c-d36f-bd06-54f4-44b61df893d5/source/64x64bb.jpg";
    public static JLabel SPACER = new JLabel("         ");

    public static void addComponents(JComponent panel, JComponent... comp) {
        for(JComponent jc : comp) { panel.add(jc); }
    }

    public static void updateCurrentPositions() {
        DisplayElements.RotorPos.ROTOR_A.setText(Display.ROTOR_A.getCurrentPosition());
        DisplayElements.RotorPos.ROTOR_B.setText(Display.ROTOR_B.getCurrentPosition());
        DisplayElements.RotorPos.ROTOR_C.setText(Display.ROTOR_C.getCurrentPosition());
    }
}
