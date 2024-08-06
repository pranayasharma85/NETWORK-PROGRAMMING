// 45.	Write a program to calculate GCD using RMI

import java.rmi.Naming;

public class GCDClient {

    public static void main(String[] args) {
        try {
            GCD gcd = (GCD) Naming.lookup("rmi://localhost:1099/GCDService");
            int result = gcd.computeGCD(48, 18);
            System.out.println("GCD of 48 and 18 is: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
