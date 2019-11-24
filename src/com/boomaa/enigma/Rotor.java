package com.boomaa.enigma;

public class Rotor {
    private int currentPosition, maxIterations = 26;
    private RotorType type;

    public Rotor(RotorType type, char startingPosition) {
        this.type = type;
        this.currentPosition = (int) Character.toUpperCase(startingPosition) - 65;
    }

    public void iterate() {
        iterate(true);
    }

    public void iterate(boolean turnover) {
        if(turnover) { currentPosition++; }
        if(currentPosition > maxIterations) { currentPosition %= maxIterations + 1; }
    }

    public boolean checkTurnover() {
        return currentPosition == type.turnover;
    }

    public char cipher(char toCipher) {
        toCipher = Character.toUpperCase(toCipher);
        return (char) (type.wireMap[((toCipher - 65) + currentPosition) % maxIterations] + 65);
    }

    @Override
    public String toString() {
        return "Current Position: " + currentPosition + " / " + (char) (currentPosition + 65) + "\n";
    }
}
