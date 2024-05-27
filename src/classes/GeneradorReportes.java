package classes;

import interfaces.IGeneradorReportes;

import java.util.ArrayList;

public class GeneradorReportes implements IGeneradorReportes {

    @Override
    public void generarPDF(ArrayList<Curso> cursos) {
        System.out.println("---- REPORTE PDF ----");
        for (Curso c : cursos) {
            System.out.println("Nombre: " + c.obtenerMateria().obtenerNombre());
            System.out.println("Horario: " + c.obtenerHorario());
            System.out.println("Aula: " + c.obtenerAula());
            System.out.println("******************");
        }
    }
}
