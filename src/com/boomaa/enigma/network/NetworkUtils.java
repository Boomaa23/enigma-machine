package com.boomaa.enigma.network;

import java.io.IOException;
import java.net.*;

public class NetworkUtils {
    public static DatagramSocket socket;

    static {
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public static void sendPacket(String message, String remote) {
        try {
            byte[] data = message.getBytes();
            socket.send(new DatagramPacket(data, data.length,
                    InetAddress.getByName(remote), 5818));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
