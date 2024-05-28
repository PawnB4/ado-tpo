package classes;

import enums.Turno;

import java.time.DayOfWeek;
import java.util.*;
import java.util.stream.Collectors;

public class Profesor {
    private static int contador = 1;
    private int idProfesor;
    private String nombre;
    private String apellido;
    private ArrayList<Curso> cursos;
    private EnumMap<DayOfWeek, Set<Turno>> disponibilidad;

    public Profesor(String nombre, String apellido) {
        this.idProfesor = Profesor.contador;
        ++Profesor.contador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cursos = new ArrayList<Curso>();
        this.disponibilidad = new EnumMap<>(DayOfWeek.class);
    }

    public void agregarDisponibilidad(DayOfWeek dia, Turno turno) {
        this.disponibilidad.computeIfAbsent(dia, k -> EnumSet.noneOf(Turno.class)).add(turno);
    }

    public void quitarDisponibilidad(DayOfWeek dia, Turno turno) {
        Set<Turno> turnos = disponibilidad.get(dia);
        if (turnos != null) {
            turnos.remove(turno);
            if (turnos.isEmpty()) {
                disponibilidad.remove(dia);
            }
        }
    }

    public long calcularCantidadDeHorasAsignadasMensuales() {
        long cantidadHoras = 0;
        for (Curso curso : cursos) {
            cantidadHoras += curso.obtenerMateria().obtenerCantidadDeHoras();
        }
        return cantidadHoras;
    }

    public Set<Turno> obtenerDisponibilidad(DayOfWeek dia) {
        return disponibilidad.getOrDefault(dia, EnumSet.noneOf(Turno.class));
    }

    public void mostrarDisponibilidad() {
        for (DayOfWeek dia : DayOfWeek.values()) {
            Set<Turno> turnos = disponibilidad.get(dia);
            if (turnos != null) {
                System.out.println("Día: " + dia + ", Turnos: " + turnos);
            }
        }
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
