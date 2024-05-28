package controllers;

import classes.Curso;
import classes.GeneradorReportesExcel;
import classes.GeneradorReportesPDF;
import classes.ProfesorManager;
import interfaces.IGeneradorReportes;

import java.util.ArrayList;

public class ReporteController {
    private static final String FORMATO_NO_SOPORTADO = "Formato de reporte no soportado";

    private static ReporteController instance;

    private ReporteController() {

    }
    public static ReporteController getInstance() {
        if (instance == null) {
            instance = new ReporteController();
        }
        return instance;
    }

    public void generarReporte(String formato, ArrayList<Curso> data) {
        IGeneradorReportes generador = obtenerGeneradorReporte(formato);
        if (generador == null) return;
        generador.generarReporte(data);
    }

    private IGeneradorReportes obtenerGeneradorReporte(String formatoSalida) {
        switch (formatoSalida.toLowerCase()) {
            case "pdf":
                return new GeneradorReportesPDF();
            case "excel":
                return new GeneradorReportesExcel();
            default:
                System.out.println(FORMATO_NO_SOPORTADO);
                return null;
        }
    }
}
