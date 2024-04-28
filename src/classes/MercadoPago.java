package classes;

import exceptions.PagoException;
import interfaces.IProcesadorPagos;

public class MercadoPago implements IProcesadorPagos {
    public void procesarPago(Alumno alumno) {
        try {
            validarPago(alumno);
            realizarPago(alumno);
        } catch (PagoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void realizarPago(Alumno alumno) {
        alumno.restarSaldo(calcularCostoTotalCuatrimestre(alumno));
        System.out.println("Pago realizado con éxito");
    }

    private void validarPago(Alumno alumno) throws PagoException {
        double suma = calcularCostoTotalCuatrimestre(alumno);
        if (suma > alumno.obtenerBalance()) {
            throw new PagoException("El alumno no cuenta con el balance suficiente para abonar la primer cuota de cada curso al cual está inscripto.\n" +
                    "Total a pagar: $" + suma + "\n" +
                    "Balance del alumno: $" + alumno.obtenerBalance()
            );
        }
    }

    private double calcularCostoTotalCuatrimestre(Alumno alumno) {
        double suma = 0;
        for (Curso c : alumno.obtenerCursosInscriptos()) {
            suma += c.obtenerPrecioCuota();
        }
        return suma;
    }
}
