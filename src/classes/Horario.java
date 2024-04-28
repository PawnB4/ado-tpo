package classes;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class Horario {
    private DayOfWeek dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Duration duracion;

    public Horario(DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.duracion = Duration.between(horaInicio, horaFin);
    }

    private String calcularTurno() {
        if (horaInicio.isAfter(LocalTime.of(18, 0))) {
            return "Noche";
        } else if (horaInicio.isAfter(LocalTime.of(11, 30))) {
            return "Tarde";
        } else {
            return "Mañana";
        }
    }

    @Override
    public String toString() {

        return dia + " " + calcularTurno();
    }

}
