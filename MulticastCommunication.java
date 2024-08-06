// 43.	Illustrate the process for communicating with Multicast group.
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;

public class MulticastCommunication {
    public static void main(String[] args) throws IOException {
        String multicastAddress = "224.0.0.1";
        int port = 8888;
        
        InetAddress group = InetAddress.getByName(multicastAddress);
        NetworkInterface networkInterface = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
        
        try (MulticastSocket socket = new MulticastSocket(null)) {
            // Bind to any available port
            socket.bind(new java.net.InetSocketAddress(port));
            
            // Join the multicast group
            socket.joinGroup(new java.net.InetSocketAddress(group, port), networkInterface);
    
            // Start a thread for receiving messages
            Thread receiver = new Thread(() -> {
                try {
                    byte[] buffer = new byte[256];
                    while (true) {
                        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                        socket.receive(packet);
                        String received = new String(packet.getData(), 0, packet.getLength());
                        System.out.println("Received: " + received);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiver.start();
    
            // Send a message to the multicast group
            String message = "Hello, multicast group!";
            byte[] buf = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, group, port);
            socket.send(packet);
    
            // Leave the multicast group
            socket.leaveGroup(new java.net.InetSocketAddress(group, port), networkInterface);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
