package com.boomaa.enigma;

import java.util.Arrays;

public class Display {
    public static Rotor ROTOR_A = new Rotor(RotorType.I, 'A'),
            ROTOR_B = new Rotor(RotorType.II, 'A'),
            ROTOR_C = new Rotor(RotorType.III, 'A');
    public static String[] PLUGBOARD = { "AZ", "BY" };

    public static void main(String[] args) {
        char[] message = "ABZY".toUpperCase().toCharArray();
        message = EnigmaLogic.applyPlugboard(message);
        message = EnigmaLogic.applyRotors(message);
        System.out.println(Arrays.toString(message));
        System.out.println(ROTOR_A.toString() + ROTOR_B + ROTOR_C);
    }

}