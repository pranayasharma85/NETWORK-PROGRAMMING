// 9.	Write a program to illustrate factory and getter methods of NetworkInterface Class.

import java.net.*;
import java.util.*;

public class NetworkInterfaceExample {
    public static void main(String[] args) {
        try {
            // Using factory methods
            NetworkInterface niByName = NetworkInterface.getByName("eth0");
            NetworkInterface niByInetAddress = NetworkInterface.getByInetAddress(InetAddress.getByName("127.0.0.1"));
            Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();

            // Displaying the results
            System.out.println("Network Interface by Name (eth0):");
            printNetworkInterfaceDetails(niByName);

            System.out.println("\nNetwork Interface by InetAddress (127.0.0.1):");
            printNetworkInterfaceDetails(niByInetAddress);

            System.out.println("\nAll Network Interfaces:");
            while (nis.hasMoreElements()) {
                NetworkInterface ni = nis.nextElement();
                printNetworkInterfaceDetails(ni);
            }
        } catch (SocketException | UnknownHostException ex) {
            ex.printStackTrace();
        }
    }

    private static void printNetworkInterfaceDetails(NetworkInterface ni) {
        if (ni == null) {
            System.out.println("No such interface found.");
            return;
        }

        // Using getter methods
        System.out.println("Name: " + ni.getName());
        System.out.println("Display Name: " + ni.getDisplayName());
        System.out.print("Addresses: ");
        Enumeration<InetAddress> addresses = ni.getInetAddresses();
        while (addresses.hasMoreElements()) {
            InetAddress addr = addresses.nextElement();
            System.out.print(addr + " ");
        }
        System.out.println("\n-----------------------");
    }
}
