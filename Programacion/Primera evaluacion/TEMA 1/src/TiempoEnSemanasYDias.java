/*
* 8) Realiza un programa con una variable entera totalDias, la cual almacenará una cantidad de dias
*    y queremos conocer ese tiempo pero expresado en semanas y dias
 */

import java.util.Scanner;

public class TiempoEnSemanasYDias {
    public static void main(String[] args) {
        int totalDias ;
        float semanas , dias ;

        Scanner scan = new Scanner(System.in);

        System.out.println("Introduce el total de dias a calcular : ");
        totalDias = scan.nextInt();

        semanas = Math.round(totalDias/7);
        dias = totalDias%7;

        System.out.println("En esos dias hay " + (int)semanas + "semanas  y " + (int)dias + " dias");

    }
}
