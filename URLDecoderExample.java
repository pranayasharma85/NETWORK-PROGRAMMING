// 15.	Write a program to show the use of URLDecoder Class.

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLDecoderExample {
    public static void main(String[] args) {
        try {
            String encodedURL = "http%3A%2F%2Fwww.example.com%2Fsearch%3Fq%3Djava+network+programming";
            String decodedURL = URLDecoder.decode(encodedURL, "UTF-8");
            System.out.println("Decoded URL: " + decodedURL);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
