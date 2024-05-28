package classes;

import enums.Turno;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Curso {
    private static int contador;
    private int idCurso;
    private Aula aula;
    private Materia materia;
    private ArrayList<Profesor> profesores;
    private ArrayList<Alumno> alumnos;
    private double precioCuota;
    private DayOfWeek dia;
    private Turno turno;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Duration duracion;


    public Curso(Aula aula, Materia materia, double precioCuota, DayOfWeek dia, Turno turno) {
        ++Curso.contador;
        this.idCurso = Curso.contador;
        this.aula = aula;
        this.materia = materia;
        this.profesores = new ArrayList<Profesor>();
        this.alumnos = new ArrayList<Alumno>();
        this.precioCuota = precioCuota;
        this.dia = dia;
        this.turno = turno;
        calcularTurno(turno);
    }

    private void calcularTurno(Turno turno) {
        if (turno.equals(Turno.MANANA)) {
            this.horaInicio = LocalTime.of(7, 45);
            this.horaFin = LocalTime.of(11, 45);

        } else if (turno.equals(Turno.TARDE)) {
            this.horaInicio = LocalTime.of(14, 0);
            this.horaFin = LocalTime.of(18, 0);
        } else {
            this.horaInicio = LocalTime.of(18, 30);
            this.horaFin = LocalTime.of(22, 30);
        }
        this.duracion = Duration.between(horaInicio, horaFin);
    }

    public int obtenerCantidadAlumnosInscriptos() {
        return alumnos.size();
    }

    public ArrayList<Profesor> obtenerProfesores() {
        return profesores;
    }

    public ArrayList<Alumno> obtenerAlumnos() {
        return alumnos;
    }

    public void agregarProfesor(Profesor profesor) {
        this.profesores.add(profesor);
    }

    public void eliminarProfesor(Profesor profesor) {
        this.profesores.remove(profesor);
    }

    public void agregarAlumno(Alumno alumno) {
        this.alumnos.add(alumno);
    }

    public void eliminarAlumno(Alumno alumno) {
        this.alumnos.remove(alumno);
    }

    public Materia obtenerMateria() {
        return materia;
    }

    public Aula obtenerAula() {
        return this.aula;
    }

    public DayOfWeek obtenerDia() {
        return this.dia;
    }

    public Turno obtenerTurno() {
        return this.turno;
    }

    public long obtenerCantidadHoras() {
        return this.duracion.toHours();
    }

    public String obtenerHorario() {
        return dia + "-" + turno;
    }

    public int obtenerId() {
        return this.idCurso;
    }

    public double obtenerPrecioCuota() {
        return this.precioCuota;
    }

    public void setPrecioCuota(double nuevoValor) {
        this.precioCuota = nuevoValor;
    }


    @Override
    public String toString() {
        String profesoreStr = profesores.stream().map(p -> p.getNombre() + " " + p.getApellido()).collect(Collectors.joining(", "));
        String alumnosStr = alumnos.stream().map(a -> a.getNombre() + " " + a.getApellido()).collect(Collectors.joining(", "));

        return "Curso{" + "idCurso=" + idCurso + ", aula=" + aula + ", materia=" + materia.obtenerNombre() + ", horario=" + dia + "-" + turno + ", profesores=[" + profesoreStr + "]" + ", alumnos=[" + alumnosStr + "]" + ", precio=" + precioCuota + '}' + "\n";
    }


}
