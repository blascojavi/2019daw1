/*
a. Crea un HashSet misAsignaturas para almacenar
    nombres de las asignaturas que estas matriculado
    en ciclo DAW. Rellénala
b. Recorre el HashSet y muestra por pantalla las
    asignaturas introducidas. (usa un for-each)
c. Recoge una asignatura y comprueba si está
    almacenada.
*/

package Repaso_temario;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;




public class HasSetEjercicio {
    public static void main(String[] args) {
        String materiaIntro; 
       /*a*/
        Set<String> asignaturas = new HashSet<>();
       
       asignaturas.add("programacion"); 
       asignaturas.add("ldm");
       asignaturas.add("bbdd");
       asignaturas.add("ingles");
       asignaturas.add("entornos");
       
        /*b*/
        for(String asignatura : asignaturas){
            System.out.println(asignatura);
        }
        Scanner scan = new Scanner(System.in); 
        
        System.out.println("");
        System.out.println("Introduce una materia");
        
        materiaIntro = scan.next().toLowerCase(); 
        
        if (asignaturas.contains( materiaIntro )){
            System.out.println("esta dentro del array ");
        }else{
            System.out.println("NO ESTA DENTRO");
        }
        
    }
}
