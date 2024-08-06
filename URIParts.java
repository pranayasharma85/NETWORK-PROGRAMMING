//13.	Write a program to display the parts of URI.

import java.net.URI;
import java.net.URISyntaxException;

public class URIParts {
    public static void main(String[] args) {
        try {
            URI uri = new URI("http://www.example.com:80/path?query#fragment");
            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("Authority: " + uri.getAuthority());
            System.out.println("Host: " + uri.getHost());
            System.out.println("Port: " + uri.getPort());
            System.out.println("Path: " + uri.getPath());
            System.out.println("Query: " + uri.getQuery());
            System.out.println("Fragment: " + uri.getFragment());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
