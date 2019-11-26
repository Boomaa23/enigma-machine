package com.boomaa.enigma.util;

import com.boomaa.enigma.display.Display;

public class Reflector {
    private RotorType type;

    public Reflector(RotorType type) {
        this.type = type;
    }

    public char reflect(char toReflect) {
        toReflect = Character.toUpperCase(toReflect);
        return Display.ROTOR_A.arccipher(Display.ROTOR_B.arccipher(Display.ROTOR_C.arccipher(type.wireMap.charAt(toReflect - 65))));
    }
}
