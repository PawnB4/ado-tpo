package classes;

import enums.Turno;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CursoManager {
    private HashMap<Integer, Curso> cursos;

    public CursoManager() {
        this.cursos = new HashMap<Integer, Curso>();
    }

    public void crearCurso(Aula aula, Materia materia, double precio, DayOfWeek dia, Turno turno) {
        Curso nuevoCurso = new Curso(aula, materia, precio, dia, turno);
        this.cursos.put(nuevoCurso.obtenerId(), nuevoCurso);
    }

    public Curso buscarCurso(int idCurso) {
        return this.cursos.get(idCurso);
    }

    public void buscarCursosPorNombre(String busqueda) {
        ArrayList<Curso> cursosFiltrados = new ArrayList<>();
        for (Curso curso : cursos.values()) {
            if (curso.obtenerMateria().obtenerNombre().toLowerCase().contains(busqueda.toLowerCase())) {
                cursosFiltrados.add(curso);
            }
        }
        System.out.println("RESULTADOS DE BUSQUEDA PARA: " + busqueda);
        System.out.println(cursosFiltrados);
    }

    public HashMap<Integer, Integer> obtenerInscriptosParaCadaCurso() {
        HashMap<Integer, Integer> inscriptosPorCurso = new HashMap<Integer, Integer>();
        for (Map.Entry<Integer, Curso> entry : cursos.entrySet()) {
            int idCurso = entry.getKey();
            int cantidadAlumnos = entry.getValue().obtenerCantidadAlumnosInscriptos();
            inscriptosPorCurso.put(idCurso, cantidadAlumnos);
        }
        return inscriptosPorCurso;
    }

    public void buscarCursosPorTurno(DayOfWeek dia, Turno turno) {
        ArrayList<Curso> cursosFiltrados = new ArrayList<>();
        for (Curso curso : cursos.values()) {
            if (curso.obtenerDia() == dia && curso.obtenerTurno() == turno) {
                cursosFiltrados.add(curso);
            }
        }
        System.out.println("RESULTADOS DE BUSQUEDA PARA: " + dia + " - " + turno);
        System.out.println(cursosFiltrados);
    }

    public void agregarProfesorACurso(Profesor profesor, Curso curso) {
        DayOfWeek dia = curso.obtenerDia();
        Turno turno = curso.obtenerTurno();
        // Validar si el profesor está disponible en el día y turno del curso
        if (profesor.obtenerDisponibilidad(dia).contains(turno)) {
            if (!curso.obtenerProfesores().contains(profesor)) {
                curso.agregarProfesor(profesor);
                profesor.agregarCurso(curso);
                profesor.quitarDisponibilidad(dia, turno);
            }
        } else {
            System.out.println("No se agregó el profesor al curso: El profesor no está disponible en " + dia + " " + turno);
        }
    }

    public void eliminarProfesorDeCurso(Profesor profesor, Curso curso) {
        DayOfWeek dia = curso.obtenerDia();
        Turno turno = curso.obtenerTurno();
        if (curso.obtenerProfesores().contains(profesor)) {
            curso.eliminarProfesor(profesor);
            profesor.eliminarCurso(curso);
            profesor.agregarDisponibilidad(dia, turno);
        }
    }


    public void mostrarTodosLosCursos() {
        System.out.println(cursos);
    }

    public void mostrarCursosPorMateria(Materia materia) {
        ArrayList<Curso> cursosFiltrados = new ArrayList<Curso>();
        for (Map.Entry<Integer, Curso> entry : cursos.entrySet()) {
            if (entry.getValue().obtenerMateria().obtenerId() == materia.obtenerId()) {
                cursosFiltrados.add(entry.getValue());
            }
        }
        System.out.println(cursosFiltrados);
    }

}
