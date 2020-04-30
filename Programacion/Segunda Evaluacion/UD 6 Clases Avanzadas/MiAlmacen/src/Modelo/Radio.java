package Modelo;

public class Radio extends Electrodomestico {

    public Radio(){
        super();
    }

    @Override
    public void setIdProducto() {

        this.idProducto = this.getClase()  + "-" + super.getCouterProducts(); // despues usar tokenizer para separar el numero del tipo ;
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
