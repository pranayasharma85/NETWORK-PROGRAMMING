// 34.	Write a program to create http file server.

import java.io.*;
import java.net.*;

public class HTTPFileServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("HTTP file server is listening on port 8080");
            while (true) {
                Socket socket = serverSocket.accept();
                new HTTPClientHandler(socket).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class HTTPClientHandler extends Thread {
    private Socket socket;

    public HTTPClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String requestLine = in.readLine();
            if (requestLine != null && requestLine.startsWith("GET")) {
                String fileName = requestLine.split(" ")[1].substring(1);
                File file = new File(fileName);
                if (file.exists() && !file.isDirectory()) {
                    out.println("HTTP/1.1 200 OK");
                    out.println("Content-Type: text/html");
                    out.println("Content-Length: " + file.length());
                    out.println();

                    BufferedReader fileReader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = fileReader.readLine()) != null) {
                        out.println(line);
                    }
                    fileReader.close();
                } else {
                    out.println("HTTP/1.1 404 Not Found");
                    out.println();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
