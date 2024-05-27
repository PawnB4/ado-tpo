package controllers;

import classes.Aula;
import classes.AulaManager;

public class AulaController {

    private static AulaController instance;
    private AulaManager aulaManager;

    private AulaController() {
        this.aulaManager = new AulaManager();
    }

    public static AulaController getInstance() {
        if (instance == null) {
            instance = new AulaController();
        }
        return instance;
    }

    public void crearAula(String idAula, int capacidadMaxima) {
        this.aulaManager.crearAula(idAula, capacidadMaxima);
    }

    public Aula buscarAula(String idAula) {
        return aulaManager.buscarAula(idAula);
    }

}
