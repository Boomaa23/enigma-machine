package com.boomaa.enigma.util;

import com.boomaa.enigma.logic.EnigmaLogic;

public class EnigmaMessage {
    private char[] textChars;

    public EnigmaMessage(String text) {
        this.textChars = text.toUpperCase().replaceAll("\\s","").toCharArray();
    }

    public EnigmaMessage applyPlugboard() {
        EnigmaLogic.applyPlugboard(this);
        return this;
    }

    public EnigmaMessage applyRotors() {
        EnigmaLogic.applyRotors(this);
        return this;
    }

    public char getCharAt(int position) {
        return textChars[position];
    }

    public void setChar(int position, char value) {
        textChars[position] = value;
    }

    public int getLength() {
        return textChars.length;
    }

    @Override
    public String toString() {
        return String.valueOf(textChars);
    }
}
