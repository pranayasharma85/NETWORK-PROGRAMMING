// 39.	Write a program to create a UDP daytime client and server.

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

public class UDPDaytimeServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(4446);
        byte[] buffer = new byte[256];

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String daytime = new Date().toString();
            buffer = daytime.getBytes();
            packet = new DatagramPacket(buffer, buffer.length, packet.getAddress(), packet.getPort());
            socket.send(packet);
        }
    }
}