// 32.	Write a program to set the TCP client socket options.

import java.io.*;
import java.net.*;

public class TCPClientSocketOptions {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("www.example.com", 80);
            socket.setSoTimeout(5000); // Set read timeout to 5 seconds
            socket.setTcpNoDelay(true); // Disable Nagle's algorithm

            // Print configured socket options
            System.out.println("SoTimeout: " + socket.getSoTimeout());
            System.out.println("TcpNoDelay: " + socket.getTcpNoDelay());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
