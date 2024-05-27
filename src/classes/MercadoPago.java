package classes;

import exceptions.PagoException;
import interfaces.IProcesadorPagos;

public class MercadoPago implements IProcesadorPagos {
    public void procesarPago(Alumno alumno, double monto) {
        try {
            validarPago(alumno, monto);
            realizarPago();
        } catch (PagoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void realizarPago() {
        System.out.println("Pago realizado con éxito con Mercado Pago");
    }

    private void validarPago(Alumno alumno, double monto) throws PagoException {
        if (monto < alumno.obtenerMontoProximaFactura()) {
            throw new PagoException("El monto proporcionado no es suficiente para abonar la primer cuota de cada curso al cual está inscripto.\n" +
                    "Total a pagar: $" + alumno.obtenerMontoProximaFactura() + "\n" +
                    "Monto proporcionado: $" + monto
            );
        }
    }
}
