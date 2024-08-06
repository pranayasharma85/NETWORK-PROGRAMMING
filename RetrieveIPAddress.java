// 7.	Write a program to retrieve IP address providing Interface address or MAC address.
import java.net.*;
import java.util.*;

public class RetrieveIPAddress {
    public static void main(String[] args) {
        try {
            // Retrieve and display network interfaces
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();
                System.out.println("Display Name: " + ni.getDisplayName());
                System.out.println("Name: " + ni.getName());
                byte[] mac = ni.getHardwareAddress();
                if (mac != null) {
                    System.out.print("MAC Address: ");
                    for (int i = 0; i < mac.length; i++) {
                        System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
                    }
                    System.out.println();
                }

                // Get and display all IP addresses associated with this interface
                Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress ia = inetAddresses.nextElement();
                    System.out.println("IP Address: " + ia.getHostAddress());
                }
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
