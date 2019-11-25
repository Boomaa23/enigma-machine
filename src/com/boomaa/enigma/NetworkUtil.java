package com.boomaa.enigma;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class NetworkUtil {
    private static DatagramSocket socket;
    private static byte[] buffer = new byte[256];

    static {
        try {
            socket = new DatagramSocket(5818);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public static void sendPacket(String message) {
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        try {
            socket.receive(packet);
            packet = new DatagramPacket(buffer, buffer.length, packet.getAddress(), packet.getPort());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String recievePacket() {
        return null;
    }
}
