/*
 * Dado un numero de entrada indicar si es multiplo de 8 
 * 
 * 
 */
package Ejercicios1;

import java.util.Scanner;

/**
 *
 * @author fr
 */
public class MultiploDeOcho {
    public static void main (String args[]){
            
        Scanner scan = new Scanner(System.in); 
        int entrada = scan.nextInt();
        int resto= entrada%8; 
        
        if (entrada%8 == 0 ){
            System.out.println("SI ES DIVISIBLE");
        }else{
                System.out.println("No es divisible"); 
            }
        
    }
}
