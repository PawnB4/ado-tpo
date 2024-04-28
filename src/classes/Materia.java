package classes;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Materia {
    private static int contador = 1;
    private int idMateria;
    private String nombre;
    private int cantidadHoras;
    private ArrayList<Materia> correlativasPrevias;
    private ArrayList<Materia> correlativasPosteriores;

    public Materia(String nombre, int cantidadHoras) {
        this.idMateria = Materia.contador;
        ++Materia.contador;
        this.nombre = nombre;
        this.cantidadHoras = cantidadHoras;
        this.correlativasPrevias = new ArrayList<Materia>();
        this.correlativasPosteriores = new ArrayList<Materia>();
    }

    public void agregarMateriaCorrelativaPrevia(Materia materia) {
        this.correlativasPrevias.add(materia);
    }

    public void agregarMateriaCorrelativaPosterior(Materia materia) {
        this.correlativasPosteriores.add(materia);
    }

    public int obtenerId() {
        return idMateria;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public ArrayList<Materia> obtenerCorrelativasPrevias() {
        return correlativasPrevias;
    }

    public ArrayList<Materia> obtenerCorrelativasPosteriores() {
        return correlativasPosteriores;
    }

    public int obtenerCantidadDeHoras(){
        return cantidadHoras;
    }

    @Override
    public String toString() {
        String correlativasPreviasStr = correlativasPrevias.stream()
                .map(m -> m.idMateria + " - " + m.nombre)
                .collect(Collectors.joining(", "));

        String correlativasPosterioresStr = correlativasPosteriores.stream()
                .map(m -> m.idMateria + " - " + m.nombre)
                .collect(Collectors.joining(", "));

        return "Materia{" +
                "idMateria=" + idMateria +
                ", nombre='" + nombre + '\'' +
                ", cantidadHoras=" + cantidadHoras +
                ", correlativasPrevias=[" + correlativasPreviasStr + "]" +
                ", correlativasPosteriores=[" + correlativasPosterioresStr + "]" +
                '}';
    }
}
