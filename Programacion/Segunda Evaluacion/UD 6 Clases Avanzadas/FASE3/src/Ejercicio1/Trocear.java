package Ejercicio1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Trocear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe varias palabras separadas por = ");

        StringTokenizer stkUser = new StringTokenizer(sc.next(), "=");

        System.out.println("Hay un total de : " + stkUser.countTokens() + "Palabras separadas por = ");

        String[] tokens ;

        while(stkUser.hasMoreTokens()){
            System.out.println(stkUser.nextToken());
        }


    }

}
