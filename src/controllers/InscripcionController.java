package controllers;

import classes.Alumno;
import classes.Carrera;
import classes.Curso;
import classes.InscripcionManager;

import java.time.LocalDate;

public class InscripcionController {

    private static final String ALUMNO_NO_EXISTE = "El ID proporcionado no corresponde con un alumno existente";
    private static final String CARRERA_NO_EXISTE = "El ID proporcionado no corresponde con una carrera existente";
    private static final String CURSO_NO_EXISTE = "El ID proporcionado no corresponde a un Curso existente";

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
        Alumno alumno = obtenerAlumnoSiExiste(LU);
        if (alumno == null) return;

        Carrera carrera = obtenerCarreraSiExiste(idCarrera);
        if (carrera == null) return;

        this.inscripcionManager.inscribirAlumnoACarrera(alumno, carrera);
    }

    public void inscribirAlumnoACurso(int LU, int idCurso) {
        Alumno alumno = obtenerAlumnoSiExiste(LU);
        if (alumno == null) return;

        Curso curso = obtenerCursoSiExiste(idCurso);
        if (curso == null) return;

        this.inscripcionManager.inscribirAlumnoACurso(alumno, curso);
    }

    private Alumno obtenerAlumnoSiExiste(int LU) {
        Alumno alumno = AlumnoController.getInstance().buscarAlumno(LU);
        if (alumno == null) {
            System.out.println(ALUMNO_NO_EXISTE);
        }
        return alumno;
    }

    private Carrera obtenerCarreraSiExiste(int idCarrera) {
        Carrera carrera = CarreraController.getInstance().buscarCarrera(idCarrera);
        if (carrera == null) {
            System.out.println(CARRERA_NO_EXISTE);
        }
        return carrera;
    }

    private Curso obtenerCursoSiExiste(int idCurso) {
        Curso curso = CursoController.getInstance().buscarCurso(idCurso);
        if (curso == null) {
            System.out.println(CURSO_NO_EXISTE);
        }
        return curso;
    }
}

