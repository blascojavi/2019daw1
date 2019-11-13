/*
* 5) Dados tres valores numéricos , calcula la suma , producto y media  de todos ellos
*/


import java.util.Scanner;

public class SumaProductoMedia {

    public static void main (String [] args) {
        Scanner scan  = new Scanner(System.in);

        System.out.println("Introduce el primer número");
        double val1 = scan.nextDouble();
        System.out.println("Introduce el segundo número");
        double val2 = scan.nextDouble();
        System.out.println("Introduce el tercer número");
        double val3 = scan.nextDouble();

        System.out.println("Primer valor : " + val1 + " Segundo Valor : " + val2 + " Tercer valor : " + val3);

        double suma =  val1 + val2 + val3;
        double producto =  val1 * val2 * val3;
        double media = (val1+val2+val3)/3;


        System.out.println("SUMA : " + suma +
                            " PRODUCTO : " +  producto +
                            " MEDIA : " + media );

    }
}
