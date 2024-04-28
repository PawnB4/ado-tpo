package interfaces;

import classes.Curso;

import java.util.ArrayList;

public interface IGeneradorReportes {
    void generarPDF(ArrayList<Curso> cursos);
}
