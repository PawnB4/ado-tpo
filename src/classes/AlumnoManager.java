package classes;

import java.util.HashMap;

public class AlumnoManager {
    private HashMap<Integer, Alumno> alumnos;

    public AlumnoManager() {
        this.alumnos = new HashMap<Integer, Alumno>();
    }

    public void crearAlumno(String nombre, String apellido, int LU) {
        Alumno nuevoAlumno = new Alumno(nombre, apellido, LU);
        alumnos.put(LU, nuevoAlumno);
    }

    public Alumno buscarAlumno(int LU) {
        return alumnos.get(LU);
    }


}
