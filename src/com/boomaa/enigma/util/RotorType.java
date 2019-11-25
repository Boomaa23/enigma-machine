package com.boomaa.enigma.util;

public enum RotorType {
    I('R', "EKMFLGDQVZNTOWYHXUSPAIBRCJ"),
    II('F', "AJDKSIRUXBLHWTMCQGZNPYFVOE"),
    III('W', "BDFHJLCPRTXVZNYEIWGAKMUSQO"),
    IV('K', "ESOVPZJAYQUIRHXLNFTGKDCMWB"),
    V('A', "VZBRGITYUPSDNHLXAWMJQOFECK");

    public int[] wireMap;
    public int turnover;

    RotorType(char turnover, String wireMap) {
        this.turnover = (int) turnover - 65;
        this.wireMap = new int[wireMap.length()];
        char[] charWireMap = wireMap.toCharArray();
        for(int i = 0;i < charWireMap.length;i++) {
            this.wireMap[i] = ((int) Character.toUpperCase(charWireMap[i])) - 65;
        }
    }
}