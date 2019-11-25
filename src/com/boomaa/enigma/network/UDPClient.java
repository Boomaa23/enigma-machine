package com.boomaa.enigma.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPClient extends Thread {
    private DatagramSocket socket;
    private byte[] buffer = new byte[256];

    public UDPClient() {
        try {
            socket = new DatagramSocket(5818);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                //TODO remove this println after testing
                System.out.println(new String(packet.getData()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
