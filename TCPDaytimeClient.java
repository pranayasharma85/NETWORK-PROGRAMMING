// 27.	Write a program to create a TCP daytime client and server.

import java.io.*;
import java.net.*;

public class TCPDaytimeClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverTime = in.readLine();
            System.out.println("Server time: " + serverTime);
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
