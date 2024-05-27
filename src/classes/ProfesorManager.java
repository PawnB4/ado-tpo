package classes;

import enums.Turno;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Set;

public class ProfesorManager {
    private HashMap<Integer, Profesor> profesores;

    public ProfesorManager() {
        this.profesores = new HashMap<Integer, Profesor>();
    }

    public void crearProfesor(String nombre, String apellido) {
        Profesor nuevoProfesor = new Profesor(nombre, apellido);
        profesores.put(nuevoProfesor.getIdProfesor(), nuevoProfesor);
    }

    public Profesor buscarProfesor(int idProfesor) {
        return profesores.get(idProfesor);
    }

    public void agregarDisponibilidad(Profesor profesor, DayOfWeek dia, Turno turno) {
        profesor.agregarDisponibilidad(dia, turno);
    }

    public void quitarDisponibilidad(Profesor profesor, DayOfWeek dia, Turno turno) {
        profesor.quitarDisponibilidad(dia, turno);
    }

    public Set<Turno> obtenerDisponibilidad(Profesor profesor, DayOfWeek dia) {
        return profesor.obtenerDisponibilidad(dia);
    }

    public void mostrarDisponibilidad(Profesor profesor) {
        profesor.mostrarDisponibilidad();
    }
}
