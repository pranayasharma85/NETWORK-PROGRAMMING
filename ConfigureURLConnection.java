// 23.	Write a program to configure URLConnection.

import java.io.*;
import java.net.*;

public class ConfigureURLConnection {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true); // allows POST method
            connection.setConnectTimeout(5000); // 5 seconds timeout
            connection.setReadTimeout(5000); // 5 seconds timeout

            // Print configured properties
            System.out.println("DoOutput: " + connection.getDoOutput());
            System.out.println("ConnectTimeout: " + connection.getConnectTimeout());
            System.out.println("ReadTimeout: " + connection.getReadTimeout());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
