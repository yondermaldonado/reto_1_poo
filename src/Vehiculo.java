/**
 * CLASE PADRE: Vehiculo
 *
 * Piensa en una clase como un MOLDE (como el molde de una galleta).
 * Con el molde "Vehiculo" se pueden hacer muchos vehículos.
 *
 * Aquí está TODO lo que un automóvil y una moto tienen en común:
 *  - Datos (atributos): tipo, horas, tarifa, y la regla del descuento.
 *  - Acciones (métodos): calcular el valor, el descuento, el total y mostrar el comprobante.
 *
 * Así el código se escribe UNA sola vez y lo reutilizan Automovil y Motocicleta.
 */
public class Vehiculo {

    // ATRIBUTOS: los datos que guarda cada vehículo.
    // "private" = solo esta clase puede tocarlos directamente (así se protegen).
    private String tipo;                 // "Automóvil" o "Motocicleta"
    private int horas;                   // horas que estuvo en el parqueadero
    private long tarifaPorHora;          // pesos que cuesta cada hora
    private int horasParaDescuento;      // el descuento aplica si pasa de estas horas
    private int porcentajeDescuento;     // cuánto % de descuento se da

    /**
     * CONSTRUCTOR: se ejecuta cuando creamos un vehículo con "new".
     * Su trabajo es guardar los datos que le llegan.
     *
     * "this.horas = horas" significa: guarda en el ATRIBUTO (this.horas)
     * el valor que llegó como PARÁMETRO (horas).
     */
    public Vehiculo(String tipo, int horas, long tarifaPorHora,
                    int horasParaDescuento, int porcentajeDescuento) {
        this.tipo = tipo;
        this.horas = horas;
        this.tarifaPorHora = tarifaPorHora;
        this.horasParaDescuento = horasParaDescuento;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    /** GETTER: permite LEER el atributo "tipo" desde afuera (porque es private). */
    public String getTipo() {
        return tipo;
    }

    /** Valor inicial = tarifa por hora x horas. */
    public long calcularValorInicial() {
        return tarifaPorHora * horas;
    }

    /** Descuento: solo si pasó MÁS de las horas permitidas (con justo esas horas no hay). */
    public long calcularDescuento() {
        if (horas > horasParaDescuento) {
            return calcularValorInicial() * porcentajeDescuento / 100;
        }
        return 0; // no cumple: sin descuento
    }

    /** Total a pagar = valor inicial - descuento. */
    public long calcularTotalPagar() {
        return calcularValorInicial() - calcularDescuento();
    }

    /** Muestra el comprobante de pago en la consola. */
    public void mostrarComprobante() {
        System.out.println("\nCOMPROBANTE DE PAGO");
        System.out.println("Tipo de vehículo: " + tipo);
        System.out.println("Valor inicial: " + calcularValorInicial() + " pesos");
        System.out.println("Descuento: " + calcularDescuento() + " pesos");
        System.out.println("Total a pagar: " + calcularTotalPagar() + " pesos");
    }
}
