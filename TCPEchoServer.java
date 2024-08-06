// 26.	Write a program to create TCP echo server and client.

import java.io.*;
import java.net.*;

public class TCPEchoServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345");
            while (true) {
                Socket socket = serverSocket.accept();
                new EchoClientHandler(socket).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class EchoClientHandler extends Thread {
    private Socket socket;

    public EchoClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String text;
            while ((text = in.readLine()) != null) {
                System.out.println("Received: " + text);
                out.println(text);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
