package controllers;

import classes.ProcesadorPagoBinance;
import classes.ProcesadorPagoMP;
import classes.ProcesadorPagoPMC;
import interfaces.IProcesadorPagos;

public class PagoController {
    private static PagoController instance;

    private PagoController() {
    }

    public static PagoController getInstance() {
        if (instance == null) {
            instance = new PagoController();
        }
        return instance;
    }

    public void abonarCuotaMensual(String medioDePago, double importeAPagar, double monto) {
        IProcesadorPagos procesadorPagos = obtenerProcesadorPagos(medioDePago);
        if (procesadorPagos == null) return;
        procesadorPagos.procesarPago(importeAPagar, monto);
    }

    private IProcesadorPagos obtenerProcesadorPagos(String medioDePago) {
        switch (medioDePago.toLowerCase()) {
            case "mercado pago":
                return new ProcesadorPagoMP();
            case "pago mis cuentas":
                return new ProcesadorPagoPMC();
            case "binance":
                return new ProcesadorPagoBinance();
            default:
                System.out.println("Procesador de pago no soportado");
                return null;
        }
    }

}
