package classes;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Alumno {

    private String nombre, apellido;
    private Carrera carrera;

    private ArrayList<Materia> materiasAprobadas;
    private ArrayList<Curso> cursosInscriptosCuatrimestre;
    private double balanceCuenta;
    private int LU;

    public Alumno(String nombre, String apellido, int LU) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = null;
        this.cursosInscriptosCuatrimestre = new ArrayList<Curso>();
        this.balanceCuenta = 0;
        this.LU = LU;
        this.materiasAprobadas = new ArrayList<Materia>();
    }

    public void inscribirACurso(Curso curso) {
        cursosInscriptosCuatrimestre.add(curso);
    }

    public void salirDeCurso(Curso curso) {
        cursosInscriptosCuatrimestre.remove(curso);
    }

    public void inscribirACarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public void salirDeCarrera() {
        this.carrera = null;
    }

    public Carrera obtenerCarrera() {
        return this.carrera;
    }

    public double obtenerBalance() {
        return this.balanceCuenta;
    }

    public void restarSaldo(double saldo) {
        this.balanceCuenta -= saldo;
    }

    public void aumentarSaldo(double saldo) {
        this.balanceCuenta += saldo;
    }

    public ArrayList<Materia> obtenerMateriasAprobadas() {
        return this.materiasAprobadas;
    }

    public ArrayList<Curso> obtenerCursosInscriptos() {
        return cursosInscriptosCuatrimestre;
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
        String cursosStr = cursosInscriptosCuatrimestre.stream()
                .map(c -> c.obtenerMateria().obtenerNombre() + " - " + c.obtenerHorario())
                .collect(Collectors.joining(", "));
        String checkCarrera = this.carrera == null ? "No está inscripto en una Carrera" : carrera.obtenerNombre();
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", carrera=" + checkCarrera
                +
                ", cursos inscriptos =[" + cursosStr + "]" +
                ", balanceCuenta=" + balanceCuenta +
                ", LU=" + LU +
                '}';
    }

}
