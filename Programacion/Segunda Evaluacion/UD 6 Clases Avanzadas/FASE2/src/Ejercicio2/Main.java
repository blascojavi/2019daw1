package Ejercicio2;

import java.util.Enumeration;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Enumerados.mesesAño mesDos = Enumerados.mesesAño.FEBRERO;

        System.out.println("Que mes es tu cumpleaños? ");
        String mesUsuario = sc.next();

        try {
            Enumerados.mesesAño cumpleUsuario = Enumerados.mesesAño.valueOf(mesUsuario.toUpperCase());
                if (cumpleUsuario == Enumerados.mesesAño.SEPTIEMBRE) {
                    System.out.println("Coincidimos en el cumpleaños");
                }else{
                    System.out.println("no coincidimos");
            }
        }catch(IllegalArgumentException e ){
           Enumerados.mesesAño[] mesesAno  = Enumerados.mesesAño.values();
            System.out.println("Error al introducir el mes. Los valores posibles son : ");
            for (Enumerados.mesesAño mesAno : mesesAno){
                System.out.println(mesAno);
            }
        }

        System.out.println("Listando categorias profesionales ");

        catProfesional[] categorias = catProfesional.values();

        for(catProfesional categoria : categorias){
            System.out.println(categoria);
        }



        System.out.println("FIN");

    }
}
