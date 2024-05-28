package data;

import controllers.*;

public class DataInitializer {

    public static void inicializarData() {

        // ########### Inicialización de data #################

        // Creacion de carrera
        CarreraController.getInstance().crearCarrera("Ingenieria Informatica", 350);

        // Creacion de materias
        MateriaController.getInstance().crearMateria("Calculo I", 68);
        MateriaController.getInstance().crearMateria("Calculo II", 72);
        MateriaController.getInstance().crearMateria("Historia I", 68);
        MateriaController.getInstance().crearMateria("Dummy Muchas Horas", 5800);


        // Seteo de correlativas y posteriores
        MateriaController.getInstance().agregarMateriaCorrelativaPosterior(1, 2);
        MateriaController.getInstance().agregarMateriaCorrelativaPrevia(2, 1);

        // Agregar materias a carrera
        CarreraController.getInstance().agregarMateriaACarrera(1, 1);
        CarreraController.getInstance().agregarMateriaACarrera(1, 2);
        CarreraController.getInstance().agregarMateriaACarrera(1, 4);

        // Creacion de Profesores
        ProfesorController.getInstance().crearProfesor("Ignacio", "Martinez");
        ProfesorController.getInstance().crearProfesor("Laura", "Gonzalez");

        // Creacion de Alumnos
        AlumnoController.getInstance().crearAlumno("Franco", "Pascual", 123456);
        AlumnoController.getInstance().crearAlumno("Sofia", "Alvarez", 987654);

        // Creacion de Aulas
        AulaController.getInstance().crearAula("I405", 60);
        AulaController.getInstance().crearAula("L812", 50);

        // Creacion de Cursos
        CursoController.getInstance().crearCurso("I405", 1, 50000, "monday", "noche");
        CursoController.getInstance().crearCurso("I405", 1, 35000, "tuesday", "tarde");
        CursoController.getInstance().crearCurso("L812", 2, 25000, "tuesday", "tarde");
        CursoController.getInstance().crearCurso("L812", 3, 42000, "THURSDAY", "manana");
        CursoController.getInstance().crearCurso("I405", 4, 42000, "monday", "noche");

        // Seteo de fecha maxima de inscripcion
        InscripcionController.getInstance().setFechaMaximaDeInscripcion(2024, 6, 24);

        // Inscribir alumno a carrera
        InscripcionController.getInstance().inscribirAlumnoACarrera(123456, 1);
    }
}
