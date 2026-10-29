/**
 * CLASE: Jornada
 *
 * Lleva las CUENTAS del día: cuántos vehículos entraron y cuánta plata se recaudó.
 * Es como la libreta del encargado del parqueadero.
 */
public class Jornada {

    // Contadores (cuentan cuántos vehículos hay)
    private int totalVehiculos = 0;
    private int totalAutos = 0;
    private int totalMotos = 0;

    // Acumuladores (van sumando dinero). Usan "long" para números grandes.
    private long totalIngresado = 0;   // suma de los valores iniciales
    private long totalDescuentos = 0;  // suma de los descuentos
    private long dineroRecaudado = 0;  // suma de lo que realmente se pagó

    /**
     * Anota un vehículo en la libreta.
     * Recibe un "Vehiculo": como Automovil y Motocicleta SON Vehiculo,
     * este mismo método sirve para los dos.
     */
    public void registrarVehiculo(Vehiculo vehiculo) {
        totalVehiculos++; // ++ suma 1

        // Preguntamos el tipo del vehículo y comparamos el texto con equals
        if (vehiculo.getTipo().equals("Automóvil")) {
            totalAutos++;
        } else if (vehiculo.getTipo().equals("Motocicleta")) {
            totalMotos++;
        }

        // "+=" suma al total que ya había
        totalIngresado += vehiculo.calcularValorInicial();
        totalDescuentos += vehiculo.calcularDescuento();
        dineroRecaudado += vehiculo.calcularTotalPagar();
    }

    /** Muestra el resumen final del día. */
    public void mostrarResumen() {
        System.out.println("\n     RESUMEN FINAL DE LA JORNADA");
        System.out.println("Vehículos totales registrados: " + totalVehiculos);
        System.out.println("Automóviles registrados: " + totalAutos);
        System.out.println("Motocicletas registradas: " + totalMotos);
        System.out.println("Total ingresado: " + totalIngresado + " pesos");
        System.out.println("Total de descuentos: " + totalDescuentos + " pesos");
        System.out.println("Total recaudado: " + dineroRecaudado + " pesos");
    }
}
