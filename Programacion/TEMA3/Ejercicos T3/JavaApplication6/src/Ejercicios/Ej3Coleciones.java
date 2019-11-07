
/*Almacena en un HashSet, llamado “marcas_moviles”, nombres de 5 marcas de
móviles. AÑADIDO controlar los repetidos. 
*/
package Ejercicios;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author buceo
 */
public class Ej3Coleciones {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        Set<String> marcasCoches = new HashSet<>();
        int index = 1 ; 
        String marca; 
        
        while(index <= 5){
            marca = scan.next(); 
            if (!marcasCoches.contains(marca)){
                marcasCoches.add(marca);
                index++;
            }else{
                System.out.println("LA MARCA YA EXISTE EN LA LISTA . No se registrará");
            }
            
        }

        
        
        for(String marcaEnConjunto : marcasCoches){
            System.out.println("Marca introducida:  " + marcaEnConjunto);
        }
        
    }
}
