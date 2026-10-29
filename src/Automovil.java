/**
 * CLASE HIJA: Automovil
 *
 * "extends Vehiculo" significa: un Automovil ES UN Vehiculo.
 * Por eso HEREDA todo lo del padre (calcular valor, descuento, comprobante...)
 * sin volver a escribirlo. Esto se llama HERENCIA.
 *
 * Lo único propio del automóvil son sus números:
 *  - Tarifa: 4000 pesos por hora.
 *  - Descuento: 10 % si estuvo MÁS de 5 horas.
 */
public class Automovil extends Vehiculo {

    public Automovil(int horas) {
        // "super(...)" llama al constructor del PADRE y le entrega los datos del automóvil.
        //       tipo         horas  tarifa  horasDesc  %desc
        super("Automóvil", horas, 4000, 5, 10);
    }
}
