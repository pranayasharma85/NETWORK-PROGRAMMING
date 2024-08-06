// 42.	Write a program to set the UDP socket options.
import java.net.*;

public class UDPSocketOptions {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            socket.setSoTimeout(2000); // Set timeout to 2 seconds
            socket.setReceiveBufferSize(4096); // Set receive buffer size to 4 KB
            socket.setSendBufferSize(4096); // Set send buffer size to 4 KB
            socket.setBroadcast(true); // Enable broadcast
            System.out.println("Timeout: " + socket.getSoTimeout());
            System.out.println("Receive Buffer Size: " + socket.getReceiveBufferSize());
            System.out.println("Send Buffer Size: " + socket.getSendBufferSize());
            System.out.println("Broadcast: " + socket.getBroadcast());
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
