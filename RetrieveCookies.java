// 18.	Write a program to retrieve cookies information.

import java.net.*;
import java.util.*;
import java.io.IOException;


public class RetrieveCookies {
    public static void main(String[] args) {
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);

        // Example URL
        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.getContent();

            // Retrieve cookies
            List<HttpCookie> cookies = cookieManager.getCookieStore().getCookies();
            for (HttpCookie cookie : cookies) {
                System.out.println("Cookie: " + cookie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
