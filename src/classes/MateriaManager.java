package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MateriaManager {
    private HashMap<Integer, Materia> materias;

    public MateriaManager() {
        this.materias = new HashMap<Integer, Materia>();
    }

    public void crearMateria(String nombre, int cantidadHoras) {
        Materia materia = new Materia(nombre, cantidadHoras);
        materias.put(materia.obtenerId(), materia);
    }

    public Materia buscarMateria(int idMateria) {
        return materias.get(idMateria);
    }

    public void mostrarTodasLasMaterias() {
        for (Map.Entry<Integer, Materia> entry : materias.entrySet()) {
            int id = entry.getKey();
            String nombre = entry.getValue().obtenerNombre();
            System.out.println("ID: " + id + ", Nombre: " + nombre);
        }
    }

}