
/*EJERCICIOS DE COLECCIONES 1 */

package Ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Coleciones1 {
    public static void main(String args[]){
        /* 1. Implementa programa que genera y almacena las N notas de mis alumnos y saca la
nota media.*/ 
        
        Scanner solicitaNumAlumnos = new Scanner(System.in); 
        int numAlumnos = 0 ; 
        int nota = 0; 
        Random notaAleat = new Random();
        int sumaNotas= 0 ;
        Double notaMedia = 0.0 ; 

        List<Integer> notas = new ArrayList<Integer>();
        
        
        
        System.out.println("Cuantos alumnos computo : ");
        numAlumnos = solicitaNumAlumnos.nextInt();
        
        for(int i = 1 ; i <= numAlumnos ; i++){
            nota = notaAleat.nextInt(11);
            notas.add(nota); 
            sumaNotas += nota; 
        }
               
        System.out.println("suma notas : " + sumaNotas);

         
        notaMedia = (double)sumaNotas / notas.size(); 
        
        System.out.println("NOTA MEDIA : " + notaMedia);
        System.out.println("");

        for(int index = 1 ; index <= notas.size() ; index ++){
            
            System.out.println("alumno num " + index + " NOTA: " +
                    notas.get(index-1));
        } 

    }
    
    
}
