package controllers;

import classes.Alumno;
import classes.Carrera;
import classes.InscripcionManager;

import java.time.LocalDate;

public class InscripcionController {

    private static InscripcionController instance;
    private InscripcionManager inscripcionManager;

    private InscripcionController() {
        this.inscripcionManager = new InscripcionManager();
    }

    public static InscripcionController getInstance() {
        if (instance == null) {
            instance = new InscripcionController();
        }
        return instance;
    }

    public void setFechaMaximaDeInscripcion(int year, int month, int day) {
        this.inscripcionManager.setFechaMaximaInscripcion(LocalDate.of(year, month, day));
    }

    public void inscribirAlumnoACarrera(int LU, int idCarrera) {
        Alumno alumno = AlumnoController.getInstance().buscarAlumno(LU);
        if (alumno == null) {
            System.out.println("El ID proporcionado no corresponde con un alumno existente");
            return;
        }
        Carrera carrera = CarreraController.getInstance().buscarCarrera(idCarrera);
        if (carrera == null) {
            System.out.println("El ID proporcionado no corresponde con una carrera existente");
            return;
        }
        this.inscripcionManager.inscribirAlumnoACarrera(alumno, carrera);
    }


}
