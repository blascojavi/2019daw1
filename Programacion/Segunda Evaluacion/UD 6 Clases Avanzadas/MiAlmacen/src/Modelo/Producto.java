package Modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Producto {
    protected String idProducto;
    protected String nombreProducto ;
    protected double precioProducto ;
    protected static List<Producto> productosEnVenta = new ArrayList<>();

    public abstract void setIdProducto();
    public abstract void setNombreProducto(String nombre);
    public abstract void setPrecioProducto(double precio);
    public abstract String getIdProducto();

    public static void setProductoEnVenta(Producto p){
        productosEnVenta.add(p);
    }

    public static List<Producto> getProductosEnVenta(){
        return productosEnVenta;
    }

    protected int getCouterProducts(){
        return productosEnVenta.size();
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precioProducto=" + precioProducto +
                ", ventas=" + productosEnVenta +
                '}';
    }
}
