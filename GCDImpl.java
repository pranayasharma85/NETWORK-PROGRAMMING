// 45.	Write a program to calculate GCD using RMI

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GCDImpl extends UnicastRemoteObject implements GCD {

    protected GCDImpl() throws RemoteException {
        super();
    }

    @Override
    public int computeGCD(int a, int b) throws RemoteException {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
