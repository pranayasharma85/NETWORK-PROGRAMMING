//10.	Write a program to retrieve data from URL

import java.io.InputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class RetrieveURLData {

    public static void main(String[] args) {
        // Specify the URL
        String urlString = "http://www.example.com";
        
        // Create a URL object
        try {
            URL url = new URL(urlString);
            
            // Open a connection to the URL and retrieve an InputStream
            try (InputStream inputStream = url.openStream()) {
                
                // Read data from the InputStream and print it
                int data;
                while ((data = inputStream.read()) != -1) {
                    System.out.print((char) data);
                }
                
            } catch (IOException e) {
                System.err.println("Error reading data from URL: " + e.getMessage());
            }
            
        } catch (MalformedURLException e) {
            System.err.println("Malformed URL: " + e.getMessage());
        }
    }
}
