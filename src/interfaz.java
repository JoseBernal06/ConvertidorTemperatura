import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfaz extends Remote {
    double celsiusAFahrenheit(double celsius) throws RemoteException;
    double fahrenheitACelsius(double fahrenheit) throws RemoteException;
}
