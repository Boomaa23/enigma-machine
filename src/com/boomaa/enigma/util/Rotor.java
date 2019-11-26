package com.boomaa.enigma.util;

public class Rotor {
    private int currentPosition;
    private int maxIterations = 25;
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
        if(currentPosition > maxIterations) {
            currentPosition %= maxIterations + 1;
        }
        System.out.println(type.name() + " iterate | cpos: " + currentPosition);
        return this;
    }

    public boolean checkTurnover() {
        System.out.println(type.name() + " checktover | status: " + (currentPosition == type.turnover) + " turnover: " + type.turnover);
        return currentPosition == type.turnover;
    }

    public char cipher(char toCipher) {
        toCipher = Character.toUpperCase(toCipher);
        toCipher = (char)((int) toCipher + currentPosition);

        int sPos = toCipher - 65;
        if(sPos >= 26) {
            sPos -= 26;
        }
        int oPos = (int) type.wireMap.charAt(sPos) - currentPosition;
        if(oPos - 64 <= 0) {
            oPos += 26;
        }
        return (char) (oPos);
    }

    public char arccipher(char toCipher) {
        toCipher = Character.toUpperCase(toCipher);
        int sPos = toCipher + currentPosition;
        int oPos = type.wireMap.indexOf(sPos) + 65 - currentPosition;
        return (char) (oPos);
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
