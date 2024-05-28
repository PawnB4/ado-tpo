package controllers;

import classes.Materia;
import classes.MateriaManager;

import java.util.ArrayList;

public class MateriaController {

    private static final String MATERIA_NO_EXISTE = "El ID proporcionado no corresponde con una materia existente";

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

    public Materia buscarMateria(int idMateria) {
        return materiaManager.buscarMateria(idMateria);
    }

    public void mostrarTodasLasMaterias() {
        this.materiaManager.mostrarTodasLasMaterias();
    }

    public void agregarMateriaCorrelativaPrevia(int idMateria, int idMateriaCorrelativaPrevia) {
        Materia materia = obtenerMateriaSiExiste(idMateria);
        if (materia == null) return;

        Materia materiaCorrelativaPrevia = obtenerMateriaSiExiste(idMateriaCorrelativaPrevia);
        if (materiaCorrelativaPrevia == null) return;

        materia.agregarMateriaCorrelativaPrevia(materiaCorrelativaPrevia);
    }

    public void agregarMateriaCorrelativaPosterior(int idMateria, int idMateriaCorrelativaPosterior) {
        Materia materia = obtenerMateriaSiExiste(idMateria);

        if (materia == null) return;

        Materia materiaCorrelativaPosterior = obtenerMateriaSiExiste(idMateriaCorrelativaPosterior);
        if (materiaCorrelativaPosterior == null) return;

        materia.agregarMateriaCorrelativaPosterior(materiaCorrelativaPosterior);
    }

    private Materia obtenerMateriaSiExiste(int idMateria) {
        Materia materia = this.buscarMateria(idMateria);
        if (materia == null) {
            System.out.println(MATERIA_NO_EXISTE);
        }
        return materia;
    }
}

