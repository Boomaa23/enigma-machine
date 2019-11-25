package com.boomaa.enigma.logic;

import com.boomaa.enigma.display.Display;
import com.boomaa.enigma.display.DisplayElements.*;
import com.boomaa.enigma.network.NetworkUtils;
import com.boomaa.enigma.util.EnigmaMessage;

import javax.swing.*;
import java.awt.event.*;

public class Listeners {
    public static class SendCipheredMessage implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            EnigmaMessage sendData = new EnigmaMessage(Send.MSG_FIELD.getText());
            sendData.applyPlugboard().applyRotors();
            NetworkUtils.sendPacket(sendData.toString(), Send.ADDR_FIELD.getText());
            DisplayHelpers.updateCurrentPositions();
        }
    }

    public static class ChangeRotorPositions implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String send = !RotorPos.ROTOR_A.getText().isBlank() ? RotorPos.ROTOR_A.getText() : Display.ROTOR_A.getCurrentPosition();
            Display.ROTOR_A.setCurrentPosition(send);
            send = !RotorPos.ROTOR_B.getText().isBlank() ? RotorPos.ROTOR_B.getText() : Display.ROTOR_B.getCurrentPosition();
            Display.ROTOR_B.setCurrentPosition(send);
            send = !RotorPos.ROTOR_C.getText().isBlank() ? RotorPos.ROTOR_C.getText() : Display.ROTOR_C.getCurrentPosition();
            Display.ROTOR_C.setCurrentPosition(send);
        }
    }

    public static class ClearTextField extends MouseAdapter {
        private JTextField toClear;

        public ClearTextField(JTextField toClear) {
            this.toClear = toClear;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            toClear.setText("");
        }
    }
}
