/*
* 7) Escribir el porcentaje descontado en una compra, recogiendo el precio de la etiqueta y el precio pagado en caja.
 */

import java.util.Scanner;

public class CalculoDescuentoCompra {
    public static void main(String[] args) {
        double etiqueta , pagadoCaja , descuento;

        Scanner scan = new Scanner(System.in);

        System.out.println("Introduzca el valor de la etiqueta:");
        etiqueta = scan.nextDouble();
        System.out.println("Introduzca el coste cobrado en caja: ");
        pagadoCaja = scan.nextDouble();

        descuento = (pagadoCaja*100)/etiqueta;

        System.out.println("El descuento aplicado a la compra es de : " + descuento + " %");


    }
}
