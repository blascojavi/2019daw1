package Ejercicio2;

public class AparatoElectrico {
    private String nombre = "";
    private double consumo = 0;
    private boolean isOn = false;
    private  static double consumoTotal  = 0 ;

    public AparatoElectrico(String nombre, double consumo) {
        this.nombre = nombre;
        this.consumo = consumo;
    }

    public double  on(){
        this.isOn = true ;
        consumoTotal += consumo;
        return consumoTotal;
    }

    public double  off(){
        if(this.isOn == true){
            consumoTotal -= consumo;
            this.isOn = false;
        }
        return consumoTotal;
    }


    @Override
    public String toString() {
        return "CONSUMO TOTAL DE LA CASA " + consumoTotal ;
    }
}
