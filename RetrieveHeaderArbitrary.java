// 20.	Write a program to retrieve information from header using arbitrary header methods.
import java.io.*;
import java.net.*;
import java.util.*;

public class RetrieveHeaderArbitrary {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.example.com");
            URLConnection connection = url.openConnection();
            connection.connect();

            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
