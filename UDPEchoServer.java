// 38.	Write a program to create UDP echo server and client.
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class UDPEchoServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(4445);
        byte[] buffer = new byte[256];

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            socket.send(packet);
        }
    }
}
