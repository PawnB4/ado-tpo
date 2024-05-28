package controllers;

import classes.*;
import interfaces.IProcesadorPagos;

public class AlumnoController {

    private static AlumnoController instance;
    private AlumnoManager alumnoManager;

    private AlumnoController() {
        this.alumnoManager = new AlumnoManager();
    }

    public static AlumnoController getInstance() {
        if (instance == null) {
            instance = new AlumnoController();
        }
        return instance;
    }

    public void crearAlumno(String nombre, String apellido, int LU) {
        this.alumnoManager.crearAlumno(nombre, apellido, LU);
    }

    public Alumno buscarAlumno(int LU) {
        return this.alumnoManager.buscarAlumno(LU);
    }

    public void abonarCuotaMensual(int LU, double monto, String medioDePago) {
        Alumno alumno = buscarAlumno(LU);
        if (alumno == null) {
            System.out.println("El ID proporcionado no corresponde con un alumno existente");
            return;
        }
        PagoController.getInstance().abonarCuotaMensual(medioDePago, alumno.obtenerMontoProximaFactura(), monto);
    }


}
