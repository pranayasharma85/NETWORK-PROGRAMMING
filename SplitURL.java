//11.	Write a program to split URL.

import java.net.URL;

public class SplitURL {
    public static void main(String[] args) {
        try {
            // Create a URL object
            URL url = new URL("https://www.example.com:8080/path/to/resource?query=java#fragment");

            // Get and print each part of the URL
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Fragment: " + url.getRef());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
