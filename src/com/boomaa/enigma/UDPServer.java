package com.boomaa.enigma;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer extends Thread {
    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[256];

    public UDPServer() {
        try {
            socket = new DatagramSocket(5818);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            running = true;

            while (running) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                packet = new DatagramPacket(buf, buf.length, packet.getAddress(), packet.getPort());
                String received
                        = new String(packet.getData(), 0, packet.getLength());

                if (received.equals("end")) {
                    running = false;
                    continue;
                }
                socket.send(packet);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
