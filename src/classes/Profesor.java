package classes;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Profesor {
    private static int contador = 1;
    private int idProfesor;
    private String nombre;
    private String apellido;
    private ArrayList<Curso> cursos;

    public Profesor(String nombre, String apellido) {
        this.idProfesor = Profesor.contador;
        ++Profesor.contador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cursos = new ArrayList<Curso>();
    }

    public void agregarCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public void eliminarCurso(Curso curso) {
        this.cursos.remove(curso);
    }

    public ArrayList<Curso> obtenerCursos() {
        return this.cursos;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        String cursosStr = cursos.stream()
                .map(c -> c.obtenerMateria().obtenerNombre() + " - " + c.obtenerHorario())
                .collect(Collectors.joining(", "));

        return "Profesor{" +
                "idProfesor=" + idProfesor +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cursos=[" + cursosStr + "]" +
                '}';
    }
}
