/*
Leer 7 números indicando tras leer el último de ellos,
cuántos eran múltiplos de 3.
 */
package Ejercicios1;

import java.util.Scanner;

public class EvaluaMultiploDeTres {

    public static void main(String[] args) {
         Scanner scan = new Scanner(System.in); 
        float value = 0; 
        int count = 0 ;
         
        for (int i = 0 ; i<= 6 ; i++){
            value = scan.nextFloat(); 
            if (value%3 == 0 ){
                count++;
            }     
        }
        System.out.println("Total multiplos de 3 : " + count );
    }   
}
