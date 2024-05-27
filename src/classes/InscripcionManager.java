package classes;

import exceptions.InscripcionException;

import java.time.LocalDate;

public class InscripcionManager {

    private LocalDate fechaMaximaInscripcion;

    public InscripcionManager() {
    }


    public void setFechaMaximaInscripcion(LocalDate fechaMaximaInscripcion) {
        this.fechaMaximaInscripcion = fechaMaximaInscripcion;
    }

    public void inscribirAlumnoACarrera(Alumno alumno, Carrera carrera) {
        if (alumno.obtenerCarrera() == null) {
            alumno.inscribirACarrera(carrera);
        }
    }

    public void eliminarAlumnoDeCarrera(Alumno alumno) {
        if (alumno.obtenerCarrera() != null) {
            alumno.salirDeCarrera();
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

    public void eliminarAlumnoDeCurso(Alumno alumno, Curso curso) {
        if (curso.obtenerAlumnos().contains(alumno)) {
            curso.eliminarAlumno(alumno);
            alumno.salirDeCurso(curso);
        }
    }


    private int calcularTotalDeHoras(Alumno alumno, Curso curso) {
        int horas = curso.obtenerMateria().obtenerCantidadDeHoras();
        for (Curso c : alumno.obtenerCursosInscriptos()) {
            horas += c.obtenerMateria().obtenerCantidadDeHoras();
        }
        return horas;
    }

}
