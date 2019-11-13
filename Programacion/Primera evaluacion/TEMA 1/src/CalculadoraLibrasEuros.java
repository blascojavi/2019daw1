/*
* 4)Dada un cantidad correspondiente a euros, calcule su equivalente en libras esterlinas, sabiendo que
*  1 libra son 1.18 euros. Define una variable constante para el cambio.
* Muestra por pantalla el calculo final.
*
*/

import java.util.Scanner;

public class CalculadoraLibrasEuros {

    public static void main (String[] args ){
        final double LIBRA_EURO = 1.18;

        Scanner scanEuro = new Scanner(System.in);
        System.out.println("Introduzca cantidad de Libras a convertir");

        double libraIntro = scanEuro.nextDouble();

        System.out.println("Ha introducido : " + libraIntro + " El valor de libra a Euro es de : " + LIBRA_EURO);

        String result = String.format("%.2f" , libraIntro * LIBRA_EURO);

        System.out.println("RESULTADO : "  + result + " Euros");


    }

}

