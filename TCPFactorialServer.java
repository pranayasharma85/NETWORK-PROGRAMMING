// 29.	Write a program to create a TCP client and server to calculate factorial.

import java.io.*;
import java.net.*;

public class TCPFactorialServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Factorial server is listening on port 12345");
            while (true) {
                Socket socket = serverSocket.accept();
                new FactorialClientHandler(socket).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
class FactorialClientHandler extends Thread {
    private Socket socket;

    public FactorialClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String input;
            while ((input = in.readLine()) != null) {
                int number = Integer.parseInt(input);
                int result = factorial(number);
                out.println("Factorial of " + number + " is " + result);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private int factorial(int number) {
        if (number == 0) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }
}
