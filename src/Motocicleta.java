/**
 * CLASE HIJA: Motocicleta
 *
 * Igual que Automovil: hereda todo de Vehiculo y solo cambia los números.
 *  - Tarifa: 2000 pesos por hora.
 *  - Descuento: 5 % si estuvo MÁS de 8 horas.
 */
public class Motocicleta extends Vehiculo {

    public Motocicleta(int horas) {
        //       tipo           horas  tarifa  horasDesc  %desc
        super("Motocicleta", horas, 2000, 8, 5);
    }
}
