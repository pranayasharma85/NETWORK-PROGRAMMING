// 19.	Write a program to retrieve information from header using header specific methods.

import java.io.*;
import java.net.*;

public class RetrieveHeaderSpecific {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();

            System.out.println("Content-Type: " + connection.getContentType());
            System.out.println("Content-Length: " + connection.getContentLength());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
