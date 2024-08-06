
// 5.	Write a program to list the interfaces available in your system.
import java.net.*;
import java.util.*;

public class intrefaceExample {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();
                System.out.println("Interface: " + ni.getName());
                System.out.println("Display Name: " + ni.getDisplayName());
                Enumeration<InetAddress> addresses = ni.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    System.out.println("Address: " + address);
                }
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
