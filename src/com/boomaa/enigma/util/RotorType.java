package com.boomaa.enigma.util;

public enum RotorType {
    I('Q', "EKMFLGDQVZNTOWYHXUSPAIBRCJ"),
    II('E', "AJDKSIRUXBLHWTMCQGZNPYFVOE"),
    III('V', "BDFHJLCPRTXVZNYEIWGAKMUSQO"),
    IV('J', "ESOVPZJAYQUIRHXLNFTGKDCMWB"),
    V('Z', "VZBRGITYUPSDNHLXAWMJQOFECK"),
    UKW_A("EJMZALYXVBWFCRQUONTSPIKHGD"),
    UKW_B("YRUHQSLDPXNGOKMIEBFZCWVJAT"),
    UKW_C("FVPJIAOYEDRZXWGCTKUQSBNMHL");

    public String wireMap;
    public int turnover;

    RotorType(char turnover, String wireMap) {
        this.turnover = (int) turnover - 65;
        this.wireMap = wireMap;
    }

    RotorType(String wireMap) {
        this('A', wireMap);
    }
}