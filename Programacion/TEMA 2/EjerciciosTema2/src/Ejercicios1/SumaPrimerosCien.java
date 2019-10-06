/*
 Sumar los 100 primeros números.
 */
package Ejercicios1;

import java.util.Scanner;

public class SumaPrimerosCien {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        float value = 0 ;
            

        
        for (int i = 0 ; i<=99 ; i++ ){
           value += scan.nextFloat(); 
            
        }
        System.out.println("La suma de los 100 numero es : " + value);
    }
    
}
