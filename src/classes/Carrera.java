package classes;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Carrera {

    private static int contador;
    private int idCarrera;
    private String nombreCarrera;
    private int horasMaximasPorCuatrimestre;

    private ArrayList<Materia> materias;

    public Carrera(String nombreCarrera, int horasMaximasPorCuatrimestre) {
        ++Carrera.contador;
        this.idCarrera = Carrera.contador;
        this.nombreCarrera = nombreCarrera;
        this.horasMaximasPorCuatrimestre = horasMaximasPorCuatrimestre;
        this.materias = new ArrayList<Materia>();
    }

    public ArrayList<Materia> obtenerMaterias() {
        return materias;
    }

    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    public void eliminarMateria(Materia materia) {
        materias.remove(materia);
    }

    public int obtenerMaximoHoras() {
        return horasMaximasPorCuatrimestre;
    }

    public String obtenerNombre() {
        return this.nombreCarrera;
    }

    public int obtenerIdCarrera() {
        return this.idCarrera;
    }

    @Override
    public String toString() {
        String materiasStr = materias.stream()
                .map(c -> c.obtenerNombre() + " ")
                .collect(Collectors.joining(", "));
        return "Carrera{" +
                "idCarrera=" + idCarrera +
                ", nombreCarrera='" + nombreCarrera + '\'' +
                ", horasMaximasPorCuatrimestre=" + horasMaximasPorCuatrimestre +
                ", materias=[" + materiasStr + "]" +
                '}';
    }
}
