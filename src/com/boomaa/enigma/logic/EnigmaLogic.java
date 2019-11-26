package com.boomaa.enigma.logic;

import com.boomaa.enigma.display.Display;
import com.boomaa.enigma.util.EnigmaMessage;

public class EnigmaLogic {
    public static void applyPlugboard(EnigmaMessage message) {
        for(String swap : Display.PLUGBOARD) {
            for(int i = 0; i < message.getLength(); i++) {
                if(message.getCharAt(i) == swap.charAt(0)) {
                    message.setChar(i, swap.charAt(1));
                } else if(message.getCharAt(i) == swap.charAt(1)) {
                    message.setChar(i, swap.charAt(0));
                }
            }
        }
    }

    public static void applyRotors(EnigmaMessage message) {
        for(int i = 0; i < message.getLength(); i++) {
            message.setChar(i, applyReflector(applyRotorC(applyRotorB(applyRotorA(message.getCharAt(i))))));
        }
    }

    private static char applyRotorA(char m_current) {
        return Display.ROTOR_A.iterate().cipher(m_current);
    }

    private static char applyRotorB(char m_current) {
        return Display.ROTOR_B.iterate(Display.ROTOR_A.checkTurnover()).cipher(m_current);
    }

    private static char applyRotorC(char m_current) {
        return Display.ROTOR_C.iterate(Display.ROTOR_B.checkTurnover() && Display.ROTOR_A.checkTurnover()).cipher(m_current);
    }

    private static char applyReflector(char m_current) {
        return Display.REFLECTOR.reflect(m_current);
    }
}
