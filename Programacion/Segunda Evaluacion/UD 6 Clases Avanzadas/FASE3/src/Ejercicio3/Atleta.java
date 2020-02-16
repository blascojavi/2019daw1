package Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Atleta implements Comparable<Atleta>{

    private String nombre ;
    private int codigFederado;
    private double mejorMarca100m ;

    public static List<Atleta> atletasParticipantes = new ArrayList<>();

    public Atleta(String nombre, int codigFederado, double mejorMarca100m) {
        this.nombre = nombre;
        this.codigFederado = codigFederado;
        this.mejorMarca100m = mejorMarca100m;
        atletasParticipantes.add(this);
    }

    public void anadirParticipante (Atleta atleta){
        atletasParticipantes.add(atleta);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigFederado() {
        return codigFederado;
    }

    public void setCodigFederado(int codigFederado) {
        this.codigFederado = codigFederado;
    }

    public double getMejorMarca100m() {
        return mejorMarca100m;
    }

    public void setMejorMarca100m(double mejorMarca100m) {
        this.mejorMarca100m = mejorMarca100m;
    }

    @Override
    public int compareTo(Atleta otro) {
        int comparation = 0 ;
        if(this.mejorMarca100m < otro.mejorMarca100m){
            comparation = -1 ;
        }
        if(this.mejorMarca100m == otro.mejorMarca100m){
            comparation = 0 ;
        }
        if (this.mejorMarca100m > otro.mejorMarca100m){
            comparation = 1 ;
        }
        return comparation;
    }

    @Override
    public String toString() {
        return "Atleta : " + nombre + " Marca de 100 metros :  " + mejorMarca100m  ;
    }
}
