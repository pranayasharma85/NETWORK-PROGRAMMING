// 28.	Write a program to create a TCP client and server to share text messages.
import java.io.*;
import java.net.*;

public class TCPTextClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String text;

            System.out.println("Enter text: ):");
            while ((text = consoleReader.readLine()) != null) {
                out.println(text);
                String response = in.readLine();
                System.out.println(response);
                if ("bye".equalsIgnoreCase(text)) {
                    break;
                }
            }
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
