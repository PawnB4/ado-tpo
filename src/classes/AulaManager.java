package classes;

import java.util.HashMap;

public class AulaManager {

    private HashMap<String, Aula> aulas;

    public AulaManager() {
        this.aulas = new HashMap<>();
    }

    public void crearAula(String idAula, int capacidadMaxima) {
        Aula aula = new Aula(idAula, capacidadMaxima);
        aulas.put(idAula, aula);
    }

    public Aula buscarAula(String idAula) {
        return aulas.get(idAula);
    }
}
