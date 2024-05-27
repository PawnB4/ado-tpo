package controllers;

import classes.*;
import enums.Turno;

import java.time.DayOfWeek;

public class CursoController {

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
        Aula aula = AulaController.getInstance().buscarAula(idAula);
        if (aula == null) {
            System.out.println("El el ID de aula proporcionado no corresponde a un Aula existente");
            return;
        }
        Materia materia = MateriaController.getInstance().buscarMateria(idMateria);
        if (materia == null) {
            System.out.println("El el ID de materia proporcionado no corresponde a una Materia existente");
            return;
        }
        DayOfWeek dia;
        Turno t;
        try {
            dia = DayOfWeek.valueOf(diaSemana.toUpperCase());
            t = Turno.valueOf(turno.toUpperCase());
        } catch (Exception error) {
            System.out.println("Dia o Turno ingresados incorrectos");
            return;
        }
        this.cursoManager.crearCurso(aula, materia, precio, dia, t);
    }

    public void agregarProfesorACurso(int idProfesor, int idCurso) {
        Profesor profesor = ProfesorController.getInstance().buscarProfesor(idProfesor);
        if (profesor == null) {
            System.out.println("El el ID de profesor proporcionado no corresponde a un Profesor existente");
            return;
        }
        Curso curso = this.cursoManager.buscarCurso(idCurso);
        if (curso == null) {
            System.out.println("El el ID de curso proporcionado no corresponde a un Curso existente");
            return;
        }
        this.cursoManager.agregarProfesorACurso(profesor, curso);
    }

    public void eliminarProfesorDeCurso(int idProfesor, int idCurso) {
        Profesor profesor = ProfesorController.getInstance().buscarProfesor(idProfesor);
        if (profesor == null) {
            System.out.println("El el ID de profesor proporcionado no corresponde a un Profesor existente");
            return;
        }
        Curso curso = this.cursoManager.buscarCurso(idCurso);
        if (curso == null) {
            System.out.println("El el ID de curso proporcionado no corresponde a un Curso existente");
            return;
        }
        this.cursoManager.eliminarProfesorDeCurso(profesor, curso);
    }

    public void actualizarValorCuotaDeCuso(double nuevoValor, int idCurso) {
        Curso curso = this.cursoManager.buscarCurso(idCurso);
        if (curso == null) {
            System.out.println("El el ID de curso proporcionado no corresponde a un Curso existente");
            return;
        }
        this.cursoManager.actualizarValorCuotaDeCuso(nuevoValor, curso);
    }

    public void mostrarTodosLosCursos() {
        this.cursoManager.mostrarTodosLosCursos();
    }

    public void mostrarTodosLosCursosPorMateria(int idMateria) {
        Materia materia = MateriaController.getInstance().buscarMateria(idMateria);
        if (materia == null) {
            System.out.println("El ID proporcionado no corresponde con una materia existente");
            return;
        }
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
            System.out.println("Dia o Turno ingresados incorrectos");
            return;
        }
        this.cursoManager.buscarCursosPorTurno(d, t);
    }
}