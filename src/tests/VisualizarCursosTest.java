package tests;

import controllers.CursoController;
import data.DataInitializer;

public class VisualizarCursosTest {

    public static void main(String[] args) {
        DataInitializer.inicializarData();

        // Visualizar todos los cursos de una materia particular
        System.out.println("##### Visualizar todos los cursos de una materia particular #####");
        CursoController.getInstance().mostrarTodosLosCursosPorMateria(1);
        System.out.println();

        // Buscar curso por nombre
        System.out.println("##### Buscar cursos por nombre #####");
        CursoController.getInstance().buscarCursosPorNombre("calc");
        System.out.println();

        // Buscar curso por turno
        System.out.println("##### Buscar cursos por turno #####");
        CursoController.getInstance().buscarCursosPorTurno("monday", "noche");
        System.out.println();

        // Buscar por un id de materia que no existe
        System.out.println("##### Visualizar todos los cursos de una materia que no existe #####");
        CursoController.getInstance().mostrarTodosLosCursosPorMateria(13);
        System.out.println();

        // Buscar curso por nombre incorrecto
        System.out.println("##### Buscar cursos por nombre incorrecto #####");
        CursoController.getInstance().buscarCursosPorNombre("foo bar");
        System.out.println();

        // Buscar curso por turno incorrecto
        System.out.println("##### Buscar cursos por turno incorrecto #####");
        CursoController.getInstance().buscarCursosPorTurno("monday", "tardecita");
        System.out.println();


    }
}
