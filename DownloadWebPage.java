// 21.	Write a program to download a web page with the correct character set.

import java.io.*;
import java.net.*;

public class DownloadWebPage {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.example.com");
            URLConnection connection = url.openConnection();
            String contentType = connection.getContentType();
            String charset = "UTF-8"; // default

            if (contentType != null && contentType.contains("charset=")) {
                charset = contentType.substring(contentType.indexOf("charset=") + 8);
            }

            InputStream inputStream = connection.getInputStream();
            Reader reader = new InputStreamReader(inputStream, charset);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
