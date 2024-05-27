package controllers;

import classes.Profesor;
import interfaces.IGeneradorReportes;

public class ReportesController {

    private IGeneradorReportes generadorReportes;

    public ReportesController(IGeneradorReportes generadorReportes) {
        this.generadorReportes = generadorReportes;
    }

    public void generarReportePDFCursosPorProfesor(Profesor profesor){
        this.generadorReportes.generarPDF(profesor.obtenerCursos());
    }

}

