// 18.	Write a program to retrieve cookies information.
import java.net.*;
import java.io.IOException;


public class CustomCookiePolicy implements CookiePolicy {
    @Override
    public boolean shouldAccept(URI uri, HttpCookie cookie) {
        return !uri.getHost().endsWith(".gov");
    }

    public static void main(String[] args) {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(new CustomCookiePolicy());
        CookieHandler.setDefault(cookieManager);

        // Example usage
        try {
            URL url = new URL("http://example.gov");
            URLConnection connection = url.openConnection();
            connection.getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
