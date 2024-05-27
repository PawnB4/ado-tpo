package controllers;

import classes.*;

public class CarreraController {

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

    public void agregarMateriaACarrera(int idCarrera, int idMateria) {
        Carrera carrera = this.carreraManager.buscarCarrera(idCarrera);
        if (carrera == null) {
            System.out.println("El ID proporcionado no corresponde con una carrera existente");
            return;
        }
        Materia materia = MateriaController.getInstance().buscarMateria(idMateria);
        if (materia == null) {
            System.out.println("El ID proporcionado no corresponde con una materia existente");
            return;
        }
        this.carreraManager.agregarMateriaACarrera(carrera, materia);
    }

    public void eliminarMateriaACarrera(int idCarrera, int idMateria) {
        Carrera carrera = this.carreraManager.buscarCarrera(idCarrera);
        if (carrera == null) {
            System.out.println("El ID proporcionado no corresponde con una carrera existente");
            return;
        }
        Materia materia = MateriaController.getInstance().buscarMateria(idMateria);
        if (materia == null) {
            System.out.println("El ID proporcionado no corresponde con una materia existente");
            return;
        }
        this.carreraManager.eliminarMateriaDeCarrera(carrera, materia);
    }

    public Carrera buscarCarrera(int idCarrera) {
        return this.carreraManager.buscarCarrera(idCarrera);
    }

    public void mostrarTodasLasCarreras() {
        this.carreraManager.mostrarTodasLasCarreraas();
    }


}
