// 29.	Write a program to create a TCP client and server to calculate factorial.

import java.io.*;
import java.net.*;

public class TCPFactorialClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String input;

            System.out.println("Enter a number to calculate factorial:");
            while ((input = consoleReader.readLine()) != null) {
                out.println(input);
                String response = in.readLine();
                System.out.println(response);
                // if ("bye".equalsIgnoreCase(input)) {
                //     break;
                // }
            }
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
