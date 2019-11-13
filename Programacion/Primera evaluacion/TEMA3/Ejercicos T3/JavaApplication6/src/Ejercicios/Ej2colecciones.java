/*Implementa programa que recoge edades hasta que el usuario teclee 0 (no sabemos cuantas
introducirá). Debes almacenarlas todas, las de menores de edad y las de jubilados en ArrayList
diferentes, e indicar cuantas hay de cada tipo.*/

package Ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ej2colecciones {
    
    public static void main(String[] args) {
        
        Scanner introduceEdad = new Scanner(System.in);
        int edadIntroducida = 0 ; 
        final int ESCAPE = 0; 
        final int MAYORIA_EDAD = 18; 
        List<Integer> listaEdadesMayores = new ArrayList<>();
        List<Integer> listaEdadesMenores = new ArrayList<>();
        
        System.out.println("Introduzca una edad , 0 para salir.");
        
        do {
            edadIntroducida = introduceEdad.nextInt();
            if (edadIntroducida < MAYORIA_EDAD){
                listaEdadesMenores.add(edadIntroducida);  
           
            }else{
                listaEdadesMayores.add(edadIntroducida); 
              
            }
        }while(edadIntroducida != ESCAPE );
        
        System.out.println("HAY " + listaEdadesMayores.size() + 
                " personas mayores de edad. ");
        System.out.println("HAY " + listaEdadesMenores.size() + 
                " personas menores de edad. ");
    }

}


