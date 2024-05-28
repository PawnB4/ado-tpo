package controllers;

import classes.*;

public class CarreraController {

    private static final String CARRERA_NO_EXISTE = "El ID proporcionado no corresponde con una carrera existente";
    private static final String MATERIA_NO_EXISTE = "El ID proporcionado no corresponde con una materia existente";

    private static CarreraController instance;
    private CarreraManager carreraManager;

    private CarreraController() {
        this.carreraManager = new CarreraManager();
    }

    public static CarreraController getInstance() {
        if (instance == null) {
            instance = new CarreraController();
        }
        return instance;
    }

    public void crearCarrera(String nombreCarrera, int horasMaximasPorCuatrimestre) {
        this.carreraManager.crearCarrera(nombreCarrera, horasMaximasPorCuatrimestre);
    }

    public void mostrarTodasLasCarreras() {
        this.carreraManager.mostrarTodasLasCarreras();
    }

    public Carrera buscarCarrera(int idCarrera) {
        return this.carreraManager.buscarCarrera(idCarrera);
    }

    public void agregarMateriaACarrera(int idCarrera, int idMateria) {
        Carrera carrera = obtenerCarreraSiExiste(idCarrera);
        if (carrera == null) return;

        Materia materia = obtenerMateriaSiExiste(idMateria);
        if (materia == null) return;

        this.carreraManager.agregarMateriaACarrera(carrera, materia);
    }

    public void eliminarMateriaACarrera(int idCarrera, int idMateria) {
        Carrera carrera = obtenerCarreraSiExiste(idCarrera);
        if (carrera == null) return;

        Materia materia = obtenerMateriaSiExiste(idMateria);
        if (materia == null) return;

        this.carreraManager.eliminarMateriaDeCarrera(carrera, materia);
    }

    private Carrera obtenerCarreraSiExiste(int idCarrera) {
        Carrera carrera = buscarCarrera(idCarrera);
        if (carrera == null) {
            System.out.println(CARRERA_NO_EXISTE);
        }
        return carrera;
    }

    private Materia obtenerMateriaSiExiste(int idMateria) {
        Materia materia = MateriaController.getInstance().buscarMateria(idMateria);
        if (materia == null) {
            System.out.println(MATERIA_NO_EXISTE);
        }
        return materia;
    }
}
