// 41.	Write a program to create a UDP client and server to check given number is Armstrong or not.

import java.io.IOException;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPArmstrongServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(4448);
        byte[] buffer = new byte[256];

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String message = new String(packet.getData(), 0, packet.getLength());
            int number = Integer.parseInt(message.trim());
            String response = isArmstrong(number) ? "Armstrong" : "Not Armstrong";
            buffer = response.getBytes();

            packet = new DatagramPacket(buffer, buffer.length, packet.getAddress(), packet.getPort());
            socket.send(packet);
        }
    }

    private static boolean isArmstrong(int number) {
        int original = number;
        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            sum += digit * digit * digit;
            number /= 10;
        }
        return sum == original;
    }
}
