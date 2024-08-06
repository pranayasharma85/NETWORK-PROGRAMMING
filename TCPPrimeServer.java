// 31.	Write a program to create a Multi-threaded TCP server and client to check the prime number.

import java.io.*;
import java.net.*;

public class TCPPrimeServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Prime server is listening on port 12345");
            while (true) {
                Socket socket = serverSocket.accept();
                new PrimeClientHandler(socket).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class PrimeClientHandler extends Thread {
    private Socket socket;

    public PrimeClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String input;
            while ((input = in.readLine()) != null) {
                int number = Integer.parseInt(input);
                boolean isPrime = checkPrime(number);
                out.println("Number " + number + " is prime: " + isPrime);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean checkPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
