/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios1;

import java.util.Scanner;

/**
 *
 * @author fr
 */
public class NumDiasSegunMes {
        public static void main (String args[]){
            Scanner scan = new Scanner(System.in); 
            
            String mes = scan.nextLine(); 
            
            switch (mes.toLowerCase()){
                case "enero":
                case "marzo":
                case "mayo":
                case "agosto":
                case "octubre":
                case "diciembre":
                    System.out.println("31 dias");
                break; 
                case "febrero": 
                    System.out.println("28 dias");
                break; 
                case "abril":
                case "junio":
                case "julio":
                case "septiembre":
                case "noviembre":
                    System.out.println("30 dias");
                
                default: 
                    System.out.println("Mes incorrecto");
                break;
            }
            
      
        }
}
