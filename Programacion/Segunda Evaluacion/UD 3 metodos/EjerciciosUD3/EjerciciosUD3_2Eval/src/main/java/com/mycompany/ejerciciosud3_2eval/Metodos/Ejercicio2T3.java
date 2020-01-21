/*
2.Define un método que indique si un numero es primo o no ( esPrimo(int num) ). Como parámetro
recibirá dicho número y devolverá un boolean. Úsalo para los números 150, 257 y 1487

3.Usar el método anterior para mostrar por pantalla los números primos que hay en un rango de números,
ente inicio y fin.

4. Define método que devuelve una lista de números primos hasta un número pasado como parámetro (
List<Integer> primos(int añoTope) ). Debes utilizar dentro de este método el creado
anteriormente (usa esPrimo(num)). El programa debe recoger el número sobre el que calcular su lista
de primos, llamar al método, recoger esa lista y mostrarla por pantalla.s
 */
package com.mycompany.ejerciciosud3_2eval.Metodos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jasper
 */
public class Ejercicio2T3 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Deme un número : ");
        if(esPrimo(scan.nextInt())){
            System.out.println("ES PRIMO");   
        } else{
            System.out.println("por lo que NO es PRIMO");
        }
        
        
    }
    
    
    public static boolean  esPrimo(int num) {
        
        // si es divisible solo por 1 y por el mismo es primo 
        //Devolver TRUE se es primo 
        boolean resultado = false;
        List<Integer> divisores = new ArrayList<>();
       
        for ( int i = 2 ; i <= num-1 ; i++){
        
                if(num%i != 0) {
                    //es primo 
                }else{
                    //no es primo
                    divisores.add(i); 
                }
               
        }
        
                   if(divisores.isEmpty()){
                    resultado = true; 
                }else{
                    for(int divisor : divisores){
                        System.out.println("es divisible por  " + divisor );
                    }
                }
        return resultado; 
    }
    
    
    public static ArrayList<Integer> listarPrimos(int numero){
        ArrayList<Integer>  listadoPrimos = new ArrayList<>(); 
        
        
        return listadoPrimos;
    }
    
}
