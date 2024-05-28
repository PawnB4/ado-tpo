package classes;

import java.util.HashMap;
import java.util.Map;

public class CarreraManager {
    private HashMap<Integer, Carrera> carreras;

    public CarreraManager() {
        this.carreras = new HashMap<Integer, Carrera>();
    }


    public void crearCarrera(String nombreCarrera, int horasMaximasPorCuatrimestre) {
        Carrera nuavaCarrera = new Carrera(nombreCarrera, horasMaximasPorCuatrimestre);
        this.carreras.put(nuavaCarrera.obtenerIdCarrera(), nuavaCarrera);
    }

    public void agregarMateriaACarrera(Carrera carrera, Materia materia) {
        if (!carrera.obtenerMaterias().contains(materia)) {
            for (Materia m : materia.obtenerCorrelativasPrevias()) {
                if (!carrera.obtenerMaterias().contains(m)) {
                    return;
                }
            }
            carrera.agregarMateria(materia);
        }
    }

    public void eliminarMateriaDeCarrera(Carrera carrera, Materia materia) {
        if (carrera.obtenerMaterias().contains(materia)) {
            carrera.eliminarMateria(materia);
        }
    }

    public void mostrarTodasLasCarreras() {
        for (Map.Entry<Integer, Carrera> entry : carreras.entrySet()) {
            int id = entry.getKey();
            String nombre = entry.getValue().obtenerNombre();
            System.out.println("ID: " + id + ", Nombre: " + nombre);
        }
    }

    public Carrera buscarCarrera(int idCarrera) {
        return carreras.get(idCarrera);
    }


}
