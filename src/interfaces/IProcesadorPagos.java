package interfaces;

import classes.Alumno;

public interface IProcesadorPagos {
    void procesarPago(Alumno alumno, double monto);
}
