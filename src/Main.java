import classes.*;
import tests.InscripcionesTest;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // ########### Inicialización de data #################

        // Creacion de curso handler y carrera handler
        CursosManager cursosManager = new CursosManager(LocalDate.of(2024, 5, 20));
        CarrerasManager carrerasManager = new CarrerasManager();

        // Creacion de controllers
        MercadoPago mercadoPago = new MercadoPago();
        GeneradorReportes generadorReportes = new GeneradorReportes();
        PagosController pagosController = new PagosController(mercadoPago);
        ReportesController reportesController = new ReportesController(generadorReportes);

        // Creacion de materias
        Materia calculo1 = new Materia("Calculo I", 68);
        Materia calculo2 = new Materia("Calculo II", 72);
        Materia historia = new Materia("Historia", 62);
        Materia dummy = new Materia("Dummy", 5800);

        // Seteo de correlativas y posteriores
        calculo1.agregarMateriaCorrelativaPosterior(calculo2);
        calculo2.agregarMateriaCorrelativaPrevia(calculo1);

        // Creacion de carrera
        Carrera ingInformatica = carrerasManager.crearCarrera("Ingenieria Informatica", 350);
        carrerasManager.agregarMateriaACarrera(ingInformatica, calculo1);
        carrerasManager.agregarMateriaACarrera(ingInformatica, calculo2);
        carrerasManager.agregarMateriaACarrera(ingInformatica, dummy);

        // Creacion de Profesores
        Profesor profesorIgnacio = new Profesor("Ignacio", "Martinez");
        Profesor profesorLaura = new Profesor("Laura", "Gonzalez");

        // Creacion de Alumnos
        Alumno alumnoFranco = new Alumno("Franco", "Pascual", 234965);
        Alumno alumnoSofia = new Alumno("Sofia", "Alvarez", 435873);

        // Creacion de Aulas
        Aula i405 = new Aula("I405", 60);
        Aula l812 = new Aula("l812", 50);

        // Creacion de Horarios
        Horario noche_lunes = new Horario(DayOfWeek.MONDAY, LocalTime.of(18, 30), LocalTime.of(22, 0));
        Horario noche_jueves = new Horario(DayOfWeek.THURSDAY, LocalTime.of(18, 30), LocalTime.of(22, 0));
        Horario tarde_martes = new Horario(DayOfWeek.TUESDAY, LocalTime.of(13, 30), LocalTime.of(18, 0));

        // Creacion de Cursos
        Curso calculo1_noche_lunes = cursosManager.crearCurso(i405, calculo1, noche_lunes, 50000);
        Curso calculo1_tarde_martes = cursosManager.crearCurso(i405, calculo1, tarde_martes, 35000);
        Curso calculo2_tarde_martes = cursosManager.crearCurso(l812, calculo2, tarde_martes, 25000);
        Curso historia_noche_jueves = cursosManager.crearCurso(i405, historia, noche_jueves, 42000);
        Curso dummy_muchas_horas = cursosManager.crearCurso(i405, dummy, noche_jueves, 42000);

        cursosManager.agregarProfesorACurso(profesorIgnacio, calculo1_noche_lunes);
        cursosManager.agregarProfesorACurso(profesorIgnacio, calculo1_tarde_martes);
        cursosManager.agregarProfesorACurso(profesorLaura, calculo2_tarde_martes);
        cursosManager.agregarProfesorACurso(profesorIgnacio, historia_noche_jueves);

        // ########### Funcionalidades #################

        // Inscribir alumno a carrera
        carrerasManager.inscribirAlumnoACarrera(alumnoFranco, ingInformatica);

        // Visualizar todos los cursos de una materia particular
        System.out.println("##### Visualizar todos los cursos de una materia particular #####");
        System.out.println(cursosManager.mostrarCursosPorMateria(calculo1));
        System.out.println();


        // Inscribir alumno a curso
        System.out.println("##### Inscribir alumno a curso #####");
        cursosManager.inscribirAlumnoACurso(alumnoFranco, calculo1_noche_lunes); // Success
        System.out.println();

        // Inscribir alumno a cusro sin tener correlativas aprobadas
        System.out.println("##### Inscribir alumno a cusro sin tener correlativas aprobadas #####");
        cursosManager.inscribirAlumnoACurso(alumnoFranco, calculo2_tarde_martes); // Error
        System.out.println();

        // Inscribir alumno a curso no correspondiente a la carrera
        System.out.println("##### Inscribir alumno a curso no correspondiente a la carrera #####");
        cursosManager.inscribirAlumnoACurso(alumnoFranco, historia_noche_jueves); // Error
        System.out.println();

        // Inscribir alumno a un curso con una materia que supere el maximo de horas estipuladas por cuatrimestre
        System.out.println("##### Inscribir alumno a un curso con una materia que supere el maximo de horas estipuladas por cuatrimestre #####");
        cursosManager.inscribirAlumnoACurso(alumnoFranco, dummy_muchas_horas); // Error
        System.out.println();

        // Realizar "Pago" exitoso
        System.out.println("##### Realizar \"Pago\" exitoso #####");
        alumnoFranco.aumentarSaldo(60000);
        pagosController.pagarCuotasCuatrimestre(alumnoFranco);
        System.out.println();

        // Realizacion del "Pago" nuevamente, ahora sin saldo suficiente
        System.out.println("##### Realizar \"Pago\" sin exito #####");
        pagosController.pagarCuotasCuatrimestre(alumnoFranco);
        System.out.println();

        // Visualizar los cursos a los cuales un profesor se encuentra asignado
        System.out.println("##### Visualizar los cursos a los cuales un profesor se encuentra asignado #####");
        System.out.println(profesorIgnacio.obtenerCursos());
        System.out.println();

        // Generar "Reporte PDF" de los cursos asignados
        System.out.println("##### Generar \"Reporte PDF\" de los cursos asignados #####");
        System.out.println();
        reportesController.generarReportePDFCursosPorProfesor(profesorIgnacio);

    }
}