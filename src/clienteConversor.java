import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class clienteConversor {
    public static void main(String[] args) {
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            interfaz conversor = (interfaz) registro.lookup("ConversorRMI");

            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n--- Conversor de Temperatura RMI ---");
                System.out.println("Opciones: c2f (Celsius a Fahrenheit), f2c (Fahrenheit a Celsius), salir");
                System.out.print("Selecciona una opción: ");
                String opcion = sc.nextLine().trim().toLowerCase();

                if (opcion.equals("salir")) {
                    System.out.println("Saliendo del conversor...");
                    break;
                }

                if (!opcion.equals("c2f") && !opcion.equals("f2c")) {
                    System.out.println("Opción inválida.");
                    continue;
                }

                System.out.print("Ingresa la temperatura: ");
                double temp = Double.parseDouble(sc.nextLine());

                double resultado = 0;
                if (opcion.equals("c2f")) {
                    resultado = conversor.celsiusAFahrenheit(temp);
                    System.out.println(temp + "°C = " + resultado + "°F");
                } else {
                    resultado = conversor.fahrenheitACelsius(temp);
                    System.out.println(temp + "°F = " + resultado + "°C");
                }
            }

        } catch (RemoteException | NotBoundException e) {
            System.err.println("Error RMI: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error: Temperatura no válida.");
        }
    }
}
