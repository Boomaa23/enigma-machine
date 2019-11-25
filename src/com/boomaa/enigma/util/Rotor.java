package com.boomaa.enigma.util;

public class Rotor {
    private int currentPosition, maxIterations = 25;
    private RotorType type;

    public Rotor(RotorType type, char startingPosition) {
        this.type = type;
        this.currentPosition = (int) Character.toUpperCase(startingPosition) - 65;
    }

    public Rotor iterate() {
        return this.iterate(true);
    }

    public Rotor iterate(boolean turnover) {
        if(turnover) { currentPosition++; }
        if(currentPosition > maxIterations - 1) { currentPosition %= maxIterations + 1; }
        return this;
    }

    public boolean checkTurnover() {
        return currentPosition == type.turnover;
    }

    public char cipher(char toCipher) {
        toCipher = Character.toUpperCase(toCipher);
        return (char) (type.wireMap[((toCipher - 65) + currentPosition) % maxIterations] + 65);
    }

    public String getCurrentPosition() {
        return String.valueOf((char) (currentPosition + 65));
    }

    public void setCurrentPosition(String position) {
        currentPosition = (int) Character.toUpperCase(position.charAt(0)) - 65;
    }

    @Override
    public String toString() {
        return "Current Position: " + currentPosition + " / " + (char) (currentPosition + 65) + "\n";
    }
}
