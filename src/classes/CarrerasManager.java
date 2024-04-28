package classes;

import java.util.ArrayList;

public class CarrerasManager {
    private ArrayList<Carrera> carreras;

    public CarrerasManager() {
        this.carreras = new ArrayList<Carrera>();
    }

    public Carrera crearCarrera(String nombreCarrera, int horasMaximasPorCuatrimestre) {
        Carrera nuavaCarrera = new Carrera(nombreCarrera, horasMaximasPorCuatrimestre);
        this.carreras.add(nuavaCarrera);
        return nuavaCarrera;
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

    public void inscribirAlumnoACarrera(Alumno alumno, Carrera carrera) {
        if (alumno.obtenerCarrera() == null) {
            alumno.inscribirACarrera(carrera);
        }
    }

    public void eliminarAlumnoDeCarrera(Alumno alumno) {
        if (alumno.obtenerCarrera() != null) {
            alumno.salirDeCarrera();
        }
    }

}
