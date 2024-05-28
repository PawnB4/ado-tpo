package tests;

import controllers.AlumnoController;
import controllers.InscripcionController;
import data.DataInitializer;

public class PagoCuotaTest {

    public static void main(String[] args) {
        DataInitializer.inicializarData();

        // Inscribir alumno a curso
        System.out.println("##### Inscribir alumno a curso #####");
        InscripcionController.getInstance().inscribirAlumnoACurso(123456, 1);// Success
        System.out.println();

        // Realizar "Pago" exitoso con Mercado Pago
        System.out.println("##### Realizar \"Pago\" exitoso #####");
        AlumnoController.getInstance().abonarCuotaMensual(123456, 50000, "mercado pago");
        System.out.println();

        // Realizar "Pago" exitoso con Binance
        System.out.println("##### Realizar \"Pago\" exitoso #####");
        AlumnoController.getInstance().abonarCuotaMensual(123456, 50000, "binance");
        System.out.println();

        // Realizacion del "Pago" nuevamente, con un importe menos al correspondiente a la cuota
        System.out.println("##### Realizar \"Pago\" sin exito #####");
        AlumnoController.getInstance().abonarCuotaMensual(123456, 2400, "mercado pago");
        System.out.println();

        // Realizacion del "Pago" nuevamente, con un medio de pago inexistente
        System.out.println("##### Realizar \"Pago\" sin exito #####");
        AlumnoController.getInstance().abonarCuotaMensual(123456, 2400, "visa debito");
        System.out.println();
    }
}
