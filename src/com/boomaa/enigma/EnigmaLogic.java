package com.boomaa.enigma;

public class EnigmaLogic {
    public static char[] applyPlugboard(char[] message) {
        for(String swap : Display.PLUGBOARD) {
            for(int i = 0;i < message.length;i++) {
                if(message[i] == swap.charAt(0)) {
                    message[i] = swap.charAt(1);
                    continue;
                }
                if(message[i] == swap.charAt(1)) {
                    message[i] = swap.charAt(0);
                    continue;
                }
            }
        }
        return message;
    }

    public static char[] applyRotors(char[] message) {
        for(int i = 0;i < message.length;i++) {
            char m_current = message[i];
            Display.ROTOR_A.iterate();
            m_current = Display.ROTOR_A.cipher(m_current);
            Display.ROTOR_B.iterate(Display.ROTOR_A.checkTurnover());
            m_current = Display.ROTOR_B.cipher(m_current);
            Display.ROTOR_C.iterate(Display.ROTOR_B.checkTurnover());
            message[i] = Display.ROTOR_C.cipher(m_current);
        }
        return message;
    }
}
