package server;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Desktop
 */
public class CalculatorImpl extends UnicastRemoteObject implements CalculatorInterface, Serializable{

    public CalculatorImpl() throws RemoteException{
    }

    @Override
    public double add(double a, double b) throws RemoteException {
        return a+b;
    }

    @Override
    public double subtract(double a, double b) throws RemoteException {
        return a-b;
    }

    @Override
    public double multiply(double a, double b) throws RemoteException {
        return a*b;
    }

    @Override
    public double divide(double a, double b) throws RemoteException {
        return a/b;
    }

}