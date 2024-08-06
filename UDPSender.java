

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        byte[] buf = "Hello, Datagram!".getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4449);
        socket.send(packet);
        socket.close();
    }
}