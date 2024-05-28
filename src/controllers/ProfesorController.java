package controllers;

import classes.*;
import enums.Turno;
import interfaces.IGeneradorReportes;

import java.time.DayOfWeek;
import java.util.ArrayList;

public class ProfesorController {

    private static final String PROFESOR_NO_EXISTE = "El ID proporcionado no corresponde con un profesor existente";
    private static final String DIA_TURNO_INCORRECTO = "Día o Turno ingresados incorrectos";

    private static ProfesorController instance;
    private ProfesorManager profesorManager;

    private ProfesorController() {
        this.profesorManager = new ProfesorManager();
    }

    public static ProfesorController getInstance() {
        if (instance == null) {
            instance = new ProfesorController();
        }
        return instance;
    }

    public void crearProfesor(String nombre, String apellido) {
        this.profesorManager.crearProfesor(nombre, apellido);
    }

    public Profesor buscarProfesor(int idProfesor) {
        return this.profesorManager.buscarProfesor(idProfesor);
    }

    public void agregarDisponibilidad(int idProfesor, String diaDisponible, String turnoDisponible) {
        Profesor profesor = obtenerProfesorSiExiste(idProfesor);
        if (profesor == null) return;

        DayOfWeek dia = obtenerDia(diaDisponible);
        Turno turno = obtenerTurno(turnoDisponible);
        if (dia == null || turno == null) return;

        profesor.agregarDisponibilidad(dia, turno);
    }

    public void quitarDisponibilidad(int idProfesor, String diaDisponible, String turnoDisponible) {
        Profesor profesor = obtenerProfesorSiExiste(idProfesor);
        if (profesor == null) return;

        DayOfWeek dia = obtenerDia(diaDisponible);
        Turno turno = obtenerTurno(turnoDisponible);
        if (dia == null || turno == null) return;

        profesor.quitarDisponibilidad(dia, turno);
    }

    public long calcularCantidadDeHorasAsignadasMensuales(int idProfesor) {
        Profesor profesor = obtenerProfesorSiExiste(idProfesor);
        if (profesor == null) return 0;
        return profesor.calcularCantidadDeHorasAsignadasMensuales();
    }

    public void mostrarDisponibilidad(int idProfesor) {
        Profesor profesor = obtenerProfesorSiExiste(idProfesor);
        if (profesor == null) return;

        profesor.mostrarDisponibilidad();
    }

    public void generarReporte(String formatoSalida, int idProfesor) {
        Profesor profesor = obtenerProfesorSiExiste(idProfesor);
        if (profesor == null) return;
        ReporteController.getInstance().generarReporte(formatoSalida, profesor.obtenerCursos());
    }

    public void obtenerCursosProfesor(int idProfesor) {
        Profesor profesor = obtenerProfesorSiExiste(idProfesor);
        if (profesor == null) return;

        System.out.println(profesor.obtenerCursos());
    }

    private Profesor obtenerProfesorSiExiste(int idProfesor) {
        Profesor profesor = buscarProfesor(idProfesor);
        if (profesor == null) {
            System.out.println(PROFESOR_NO_EXISTE);
        }
        return profesor;
    }

    private DayOfWeek obtenerDia(String diaDisponible) {
        try {
            return DayOfWeek.valueOf(diaDisponible.toUpperCase());
        } catch (Exception error) {
            System.out.println(DIA_TURNO_INCORRECTO);
            return null;
        }
    }

    private Turno obtenerTurno(String turnoDisponible) {
        try {
            return Turno.valueOf(turnoDisponible.toUpperCase());
        } catch (Exception error) {
            System.out.println(DIA_TURNO_INCORRECTO);
            return null;
        }
    }


}


