// 30.	Write a program to create a TCP client and server to share a text file.

import java.io.*;
import java.net.*;

public class TCPFileServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("File server is listening on port 12345");
            while (true) {
                Socket socket = serverSocket.accept();
                new FileClientHandler(socket).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class FileClientHandler extends Thread {
    private Socket socket;

    public FileClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String fileName = in.readLine();
            File file = new File(fileName);
            if (file.exists() && !file.isDirectory()) {
                BufferedReader fileReader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = fileReader.readLine()) != null) {
                    out.println(line);
                }
                fileReader.close();
            } else {
                out.println("File not found.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
