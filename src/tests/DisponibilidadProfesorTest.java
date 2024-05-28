package tests;

import controllers.CursoController;
import controllers.ProfesorController;
import data.DataInitializer;


public class DisponibilidadProfesorTest {
    public static void main(String[] args) {
        DataInitializer.inicializarData();

        // Asignar disponibilidad al profesor
        ProfesorController.getInstance().agregarDisponibilidad(1, "monday", "noche");
        ProfesorController.getInstance().agregarDisponibilidad(1, "monday", "manana");
        ProfesorController.getInstance().agregarDisponibilidad(1, "tuesday", "tarde");

        System.out.println();
        System.out.println("##### Disponibilidad de profesor antes de asignarlo a cursos #####");
        ProfesorController.getInstance().mostrarDisponibilidad(1);

        // Asignar profesor a curso que concuerde con su disponibilidad
        CursoController.getInstance().agregarProfesorACurso(1, 1); // Success
        CursoController.getInstance().agregarProfesorACurso(1, 2); // Success

        System.out.println();
        System.out.println("##### Disponibilidad de luego de asignarlo a cursos #####");
        ProfesorController.getInstance().mostrarDisponibilidad(1); // Se consume la disponibilidad al asignarlo a un curso
        System.out.println();

        // Asignar profesor a curso que NO concuerde con su disponibilidad
        System.out.println("##### Asignar a curso que no corresponda con su disponibilidad #####");
        CursoController.getInstance().agregarProfesorACurso(1, 3); // Error
        CursoController.getInstance().agregarProfesorACurso(1, 4); // Error

        System.out.println();
        // Ver todos los cursos asignados
        System.out.println("##### Visualizar todos los cursos que se encuentra asignado #####");
        ProfesorController.getInstance().obtenerCursosProfesor(1);

        // Cumple con requerimiento de cronogramas de cursos en funcion a la disponibilidad del docente
    }
}
