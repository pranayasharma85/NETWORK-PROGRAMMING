//14.	Write a program to show the use of URLEncoder Class.
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLEncoderExample {
    public static void main(String[] args) {
        try {
            String url = "http://www.example.com/search?q=java network programming";
            String encodedURL = URLEncoder.encode(url, "UTF-8");
            System.out.println("Encoded URL: " + encodedURL);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
