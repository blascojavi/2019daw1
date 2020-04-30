package Modelo;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mueble extends Producto {



    public enum Madera {
        PINO, ROBLE, HAYA
    };

    private LocalDate anyoFab;
    private Madera tipoMadera;
    private String estilo;
    private double precio ;

    public Mueble() {
        super();
    }


    @Override
    public String imprimirProducto() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yy");
        String res = super.imprimirProducto() + "el año de fabricación: " + sdf.format(anyoFab) + " el tipo de madera: " + this.tipoMadera + "el estilo: " + getEstilo();
        return res;

    }

    @Override
    public void setPrecio(double precioBase) {
       switch(this.tipoMadera){
           case ROBLE:
               this.precio = precioBase + (precioBase * PORCENTAJE_DESVIACION)/CIEN_X_CIEN;
               break;
           case PINO:
               this.precio = precioBase - (precioBase * PORCENTAJE_DESVIACION)/CIEN_X_CIEN;
               break;
           default:
               this.precio = precioBase;
               break;
       }
    }

    public String getAnyoFab() {
        String anyoFabFormateado =  anyoFab.format(DateTimeFormatter.ofPattern("dd/MMM/yy"));
        return anyoFabFormateado;
    }

    public void setAnyoFab(LocalDate anyoFab) {
        this.anyoFab = anyoFab;
    }

    public Madera getTipoMadera() {
        return tipoMadera;
    }

    public void setTipoMadera(Madera madera) {
        this.tipoMadera = madera;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

}
