// 39.	Write a program to create a UDP daytime client and server.
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPDaytimeClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");

        byte[] buf = new byte[256];
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4446);
        socket.send(packet);

        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        System.out.println("Received: " + new String(packet.getData(), 0, packet.getLength()));
        socket.close();
    }
}