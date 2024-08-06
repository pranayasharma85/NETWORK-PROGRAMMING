// 35.	Illustrate the procedure of creating secure client and server socket.

import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class EchoSSLServer{
    public static void main(String[] args) throws Exception {
        // Load the keystore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("D:/BCA/6th-sem/NP/labqn/keystore.jks"), "password".toCharArray());

        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, "password".toCharArray());

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), null, null);

        SSLServerSocketFactory serverFactory = sslContext.getServerSocketFactory();
        SSLServerSocket serverSocket = (SSLServerSocket) serverFactory.createServerSocket(8443);
        serverSocket.setNeedClientAuth(false);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            new Thread(new EchoHandler(clientSocket)).start();
        }
    }
}

class EchoHandler implements Runnable {
    private SSLSocket socket;

    public EchoHandler(SSLSocket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));

            String line;
            while ((line = in.readLine()) != null) {
                out.println(line);
                out.flush();
            }

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

