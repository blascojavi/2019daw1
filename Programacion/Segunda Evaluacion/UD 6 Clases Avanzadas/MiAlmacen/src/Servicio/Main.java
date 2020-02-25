package Servicio;

import Modelo.*;

public class Main {

    public static void main(String[] args) {
        Tv tv1 = new Tv();
        Tv tv2 = new Tv();
        Radio rd1 = new Radio();


        tv1.setIdProducto();
        tv1.setNombreProducto("Television 1 ");
        tv1.setPrecioProducto(150.20);
        tv1.setMarca("Lg");
        tv1.setModelo("47Lm543");
        tv1.setIdProducto();


        tv2.setIdProducto();
        tv2.setNombreProducto("Television 2 ");
        tv2.setPrecioProducto(999.20);
        tv2.setMarca("Samsung");
        tv2.setModelo("SAM23");
        tv2.setIdProducto();


        rd1.setIdProducto();
        rd1.setNombreProducto("Radio 1 ");
        rd1.setPrecioProducto(20);
        rd1.setMarca("Radiola");
        rd1.setModelo("RadioBasic");
        rd1.setIdProducto();

        Producto.setProductoEnVenta(tv1);
        Producto.setProductoEnVenta(tv2);
        Producto.setProductoEnVenta(rd1);


        System.out.println(tv1);
        System.out.println(rd1);
        System.out.println(tv2.getIdProducto());
        System.out.println(rd1.getIdProducto());


        for(Producto prod : Producto.getProductosEnVenta()){
            System.out.println(prod);

        }





    }
}
