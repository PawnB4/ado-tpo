package classes;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Curso {
    private static int contador;
    private int idCurso;
    private Aula aula;
    private Materia materia;
    private Horario horario;
    private ArrayList<Profesor> profesores;
    private ArrayList<Alumno> alumnos;
    private double precioCuota;


    public Curso(Aula aula, Materia materia, Horario horario, double precioCuota) {
        this.idCurso = Curso.contador;
        ++Curso.contador;
        this.aula = aula;
        this.materia = materia;
        this.horario = horario;
        this.profesores = new ArrayList<Profesor>();
        this.alumnos = new ArrayList<Alumno>();
        this.precioCuota = precioCuota;
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

    public Horario obtenerHorario() {
        return horario;
    }

    public int obtenerId() {
        return this.idCurso;
    }

    public double obtenerPrecioCuota() {
        return this.precioCuota;
    }

    @Override
    public String toString() {
        String profesoreStr = profesores.stream()
                .map(p -> p.getNombre() + " " + p.getApellido())
                .collect(Collectors.joining(", "));
        String alumnosStr = alumnos.stream()
                .map(a -> a.getNombre() + " " + a.getApellido())
                .collect(Collectors.joining(", "));

        return "Curso{" +
                "idCurso=" + idCurso +
                ", aula=" + aula +
                ", materia=" + materia.obtenerNombre() +
                ", horario=" + horario +
                ", profesores=[" + profesoreStr + "]" +
                ", alumnos=[" + alumnosStr + "]" +
                ", precio=" + precioCuota +
                '}'+"\n";
    }


}
