package controllers;

import classes.Materia;
import classes.MateriaManager;

import java.util.ArrayList;

public class MateriaController {

    private static MateriaController instance;
    private MateriaManager materiaManager;

    private MateriaController() {
        this.materiaManager = new MateriaManager();
    }

    public static MateriaController getInstance() {
        if (instance == null) {
            instance = new MateriaController();
        }
        return instance;
    }

    public void crearMateria(String nombre, int cantidadHoras) {
        this.materiaManager.crearMateria(nombre, cantidadHoras);
    }

    public void agregarMateriaCorrelativaPrevia(int idMateria, int idMateriaCorrelativaPrevia) {
        Materia materia = this.buscarMateria(idMateria);
        if (materia == null) {
            System.out.println("El ID proporcionado no corresponde con una materia existente");
            return;
        }
        Materia materiaCorrelativaPrevia = this.buscarMateria(idMateriaCorrelativaPrevia);
        if (materiaCorrelativaPrevia == null) {
            System.out.println("El ID proporcionado no corresponde con una materia existente");
            return;
        }
        this.materiaManager.agregarMateriaCorrelativaPrevia(materia, materiaCorrelativaPrevia);
    }

    public void agregarMateriaCorrelativaPosterior(int idMateria, int idMateriaCorrelativaPosterior) {
        Materia materia = this.buscarMateria(idMateria);
        if (materia == null) {
            System.out.println("El ID proporcionado no corresponde con una materia existente");
            return;
        }
        Materia materiaCorrelativaPosterior = this.buscarMateria(idMateriaCorrelativaPosterior);
        if (materiaCorrelativaPosterior == null) {
            System.out.println("El ID proporcionado no corresponde con una materia existente");
            return;
        }
        this.materiaManager.agregarMateriaCorrelativaPosterior(materia, materiaCorrelativaPosterior);
    }


    public Materia buscarMateria(int idMateria) {
        return materiaManager.buscarMateria(idMateria);
    }

    public void mostrarTodasLasMaterias() {
        this.materiaManager.mostrarTodasLasMaterias();
    }

}
