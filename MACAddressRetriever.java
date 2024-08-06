// 8.	Write a program to retrieve MAC address providing an IP address.

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class MACAddressRetriever {
    public static void main(String[] args) {
        try {
            // Replace this with the IP address you want to find the MAC address for
            String ipAddress = "192.168.0.4";
            InetAddress address = InetAddress.getByName(ipAddress);

            // Get NetworkInterface for the current address
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(address);

            // If the address does not belong to any interface
            if (networkInterface == null) {
                System.out.println("Address does not belong to any network interface.");
                return;
            }

            // Get the MAC address
            byte[] mac = networkInterface.getHardwareAddress();
            if (mac == null) {
                System.out.println("MAC address not found.");
                return;
            }

            // Convert the byte array to a string
            StringBuilder macAddress = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                macAddress.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }

            System.out.println("MAC address: " + macAddress.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
