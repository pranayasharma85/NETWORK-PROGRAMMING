// 25.	Write a program to get information about the TCP socket.
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketInfo {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("www.example.com", 80);
            System.out.println("Remote Address: " + socket.getRemoteSocketAddress());
            System.out.println("Local Address: " + socket.getLocalSocketAddress());
            System.out.println("Port: " + socket.getPort());
            System.out.println("Local Port: " + socket.getLocalPort());
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
