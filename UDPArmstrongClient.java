// 41.	Write a program to create a UDP client and server to check given number is Armstrong or not.

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPArmstrongClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");

        String message = "153"; // Change this number to test other numbers
        byte[] buf = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4448);
        socket.send(packet);

        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        System.out.println("Received: " + new String(packet.getData(), 0, packet.getLength()));
        socket.close();
    }
}