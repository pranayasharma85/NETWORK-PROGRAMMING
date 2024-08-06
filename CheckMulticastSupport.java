import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class CheckMulticastSupport {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();
                System.out.println("Interface: " + ni.getName() + ", Supports multicast: " + ni.supportsMulticast());
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
