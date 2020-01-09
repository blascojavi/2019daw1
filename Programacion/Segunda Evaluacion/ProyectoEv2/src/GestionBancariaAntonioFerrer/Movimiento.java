package GestionBancariaAntonioFerrer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento {

    private LocalDateTime fecha;
    private String nifRealizaMovimineto;
    private Double cantidad ;
    private String descripcion;

    public Movimiento(LocalDateTime fecha, String nifRealizaMovimineto, Double cantidad, String descripcion) {
        this.fecha = fecha;
        this.nifRealizaMovimineto = nifRealizaMovimineto;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public Movimiento(String nifRealizaMovimiento, Double cantidad, String descripcion) {
        this.fecha = fecha.now();
        this.nifRealizaMovimineto = nifRealizaMovimiento;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getNifRealizaMovimineto() {
        return nifRealizaMovimineto;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatDay = DateTimeFormatter.ofPattern("YYYY/MM/DD");
        DateTimeFormatter formatHour = DateTimeFormatter.ofPattern("HH:MM:SS");
        return fecha.format(formatDay) + "T" + fecha.format(formatHour) +
                "." + nifRealizaMovimineto + " " + cantidad + "€ " + descripcion ;
    }
}
