//2.	Write a program to implement InetAddress getter methods.
import java.net.*;
import java.io.*;

public class InetAddressExample {
    
    public static void main(String[] args) {
        try {
            // Get the local host address
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Host Name: " + localHost.getHostName());
            System.out.println("Local Host Address: " + localHost.getHostAddress());
            

            // Get the address by host name
            String hostName = "www.example.com";
            InetAddress hostAddress = InetAddress.getByName(hostName);
            System.out.println("Host Name: " + hostAddress.getHostName());
            System.out.println("Host Address: " + hostAddress.getHostAddress());

            // Get all IP addresses associated with a host name
            InetAddress[] allByName = InetAddress.getAllByName(hostName);
            System.out.println("All addresses for " + hostName + ":");
            for (InetAddress address : allByName) {
                System.out.println(address);
            }

        } catch (UnknownHostException e) {
            System.err.println("Unable to determine IP address for the provided host.");
            e.printStackTrace();
        }
    }
}
