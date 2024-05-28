package tests;

import controllers.CursoController;
import controllers.ProfesorController;
import data.DataInitializer;

public class CursosProfesorTest {
    public static void main(String[] args) {
        DataInitializer.inicializarData();

        // Asignar disponibilidad y cursos
        ProfesorController.getInstance().agregarDisponibilidad(1, "monday", "noche");
        ProfesorController.getInstance().agregarDisponibilidad(1, "tuesday", "tarde");
        CursoController.getInstance().agregarProfesorACurso(1, 1);
        CursoController.getInstance().agregarProfesorACurso(1, 2);

        // Visualizar los cursos a los cuales un profesor se encuentra asignado
        System.out.println();
        System.out.println("##### Visualizar los cursos a los cuales un profesor se encuentra asignado #####");
        ProfesorController.getInstance().obtenerCursosProfesor(1);
        System.out.println();

        // Obtener la cantidad de horas asignadas
        System.out.println("##### Obtener la cantidad de horas asignadas en el cuatrimestre #####");
        var horas = ProfesorController.getInstance().calcularCantidadDeHorasAsignadasMensuales(1);
        System.out.println("Horas asignadas este cuatrimestre: " + horas);
        System.out.println();

        // Generar "Reporte PDF" de los cursos asignados
        System.out.println("##### Generar \"Reporte PDF\" de los cursos asignados #####");
        System.out.println();
        ProfesorController.getInstance().generarReporte("pdf", 1);
        System.out.println();


        // Generar "Reporte Excel" de los cursos asignados
        System.out.println("##### Generar \"Reporte PDF\" de los cursos asignados #####");
        System.out.println();
        ProfesorController.getInstance().generarReporte("excel", 1);
        System.out.println();


        // Generar Reporte con formato inexistente
        System.out.println("##### Generar Reporte con formato inexistente #####");
        System.out.println();
        ProfesorController.getInstance().generarReporte("csv", 1);
    }
}
