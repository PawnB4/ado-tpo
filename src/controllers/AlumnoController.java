package controllers;

import classes.Alumno;
import classes.AlumnoManager;

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

    public Alumno buscarAlumno(int LU){
        return this.alumnoManager.buscarAlumno(LU);
    }


}
