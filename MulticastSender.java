// 44.	Write a program for multicast sniffer.
import java.io.*;
import java.net.*;

public class MulticastSender {

    public static void main(String[] args) {
        InetAddress ia = null;
        int port = 0;
        byte ttl = (byte) 1;
        try {
            ia = InetAddress.getByName("all-systems.mcast.net");
            port = 4000;
            if (args.length > 2) {
                ttl = (byte) Integer.parseInt(args[2]);
            }
        } catch (NumberFormatException | IndexOutOfBoundsException
                | UnknownHostException ex) {
            System.err.println(ex);
            System.err.println(
                    "Usage: java MulticastSender multicast_address port ttl");
            System.exit(1);
        }
        byte[] data = "Here's some multicast data\r\n".getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length, ia, port);
        try (MulticastSocket ms = new MulticastSocket()) {
            ms.setTimeToLive(ttl);
            ms.joinGroup(ia);
            for (int i = 1; i < 10; i++) {
                ms.send(dp);
            }
            ms.leaveGroup(ia);
        } catch (SocketException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}