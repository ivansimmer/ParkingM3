package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ivans
 */
public class Ticket {
    
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private Vehiculo vehiculo;
    private Plaza plaza;

    public Ticket(LocalDateTime fechaEntrada, LocalDateTime fechaSalida, Vehiculo vehiculo, Plaza plaza) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.vehiculo = vehiculo;
        this.plaza = plaza;
    }

    public double calcularDuracion() {
        fechaSalida = LocalDateTime.now();
        return java.time.Duration.between(fechaEntrada, fechaSalida).toMinutes();
    }

    public double calcularImporte(double duracion, double tarifa) {
        return duracion * tarifa;
    }

    public Plaza getPlaza() {
        return plaza;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public String getFechaEntradaFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return fechaEntrada.format(formatter);
    }
}
