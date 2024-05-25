package server;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface CalculatorInterface {
    public double add(double a, double b) throws RemoteException;
    public double subtract(double a, double b) throws RemoteException;
    public double multiply(double a, double b) throws RemoteException;
    public double divide(double a, double b) throws RemoteException;
}
