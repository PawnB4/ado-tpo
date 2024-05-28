package classes;

import exceptions.PagoException;
import interfaces.IProcesadorPagos;

public class ProcesadorPagoMP implements IProcesadorPagos {
    public void procesarPago(double importeAbonar, double monto) {
        try {
            validarPago(importeAbonar, monto);
            realizarPago();
        } catch (PagoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void realizarPago() {
        System.out.println("Pago realizado con éxito a través de Mercado Pago");
    }

    private void validarPago(double importeAbonar, double monto) throws PagoException {
        if (monto < importeAbonar) {
            throw new PagoException("El monto proporcionado no es suficiente para el importe correspondiente.\n" +
                    "Total a pagar: $" + importeAbonar + "\n" +
                    "Monto proporcionado: $" + monto
            );
        }
    }
}
