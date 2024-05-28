package tests;

import controllers.AlumnoController;
import controllers.CursoController;
import controllers.InscripcionController;
import data.DataInitializer;

public class InscripcionesTest {
    public static void main(String[] args) {
        DataInitializer.inicializarData();

        // Inscribir alumno a curso
        System.out.println("##### Inscribir alumno a curso #####");
        InscripcionController.getInstance().inscribirAlumnoACurso(123456, 1);// Success
        System.out.println();

        // Inscribir alumno a cusro sin tener correlativas aprobadas
        System.out.println("##### Inscribir alumno a cusro sin tener correlativas aprobadas #####");
        InscripcionController.getInstance().inscribirAlumnoACurso(123456, 3); // Error
        System.out.println();

        // Inscribir alumno a curso no correspondiente a la carrera
        System.out.println("##### Inscribir alumno a curso no correspondiente a la carrera #####");
        InscripcionController.getInstance().inscribirAlumnoACurso(123456, 4); // Error
        System.out.println();

        // Inscribir alumno a un curso con una materia que supere el maximo de horas estipuladas por cuatrimestre
        System.out.println("##### Inscribir alumno a un curso con una materia que supere el maximo de horas estipuladas por cuatrimestre #####");
        InscripcionController.getInstance().inscribirAlumnoACurso(123456, 5); // Error
        System.out.println();

        // Inscribir alumno a curso con LU inexistente
        System.out.println("##### Inscribir alumno a curso #####");
        InscripcionController.getInstance().inscribirAlumnoACurso(1, 1);// Error
        System.out.println();

        // Obtener la cantidad de alumnos inscriptos en todos los cursos
        System.out.println("##### Obtener la cantidad de alumnos inscriptos en todos los cursos (Mapa id curso - cantidad de inscriptos) #####");
        var inscriptosPorCadaCurso = CursoController.getInstance().obtenerInscriptosParaCadaCurso();
        System.out.println(inscriptosPorCadaCurso);

    }
}
