
package Ejercicio2;

import java.time.LocalDate;


public class ExtranjeroTransito extends Persona {

    private String paisOrigen;
    private LocalDate fechaIngreso;
    private int tiempoPermanencia;

    ExtranjeroTransito() {
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getTiempoPermanencia() {
        return tiempoPermanencia;
    }

    public void setTiempoPermanencia(int tiempoPermanencia) {
        this.tiempoPermanencia = tiempoPermanencia;
    }


    @Override
    public String datos() {
        String respuesta = super.datos();
        
        respuesta += " El pais origen es: " + paisOrigen;
        respuesta += " La fecha ingreso es:" + fechaIngreso;
        respuesta += " El tiempo de permanenecia es: " + tiempoPermanencia;
        
        return respuesta;
    }
}