import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class servidorConversor {
    public static void main(String[] args) {
        try {
            interfaz conversor;
            conversor = new ImplementationConverse();
            Registry registro = LocateRegistry.createRegistry(1099);
            registro.rebind("ConversorRMI", conversor);
            System.out.println("Servidor de Conversión de Temperatura RMI listo.");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
