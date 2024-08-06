// 33.	Write a program to set the TCP server socket options.

import java.io.*;
import java.net.*;

public class TCPServerSocketOptions {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            serverSocket.setSoTimeout(5000); // Set accept timeout to 5 seconds
            serverSocket.setReuseAddress(true); // Allow address reuse

            // Print configured socket options
            System.out.println("SoTimeout: " + serverSocket.getSoTimeout());
            System.out.println("ReuseAddress: " + serverSocket.getReuseAddress());

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
