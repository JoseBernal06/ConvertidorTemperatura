import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementationConverse extends UnicastRemoteObject implements interfaz {

    protected ImplementationConverse() throws RemoteException {
        super();
    }

    public double celsiusAFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public double fahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
