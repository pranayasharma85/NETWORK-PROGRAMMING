// 24.	Write a to download webpage using  URLConnection.

import java.io.*;
import java.net.*;

public class DownloadUsingURLConnection {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.example.com");
            URLConnection connection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            BufferedWriter out = new BufferedWriter(new FileWriter("downloaded_page.html"));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.write(inputLine);
                out.newLine();
            }
            in.close();
            out.close();
            System.out.println("Web page downloaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
