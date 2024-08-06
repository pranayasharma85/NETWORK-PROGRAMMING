// 45.	Write a program to calculate GCD using RMI

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GCD extends Remote {
    int computeGCD(int a, int b) throws RemoteException;
}
 


// run terminal in this command
// javac GCD.java GCDImpl.java GCDServer.java GCDClient.java
// java GCDServer
// java GCDClient

// java GCDClient.java