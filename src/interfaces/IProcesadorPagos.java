package interfaces;

import classes.Alumno;

public interface IProcesadorPagos {
    void procesarPago(double importeAbonar, double monto);
}
