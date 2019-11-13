/*
Sumar todos aquellos números leídos mientras no sean negativos 
y haz la media de todos ellos

 */
package Ejercicios1;

import java.util.Scanner;

public class SumaYmediaPositivos {

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in); 
        
        int value ; 
        int suma = 0; 
        int count = 0 ; 
        
       do{
            value = scan.nextInt();
            
            if (value > 0 ){
                suma += value;
                count ++; 
            }
      
       }while(value >= 0);

        System.out.println("La suma de los números NO negativos es : " + suma);
        System.out.println("La MEDIA DE TODOS ES :  " + (float)suma/(count--));
              
    }
    
}
