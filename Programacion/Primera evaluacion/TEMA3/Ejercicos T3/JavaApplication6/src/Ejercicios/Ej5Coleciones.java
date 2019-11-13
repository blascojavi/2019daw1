/*
 Para gestionar la cola de espera para matricularse en el ciclo de DAW crea un
ArrayDeque para almacenar las personas según orden de preinscripción.
    a. Rellena con 3 nombres personas
    b. Pide un nombre de alumno que quiere entrar en la cola e introdúcelo al final
    c. Muestras cuantos y quienes estan en la cola
    d. Recupera el ultimo
    e. Se admite al primero, muestralo y eliminalo de la cola
    f. Muestras cuantos y quienes estan en la cola
 */
package Ejercicios;

import java.util.ArrayDeque;
import java.util.Scanner;


public class Ej5Coleciones {

    public static void main(String[] args) {
        ArrayDeque<String> alumnosInscritos = new ArrayDeque<>();
        Scanner scan = new Scanner(System.in); 
        String nuevoInscrito; 
        
        /*a*/
        alumnosInscritos.add("Mireia"); 
        alumnosInscritos.add("Antonio"); 
        alumnosInscritos.add("Juan");
        
        /*b*/
        System.out.println("Introduce el nombre de inscripción : ");
        nuevoInscrito = scan.next();
        
        alumnosInscritos.add(nuevoInscrito);
        
        /*c*/
        System.out.println("");
        for(String alumno : alumnosInscritos){
            System.out.println(alumno);
        }
        
        /*d*/
        System.out.println("");
        System.out.println("Último inscrito: " + alumnosInscritos.getLast());

        
        /*e*/
        System.out.println("Alumno " + alumnosInscritos.removeFirst() + " admitido");
        System.out.println("");
        
        /*f*/
        System.out.println("La lista queda : ");
        System.out.println("");
        for(String alumno : alumnosInscritos){
            System.out.println(alumno);
        }
        System.out.println("Hay " + alumnosInscritos.size() + " Pendientes de admisión");
        
        
    }
    
}
