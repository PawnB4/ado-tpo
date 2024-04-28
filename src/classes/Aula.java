package classes;

public class Aula {
    private String idAula;
    private int capacidadMaxima;

    public Aula(String idAula, int capacidadMaxima) {
        this.idAula = idAula;
        this.capacidadMaxima = capacidadMaxima;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "idAula='" + idAula + '\'' +
                ", capacidadMaxima=" + capacidadMaxima +
                '}';
    }
}
