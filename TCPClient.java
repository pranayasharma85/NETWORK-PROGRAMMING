//37.	Write a program to create a TCP client and server to share text messages using NIO.
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        InetSocketAddress address = new InetSocketAddress("localhost", 5454);
        SocketChannel socketChannel = SocketChannel.open(address);

        String message = "Hello, this is a message!";
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
        socketChannel.write(buffer);

        buffer.clear();
        socketChannel.read(buffer);
        System.out.println("Received from server: " + new String(buffer.array()).trim());
        socketChannel.close();
    }
}