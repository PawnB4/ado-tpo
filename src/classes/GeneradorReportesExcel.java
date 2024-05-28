package classes;

import interfaces.IGeneradorReportes;

import java.util.ArrayList;

public class GeneradorReportesExcel implements IGeneradorReportes {

    public GeneradorReportesExcel(){};
    @Override
    public void generarReporte(ArrayList<Curso> cursos) {
        System.out.println("---- REPORTE EXCEL ----");
        for (Curso c : cursos) {
            System.out.println("Nombre: " + c.obtenerMateria().obtenerNombre());
            System.out.println("Horario: " + c.obtenerHorario());
            System.out.println("Aula: " + c.obtenerAula());
            System.out.println("Cantidad de alumnos inscriptos: " + c.obtenerCantidadAlumnosInscriptos());
            System.out.println("******************");
        }
    }
}
