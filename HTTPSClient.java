// 35.	Illustrate the procedure of creating secure client and server socket.

import javax.net.ssl.*;
import java.io.*;

public class  HTTPSClient {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java HTTPSClient host");
            return;
        }

        String host = args[0];
        int port = 443; // Default HTTPS port

        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) factory.createSocket(host, port);

            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            out.println("GET / HTTP/1.1");
            out.println("Host: " + host);
            out.println();
            out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

