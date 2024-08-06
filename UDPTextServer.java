// 40.	Write a program to create a UDP client and server to share text messages.

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPTextServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(4447);
        byte[] buffer = new byte[256];

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            System.out.println("Received: " + new String(packet.getData(), 0, packet.getLength()));
        }
    }
}
