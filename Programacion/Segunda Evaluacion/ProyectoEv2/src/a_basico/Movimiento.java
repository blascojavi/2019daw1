package a_basico;

import java.time.LocalDateTime;

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


    //TODO: formatear mejor los movimientos ,Redefine el método toString() para mostrar el formato: "2019/12/22T16:34:56.123 -
    // 500€ pago recibo"
    @Override
    public String toString() {
        return "Movimiento{" +
                "fecha=" + fecha +
                ", cantidad=" + cantidad +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
