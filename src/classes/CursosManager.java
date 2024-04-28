package classes;

import exceptions.InscripcionException;

import java.time.LocalDate;
import java.util.ArrayList;

public class CursosManager {
    private ArrayList<Curso> cursos;
    private LocalDate fechaMaximaInscripcion;

    public CursosManager(LocalDate fechaMaximaInscripcion) {
        this.cursos = new ArrayList<Curso>();
        this.fechaMaximaInscripcion = fechaMaximaInscripcion;
    }

    public Curso crearCurso(Aula aula, Materia materia, Horario horario, double precio) {
        Curso nuevoCurso = new Curso(aula, materia, horario, precio);
        this.cursos.add(nuevoCurso);
        return nuevoCurso;
    }

    public void agregarProfesorACurso(Profesor profesor, Curso curso) {
        if (!curso.obtenerProfesores().contains(profesor)) {
            curso.agregarProfesor(profesor);
            profesor.agregarCurso(curso);
        }
    }

    public void eliminarProfesorDeCurso(Profesor profesor, Curso curso) {
        if (curso.obtenerProfesores().contains(profesor)) {
            curso.eliminarProfesor(profesor);
            profesor.eliminarCurso(curso);
        }
    }

    public void inscribirAlumnoACurso(Alumno alumno, Curso curso) {
        try {
            validarInscripcion(alumno, curso);
            realizarInscripcion(alumno, curso);
        } catch (InscripcionException e) {
            System.out.println("Error al inscribir al alumno: " + e.getMessage());
        }
    }

    private void realizarInscripcion(Alumno alumno, Curso curso) {
        curso.agregarAlumno(alumno);
        alumno.inscribirACurso(curso);
        System.out.println("Inscripción realizada con éxito.");
    }

    private void validarInscripcion(Alumno alumno, Curso curso) throws InscripcionException {
        LocalDate fechaMaximaInscripcion = this.fechaMaximaInscripcion;

        if (LocalDate.now().isAfter(fechaMaximaInscripcion)) {
            throw new InscripcionException("Fuera de la fecha de inscripción.");
        }
        if (alumno.obtenerCarrera() == null) {
            throw new InscripcionException("El alumno no está inscrito a ninguna carrera.");
        }
        if (!alumno.obtenerCarrera().obtenerMaterias().contains(curso.obtenerMateria())) {
            throw new InscripcionException("La materia no corresponde a la carrera del alumno.");
        }
        if (alumno.obtenerMateriasAprobadas().contains(curso.obtenerMateria())) {
            throw new InscripcionException("El alumno ya ha aprobado esta materia.");
        }
        if (curso.obtenerAlumnos().contains(alumno)) {
            throw new InscripcionException("El alumno ya está inscripto en esta materia.");
        }
        for (Materia m : curso.obtenerMateria().obtenerCorrelativasPrevias()) {
            if (!alumno.obtenerMateriasAprobadas().contains(m)) {
                throw new InscripcionException("Falta aprobar materias correlativas para inscribirse a esta materia.");
            }
        }
        int horas = calcularTotalDeHoras(alumno, curso);
        if (horas > alumno.obtenerCarrera().obtenerMaximoHoras()) {
            throw new InscripcionException("Inscribirse a esta materia excedería el máximo de horas permitidas por la carrera.");
        }
    }

    private int calcularTotalDeHoras(Alumno alumno, Curso curso) {
        int horas = curso.obtenerMateria().obtenerCantidadDeHoras();
        for (Curso c : alumno.obtenerCursosInscriptos()) {
            horas += c.obtenerMateria().obtenerCantidadDeHoras();
        }
        return horas;
    }

    public void eliminarAlumnoDeCurso(Alumno alumno, Curso curso) {
        if (curso.obtenerAlumnos().contains(alumno)) {
            curso.eliminarAlumno(alumno);
            alumno.salirDeCurso(curso);
        }
    }

    public void mostrarTodosLosCursos() {
        System.out.println(cursos);
    }

    public ArrayList<Curso> mostrarCursosPorMateria(Materia materia) {
        ArrayList<Curso> cursosFiltrados = new ArrayList<Curso>();
        for (Curso curso : cursos) {
            if (curso.obtenerMateria().obtenerId() == materia.obtenerId()) {
                cursosFiltrados.add(curso);
            }
        }
        return cursosFiltrados;
    }

}
