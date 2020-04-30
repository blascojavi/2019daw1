package Modelo;

import jdk.nashorn.internal.ir.ReturnNode;
import org.w3c.dom.Element;

public abstract class Electrodomestico extends Producto {

    protected String marca ;
    protected String modelo ;
    protected ClaseElectrodomestico clase  = ClaseElectrodomestico.DEFAULT;

    public Electrodomestico(){
        super();
    }

    public void setMarca(String marca ){
        this.marca = marca ;
    }

    public void setModelo (String modelo){
        this.modelo = modelo;
    }
    public  ClaseElectrodomestico getClase() {
        setClase(this);
        return clase;
    }

    public  void setClase(Producto p) {
        if(p instanceof Tv ){
            this.clase = ClaseElectrodomestico.TV;
        }
        if(p instanceof Radio){
            this.clase = ClaseElectrodomestico.RADIO;
        }
    }

    @Override
    public String toString() {
        return "marca : " + marca  +
                "  modelo :  " + modelo  +
                "  clase : " + clase +
                "  ID de producto : " + super.idProducto +
                "  PVP : " + super.precioProducto;
    }
}
