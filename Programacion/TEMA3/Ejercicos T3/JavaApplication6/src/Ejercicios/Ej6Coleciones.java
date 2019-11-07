/*
. Implementa un ArrayDeque que sirva para organizar los pedidos a nuestra empresa. Crea una menú
con las siguientes opciones:
    a. Dar de alta pedido e introducirlo en la cola
    b. Conocer cuántos pedidos tenemos
    c. Visualizar el primer pedido
    d. Servir un pedido, que desaparecerá de la cola
    e. Salir del programa

 */
package Ejercicios;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import sun.nio.cs.ArrayDecoder;

/**
 *
 * @author dolce
 */
public class Ej6Coleciones {

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in); 
        String seleccion; 
        boolean salir = false;
        final String validador = "^[a-e]$";
        Deque<String> pedidos = new ArrayDeque<>();
        
        System.out.println("MENÚ PRINCIPAL . Por favor seleccione una opción. ");
        System.out.println("");
        System.out.println("a . Dar de alta pedido.");
        System.out.println("b . Listar pedidos.");
        System.out.println("c . Visualizar el primer pedido");
        System.out.println("d . Servir pedido");
        System.out.println("e . SALIR");
        System.out.print(" Seleccione (a - e ) : ");
        seleccion = scan.next(); 
        seleccion = seleccion.toLowerCase();
        
        do{
        switch(seleccion){
                case "a" :
                    System.out.println(" Indique el nombre del nuevo pedido : ");
                    try {
                        pedidos.add( scan.next() );
                        System.out.println("Su pedido se ha añadido correctamente");
                    } catch (Exception e) {
                        System.out.println("Ups parece que no se ha podido añadir a la lista su pedido.");
                    }
                break; 

                case "b" : 
                    System.out.println("");
                    System.out.println("LISTADO DE PEDIDOS");
                    for(String pedido : pedidos){
                        System.out.println(pedido);
                    }       
                break; 

                case "c" : 
                    System.out.println("");
                    System.out.println("Tu primer pedido es :  " + pedidos.getFirst());
                break; 

                case d : 
                    System.out.println("");
                    System.out.println("SIRVIENDO PEDIDO...");
                    
                    System.out.println("ELIMINANDO PEDIDO DE LA LISTA DE PENDIENTES");
                    
                   
                break; 

                case e : 
                    System.out.println("");
                    System.out.println("GRACIAS POR USAR EL PROGRAMA");
                    salir = true; 
                break; 

                default : 

                break; 
            }
        }while (salir);
    }
    
}
