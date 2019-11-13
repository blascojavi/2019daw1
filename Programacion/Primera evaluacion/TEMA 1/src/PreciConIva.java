/*
* 6) Dado el precio de un TV, calcular el precio final aplicando un 21% de IVA
 */

import java.util.Scanner;

public class PreciConIva {

    public static void main(String[] args) {
        final double IVA = 0.21;
        Scanner scan = new Scanner(System.in);

        System.out.println("Introduza el precio de la TV ");
        double tvPrizeNoIva = scan.nextDouble();

        double tvIva = tvPrizeNoIva * IVA;

        System.out.println("El precio con iva de la Tv es de : " + (tvPrizeNoIva+tvIva) +
                " El IVA aplicado es de : " + tvIva);
    }
}
