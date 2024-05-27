import classes.*;
import controllers.*;
import enums.Turno;

import java.time.DayOfWeek;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // ########### Inicialización de data #################


        // Creacion de controllers
//        MercadoPago mercadoPago = new MercadoPago();
//        GeneradorReportes generadorReportes = new GeneradorReportes();
//        PagosController pagosController = new PagosController(mercadoPago);
//        ReportesController reportesController = new ReportesController(generadorReportes);

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

//        CursoController.getInstance().buscarCursosPorNombre("calc");
//        CursoController.getInstance().buscarCursosPorTurno("monday","noche");

        // Disponibilidad de profesor
        ProfesorController.getInstance().agregarDisponibilidad(1,"monday","noche");
        ProfesorController.getInstance().agregarDisponibilidad(1,"monday","manana");
        ProfesorController.getInstance().agregarDisponibilidad(1,"tuesday","tarde");


        // Asignar profesores a curso
        CursoController.getInstance().agregarProfesorACurso(1, 1);
        CursoController.getInstance().agregarProfesorACurso(1, 2);
        CursoController.getInstance().agregarProfesorACurso(2, 3);
        CursoController.getInstance().agregarProfesorACurso(2, 4);

        //
//
//        // ########### Funcionalidades #################
//
//        // Inscribir alumno a carrera
////        carreraManager.inscribirAlumnoACarrera(alumnoFranco, ingInformatica);
//
//        // Visualizar todos los cursos de una materia particular
//        System.out.println("##### Visualizar todos los cursos de una materia particular #####");
//        System.out.println(cursoManager.mostrarCursosPorMateria(calculo1));
//        System.out.println();
//
//
//        // Inscribir alumno a curso
//        System.out.println("##### Inscribir alumno a curso #####");
//        inscripcionManager.inscribirAlumnoACurso(alumnoFranco, calculo1_noche_lunes); // Success
//        System.out.println();
//
//        // Inscribir alumno a cusro sin tener correlativas aprobadas
//        System.out.println("##### Inscribir alumno a cusro sin tener correlativas aprobadas #####");
//        inscripcionManager.inscribirAlumnoACurso(alumnoFranco, calculo2_tarde_martes); // Error
//        System.out.println();
//
//        // Inscribir alumno a curso no correspondiente a la carrera
//        System.out.println("##### Inscribir alumno a curso no correspondiente a la carrera #####");
//        inscripcionManager.inscribirAlumnoACurso(alumnoFranco, historia_noche_jueves); // Error
//        System.out.println();
//
//        // Inscribir alumno a un curso con una materia que supere el maximo de horas estipuladas por cuatrimestre
//        System.out.println("##### Inscribir alumno a un curso con una materia que supere el maximo de horas estipuladas por cuatrimestre #####");
//        inscripcionManager.inscribirAlumnoACurso(alumnoFranco, dummy_muchas_horas); // Error
//        System.out.println();
//
//        // Realizar "Pago" exitoso
//        System.out.println("##### Realizar \"Pago\" exitoso #####");
//        alumnoFranco.aumentarSaldo(60000);
//        pagosController.pagarCuotasCuatrimestre(alumnoFranco);
//        System.out.println();
//
//        // Realizacion del "Pago" nuevamente, ahora sin saldo suficiente
//        System.out.println("##### Realizar \"Pago\" sin exito #####");
//        pagosController.pagarCuotasCuatrimestre(alumnoFranco);
//        System.out.println();
//
//        // Visualizar los cursos a los cuales un profesor se encuentra asignado
//        System.out.println("##### Visualizar los cursos a los cuales un profesor se encuentra asignado #####");
//        System.out.println(profesorIgnacio.obtenerCursos());
//        System.out.println();
//
//        // Generar "Reporte PDF" de los cursos asignados
//        System.out.println("##### Generar \"Reporte PDF\" de los cursos asignados #####");
//        System.out.println();
//        reportesController.generarReportePDFCursosPorProfesor(profesorIgnacio);

    }
}