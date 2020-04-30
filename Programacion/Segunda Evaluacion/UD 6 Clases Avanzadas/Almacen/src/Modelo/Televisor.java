
package Modelo;


public class Televisor extends Electrodomestico {

    protected double pulgadas;
    protected String tipo;
    private final int EXPENSIVE_PULGADAS = 40 ;

    public Televisor() {
        super();
    }

    @Override
    public void setPrecio(double precioBase) {
        if(pulgadas >  EXPENSIVE_PULGADAS){
            precioBase = precioBase + (precioBase * PORCENTAJE_DESVIACION)/CIEN_X_CIEN;
        }
        if (tipo.equalsIgnoreCase("PLASMA")){
            precioBase = precioBase - (precioBase * PORCENTAJE_DESVIACION)/CIEN_X_CIEN;
        }
        this.precio = precioBase;
    }

    @Override
    public String imprimirProducto() {
        String res = super.imprimirProducto() + "tipo de TV: " + this.tipo + "con " + this.pulgadas + " pulgadas";
        return res;

    }

    public double getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(double pulgadas) {
        this.pulgadas = pulgadas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
