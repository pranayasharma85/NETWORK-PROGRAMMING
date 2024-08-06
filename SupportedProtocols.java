//12.	Write a program to check which protocol does a virtual machine support?

import java.util.Properties;

public class SupportedProtocols {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        String protocols = properties.getProperty("java.protocol.handler.pkgs");
        if (protocols != null) {
            System.out.println("Supported protocols: " + protocols);
        } else {
            System.out.println("No specific protocols defined.");
        }
    }
}
