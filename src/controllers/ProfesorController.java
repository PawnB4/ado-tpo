package controllers;

import classes.AlumnoManager;
import classes.Profesor;
import classes.ProfesorManager;
import enums.Turno;

import java.time.DayOfWeek;

public class ProfesorController {

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
        Profesor profesor = buscarProfesor(idProfesor);
        if (profesor == null) {
            System.out.println("El ID proporcionado no corresponde con un profesor existente");
            return;
        }
        DayOfWeek dia;
        Turno turno;
        try {
            dia = DayOfWeek.valueOf(diaDisponible.toUpperCase());
            turno = Turno.valueOf(turnoDisponible.toUpperCase());
        } catch (Exception error) {
            System.out.println("Dia o Turno ingresados incorrectos");
            return;
        }
        this.profesorManager.agregarDisponibilidad(profesor, dia, turno);
    }

    public void quitarDisponibilidad(int idProfesor, String diaDisponible, String turnoDisponible) {
        Profesor profesor = buscarProfesor(idProfesor);
        if (profesor == null) {
            System.out.println("El ID proporcionado no corresponde con un profesor existente");
            return;
        }
        DayOfWeek dia;
        Turno turno;
        try {
            dia = DayOfWeek.valueOf(diaDisponible.toUpperCase());
            turno = Turno.valueOf(turnoDisponible.toUpperCase());
        } catch (Exception error) {
            System.out.println("Dia o Turno ingresados incorrectos");
            return;
        }
        this.profesorManager.quitarDisponibilidad(profesor, dia, turno);
    }

    public void mostrarDisponibilidad(int idProfesor) {
        Profesor profesor = buscarProfesor(idProfesor);
        if (profesor == null) {
            System.out.println("El ID proporcionado no corresponde con un profesor existente");
            return;
        }
        this.profesorManager.mostrarDisponibilidad(profesor);
    }

}
