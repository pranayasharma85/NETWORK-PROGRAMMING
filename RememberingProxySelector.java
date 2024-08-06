// 16.	write a program for a  ProxySelector that remembers what it can connect to.
import java.net.*;
import java.util.*;
import java.io.IOException;

public class RememberingProxySelector extends ProxySelector {
    private Map<URI, Proxy> rememberedProxies = new HashMap<>();

    @Override
    public List<Proxy> select(URI uri) {
        List<Proxy> proxies = new ArrayList<>();
        if (rememberedProxies.containsKey(uri)) {
            proxies.add(rememberedProxies.get(uri));
        } else {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.example.com", 8080));
            rememberedProxies.put(uri, proxy);
            proxies.add(proxy);
        }
        return proxies;
    }

    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        System.out.println("Connection failed to " + uri + " via " + sa);
        rememberedProxies.remove(uri);
    }

    public static void main(String[] args) {
        ProxySelector.setDefault(new RememberingProxySelector());
        try {
            URL url = new URL("http://www.example.com");
            URLConnection conn = url.openConnection();
            conn.connect();
            System.out.println("Connected to " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
