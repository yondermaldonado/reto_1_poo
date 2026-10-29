import java.util.Scanner;

/**
 * CLASE PRINCIPAL: aquí empieza el programa (el método main).
 *
 * Solo hace de "recepcionista": muestra el menú, pide los datos
 * y crea el vehículo. Los cálculos los hacen las otras clases.
 */
public class S03Reto01Estacionamiento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // sirve para leer lo que escribe el usuario
        Jornada jornada = new Jornada();          // la libreta del día

        int opcion = -1; // empieza en -1 solo para entrar al ciclo

        // El menú se repite mientras el usuario NO elija 0
        while (opcion != 0) {
            mostrarMenu();

            if (scanner.hasNextInt()) {          // ¿escribió un número entero?
                opcion = scanner.nextInt();

                if (opcion == 1 || opcion == 2) {
                    int horas = pedirHoras(scanner);

                    // La variable es de tipo Vehiculo (el padre), pero adentro
                    // puede guardar un Automovil o una Motocicleta (las hijas).
                    Vehiculo vehiculo;
                    if (opcion == 1) {
                        vehiculo = new Automovil(horas);
                    } else {
                        vehiculo = new Motocicleta(horas);
                    }

                    vehiculo.mostrarComprobante();
                    jornada.registrarVehiculo(vehiculo);
                } else if (opcion != 0) {
                    System.out.println("Error: Opción no válida. Por favor, elija 1, 2 o 0.");
                }
            } else {
                System.out.println("Error: Debe ingresar un número entero válido.");
                scanner.next(); // descarta lo que escribió mal para no repetir el error por siempre
            }
        }

        jornada.mostrarResumen();
        scanner.close();
    }

    /** Muestra el menú en la consola. */
    private static void mostrarMenu() {
        System.out.println("\nSISTEMA DE TARIFA DE ESTACIONAMIENTO");
        System.out.println("1 = Automóvil");
        System.out.println("2 = Motocicleta");
        System.out.println("0 = Terminar jornada");
        System.out.print("Seleccione una opción: ");
    }

    /** Pide las horas y repite la pregunta hasta que escriba un entero mayor a 0. */
    private static int pedirHoras(Scanner scanner) {
        int horas = 0;

        while (horas <= 0) {
            System.out.print("Ingrese la cantidad de horas (mayor a 0): ");

            if (scanner.hasNextInt()) {
                horas = scanner.nextInt();
                if (horas <= 0) {
                    System.out.println("Error: Las horas deben ser mayores a cero. Intente nuevamente.");
                }
            } else {
                System.out.println("Error: Las horas deben ser un número entero.");
                scanner.next(); // descarta lo que escribió mal
            }
        }

        return horas; // devuelve las horas válidas a quien llamó el método
    }
}
