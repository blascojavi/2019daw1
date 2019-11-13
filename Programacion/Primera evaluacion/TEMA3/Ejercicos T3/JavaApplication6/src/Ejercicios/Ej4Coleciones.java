/*
Almacena en un HashSet, llamado “coches”, nombres de 5 marcas de coches .
    a. Muestra por pantalla los datos introducidos
    b. ¿Está “Seat”? si está bórralo e introdúcelo como “SEAT”
    c. Crea otro HashSet con 5 marcas de coches japoneses, y añádelas a coches (usa un único método)
    d. Muestra por pantalla los datos
    e. Muestra cuantos elementos hay en coches
*/

package Ejercicios;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Ej4Coleciones {
    public static void main(String[] args) {
        
        Set<String> coches = new HashSet<>();
        coches.add("seat");
        coches.add("ford");
        coches.add("opel");
        coches.add("Peugeot");
        coches.add("renault");
        
        
        /*a*/
        Iterator<String> iter = coches.iterator();
        while(iter.hasNext()){
            System.out.println("MARCA : " + iter.next());
        }
        /*b*/
        if (coches.contains("seat")){
            coches.remove("seat"); 
            coches.add("SEAT");
        }
        
        System.out.println("");
        for(String marca : coches ){
            System.out.println("Marca b : " + marca );
        }
        
        /*c*/
        Set<String> marcasJapo = new HashSet<>();
        marcasJapo.add("kia");
        marcasJapo.add("nissan");
        marcasJapo.add("yamaha");
        marcasJapo.add("Honda");
        marcasJapo.add("subaru");
        
        coches.addAll(marcasJapo);
        
        /*d*/
        System.out.println("");
        coches.forEach((marca) -> {
            System.out.println("Marca c : " + marca );
        });
        
        /*e*/
        System.out.println("Hay " + coches.size() + " marcas registradas.");
    }
    
}
