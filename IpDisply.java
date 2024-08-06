// 1.	Write a program to display the IP address of your system.

import java.net.*;
import java.io.*;

public class IpDisply {
   public static void main(String[] args) {
      try {
         InetAddress address = InetAddress.getLocalHost();
         System.out.println("IP address: " + address.getHostAddress());
      } catch (UnknownHostException ex) {
         System.out.println("Could not find IP address for this host");
      }
   }
}  