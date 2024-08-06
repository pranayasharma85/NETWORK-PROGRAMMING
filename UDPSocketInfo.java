// 36.	Write a program to get information about the UDP socket.

import java.net.*;

public class UDPSocketInfo {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            System.out.println("Local Port: " + socket.getLocalPort());
            System.out.println("Broadcast: " + socket.getBroadcast());
            System.out.println("Reuse Address: " + socket.getReuseAddress());
            System.out.println("Receive Buffer Size: " + socket.getReceiveBufferSize());
            System.out.println("Send Buffer Size: " + socket.getSendBufferSize());
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
