/*
3. Programa que indica si un año es bisiesto o no, para ello se deben cumplir
las siguientes condiciones: 
El resto de la división del año entre 4 es 0 Y
no debe ser divisible entre 100 (el resto de la división entre 100 deber ser 
distinto de 0) o bien es divisible
entre 400 (el resto de la división entre 400 debe de ser 0)
 */
package Ejercicios1;

import java.util.Scanner;

public class AnoBisiesto {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in); 
        int ano = scan.nextInt(); 
        
        if (ano%4 == 0 && ano%100 != 0  || ano%400 == 0 ){
            System.out.println("EL año " + ano + " Es BISIESTO");
        }else{
            System.out.println("No es BISIESTO");
        } 
    }
    
}
/* && && ano%400 == 0 */