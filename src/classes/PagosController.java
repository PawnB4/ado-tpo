package classes;

import interfaces.IProcesadorPagos;

public class PagosController {

    private IProcesadorPagos procesadorPagos;

    public PagosController(IProcesadorPagos procesadorPagos) {
        this.procesadorPagos = procesadorPagos;
    }
    public void pagarCuotasCuatrimestre(Alumno alumno) {
        procesadorPagos.procesarPago(alumno);
    }
}

