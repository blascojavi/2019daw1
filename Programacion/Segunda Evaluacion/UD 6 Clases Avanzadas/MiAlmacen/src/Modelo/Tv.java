package Modelo;


public class Tv extends Electrodomestico {

    public Tv(){
        super();

    }


    @Override
    public void setIdProducto() {

        this.idProducto = this.getClase() + "-" + getCouterProducts(); // despues usar tokenizer para separar el numero del tipo ;
    }

    @Override
    public void setNombreProducto(String nombre) {
        this.nombreProducto = nombre;
    }

    @Override
    public void setPrecioProducto(double precio) {
        this.precioProducto = precio;
    }

    @Override
    public String getIdProducto() {
        return this.idProducto;
    }


}
