package controllers;

import classes.*;
import enums.Turno;

import java.time.DayOfWeek;
import java.util.HashMap;

public class CursoController {

    private static final String AULA_NO_EXISTE = "El ID de aula proporcionado no corresponde a un Aula existente";
    private static final String MATERIA_NO_EXISTE = "El ID de materia proporcionado no corresponde a una Materia existente";
    private static final String PROFESOR_NO_EXISTE = "El ID de profesor proporcionado no corresponde a un Profesor existente";
    private static final String CURSO_NO_EXISTE = "El ID de curso proporcionado no corresponde a un Curso existente";
    private static final String DIA_TURNO_INCORRECTOS = "Día o Turno ingresados incorrectos";

    private static CursoController instance;
    private CursoManager cursoManager;

    private CursoController() {
        this.cursoManager = new CursoManager();
    }

    public static CursoController getInstance() {
        if (instance == null) {
            instance = new CursoController();
        }
        return instance;
    }

    public void crearCurso(String idAula, int idMateria, double precio, String diaSemana, String turno) {
        Aula aula = obtenerAulaSiExiste(idAula);
        if (aula == null) return;

        Materia materia = obtenerMateriaSiExiste(idMateria);
        if (materia == null) return;

        DayOfWeek dia;
        Turno t;
        try {
            dia = DayOfWeek.valueOf(diaSemana.toUpperCase());
            t = Turno.valueOf(turno.toUpperCase());
        } catch (Exception error) {
            System.out.println(DIA_TURNO_INCORRECTOS);
            return;
        }
        this.cursoManager.crearCurso(aula, materia, precio, dia, t);
    }

    public void agregarProfesorACurso(int idProfesor, int idCurso) {
        Profesor profesor = obtenerProfesorSiExiste(idProfesor);
        if (profesor == null) return;

        Curso curso = obtenerCursoSiExiste(idCurso);
        if (curso == null) return;

        this.cursoManager.agregarProfesorACurso(profesor, curso);
    }

    public void eliminarProfesorDeCurso(int idProfesor, int idCurso) {
        Profesor profesor = obtenerProfesorSiExiste(idProfesor);
        if (profesor == null) return;

        Curso curso = obtenerCursoSiExiste(idCurso);
        if (curso == null) return;

        this.cursoManager.eliminarProfesorDeCurso(profesor, curso);
    }

    public void mostrarTodosLosCursos() {
        this.cursoManager.mostrarTodosLosCursos();
    }

    public void mostrarTodosLosCursosPorMateria(int idMateria) {
        Materia materia = obtenerMateriaSiExiste(idMateria);
        if (materia == null) return;

        this.cursoManager.mostrarCursosPorMateria(materia);
    }

    public void buscarCursosPorNombre(String busqueda) {
        this.cursoManager.buscarCursosPorNombre(busqueda);
    }

    public void buscarCursosPorTurno(String dia, String turno) {
        DayOfWeek d;
        Turno t;
        try {
            d = DayOfWeek.valueOf(dia.toUpperCase());
            t = Turno.valueOf(turno.toUpperCase());
        } catch (Exception error) {
            System.out.println(DIA_TURNO_INCORRECTOS);
            return;
        }
        this.cursoManager.buscarCursosPorTurno(d, t);
    }

    public int obtenerCantidadAlumnosInscriptos(int idCurso) {
        Curso curso = obtenerCursoSiExiste(idCurso);
        if (curso == null) return 0;
        return curso.obtenerCantidadAlumnosInscriptos();
    }

    public HashMap<Integer, Integer> obtenerInscriptosParaCadaCurso() {
        return this.cursoManager.obtenerInscriptosParaCadaCurso();
    }

    public Curso buscarCurso(int idCurso) {
        return this.cursoManager.buscarCurso(idCurso);
    }

    private Aula obtenerAulaSiExiste(String idAula) {
        Aula aula = AulaController.getInstance().buscarAula(idAula);
        if (aula == null) {
            System.out.println(AULA_NO_EXISTE);
        }
        return aula;
    }

    private Materia obtenerMateriaSiExiste(int idMateria) {
        Materia materia = MateriaController.getInstance().buscarMateria(idMateria);
        if (materia == null) {
            System.out.println(MATERIA_NO_EXISTE);
        }
        return materia;
    }

    private Profesor obtenerProfesorSiExiste(int idProfesor) {
        Profesor profesor = ProfesorController.getInstance().buscarProfesor(idProfesor);
        if (profesor == null) {
            System.out.println(PROFESOR_NO_EXISTE);
        }
        return profesor;
    }

    private Curso obtenerCursoSiExiste(int idCurso) {
        Curso curso = this.cursoManager.buscarCurso(idCurso);
        if (curso == null) {
            System.out.println(CURSO_NO_EXISTE);
        }
        return curso;
    }
}
