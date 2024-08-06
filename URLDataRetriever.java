// 10.	Write a program to retrieve data from URL
import java.io.*;
import java.net.*;

public class URLDataRetriever {
    public static void main(String[] args) {
        // URL to retrieve data from
        String urlString = "http://www.example.com";
        
        try {
            // Create a URL object
            URL url = new URL(urlString);
            
            // Open a stream to the URL
            InputStream inputStream = url.openStream();
            
            // Create a BufferedReader to read the data from the InputStream
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            
            // Read and print the data line by line
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            // Close the BufferedReader and InputStream
            reader.close();
            inputStream.close();
        } catch (MalformedURLException e) {
            System.err.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}
