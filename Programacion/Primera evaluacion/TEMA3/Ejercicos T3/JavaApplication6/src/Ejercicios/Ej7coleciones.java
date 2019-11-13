/*
Almacena en un HashMap los códigos y descripciones de los 5 primeros pokemon.
    a. Muestra por pantalla los datos almacenados
    b. Pide un código y muestra el nombre del pokemon
    c. Lista solo los nombres de todos los pokemon

 */
package Ejercicios;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class Ej7coleciones {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String selec ;
        Map<String , String> pokemonList = new HashMap<>();
        pokemonList.put("1" , "Picachu");
        pokemonList.put("2","Charmander");
        pokemonList.put("3","squirttle");
        pokemonList.put("4" , "Muk");
        pokemonList.put("5", "Charizar");
        /*a*/
        System.out.println("LISTA DE POKEMONS");
        System.out.println(pokemonList);
        System.out.println("");
        /*b*/
        System.out.print("Introduce el código del pokemon a mostrar:" );
        selec = scan.next().toLowerCase();
        System.out.println(" El pokemon con el código :  " + selec + " es " + pokemonList.get(selec));
        /*c*/
        System.out.println("");
        System.out.println("LISTADO DE TODOS LOS POKEMON: ");
        
        Iterator<String> keysPoke = pokemonList.keySet().iterator();
        
        while(keysPoke.hasNext()){
            String codigo =keysPoke.next();
            System.out.println("- " + pokemonList.get(codigo));
        }
    }
    
}
