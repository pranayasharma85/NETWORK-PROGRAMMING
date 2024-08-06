// 27.	Write a program to create a TCP daytime client and server.

import java.io.*;
import java.net.*;
import java.util.Date;

public class TCPDaytimeServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Daytime server is listening on port 12345");
            while (true) {
                Socket socket = serverSocket.accept();
                new DaytimeClientHandler(socket).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class DaytimeClientHandler extends Thread {
    private Socket socket;

    public DaytimeClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            String currentTime = new Date().toString();
            out.println(currentTime);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
