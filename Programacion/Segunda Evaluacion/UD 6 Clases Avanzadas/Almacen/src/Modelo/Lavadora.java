package Modelo;

public class Lavadora extends Electrodomestico {

    private static final int HEAVY_CHARGE = 8;
    private int revoluciones;
    private double carga;

    public Lavadora() {
        super();
    }

    @Override
    public void setPrecio(double precioBase) {

        if(this.revoluciones > 500 ){
           precioBase = precioBase + (precioBase * PORCENTAJE_DESVIACION )/CIEN_X_CIEN;
        }
        if(this.carga < HEAVY_CHARGE){
            precioBase = precioBase - (precioBase * 15 )/CIEN_X_CIEN;

        }
            this.precio = precioBase;
    }

    public int getRevoluciones() {
        return revoluciones;
    }

    public void setRevoluciones(int revoluciones) {
        this.revoluciones = revoluciones;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    @Override
    public String imprimirProducto() {
        String res = super.imprimirProducto() + "de revoluciones: " + this.revoluciones + "con carga: " + this.carga;
        return res;
    }

}
