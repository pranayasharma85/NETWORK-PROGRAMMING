// 30.	Write a program to create a TCP client and server to share a text file.

import java.io.*;
import java.net.*;

public class TCPFileClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the name of the file to retrieve:");
            String fileName = consoleReader.readLine();
            out.println(fileName);

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
