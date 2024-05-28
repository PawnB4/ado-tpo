package classes;

import enums.Turno;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Set;

public class ProfesorManager {
    private HashMap<Integer, Profesor> profesores;

    public ProfesorManager() {
        this.profesores = new HashMap<>();
    }

    public void crearProfesor(String nombre, String apellido) {
        Profesor nuevoProfesor = new Profesor(nombre, apellido);
        profesores.put(nuevoProfesor.getIdProfesor(), nuevoProfesor);
    }

    public Profesor buscarProfesor(int idProfesor) {
        return profesores.get(idProfesor);
    }
}

