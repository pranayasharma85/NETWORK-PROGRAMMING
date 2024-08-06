// 45.	Write a program to calculate GCD using RMI

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class GCDServer {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            GCDImpl gcd = new GCDImpl();
            Naming.rebind("rmi://localhost:1099/GCDService", gcd);
            System.out.println("GCD Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
