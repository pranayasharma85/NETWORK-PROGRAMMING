// 28.	Write a program to create a TCP client and server to share text messages.

import java.io.*;
import java.net.*;

public class TCPTextServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Text server is listening on port 12345");
            while (true) {
                Socket socket = serverSocket.accept();
                new TextClientHandler(socket).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class TextClientHandler extends Thread {
    private Socket socket;

    public TextClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String text;
            while ((text = in.readLine()) != null) {
                System.out.println("Received: " + text);
                out.println("Echo: " + text);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
