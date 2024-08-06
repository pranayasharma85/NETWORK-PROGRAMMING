// 37.	Write a program to create a TCP client and server to share text messages using NIO.

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress("localhost", 5454));

        while (true) {
            SocketChannel socketChannel = serverSocket.accept();
            ByteBuffer buffer = ByteBuffer.allocate(256);
            socketChannel.read(buffer);
            System.out.println("Received: " + new String(buffer.array()).trim());
            buffer.flip();
            socketChannel.write(buffer);
            socketChannel.close();
        }
    }
}
