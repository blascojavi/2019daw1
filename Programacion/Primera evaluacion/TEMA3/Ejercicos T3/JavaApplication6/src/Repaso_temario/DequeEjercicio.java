/*
a. Crea un ArrayDeque para almacenar una
lista de espera para comprar el nuevo
Iphone 8.
b.Apunta a 5 personas
c.Muestra la lista indicando cuantos hay y
el orden de cada uno
d.Saca de la lista a los 3 primeros y
muestralos por pantalla
*/

package Repaso_temario;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;

public class DequeEjercicio {
    public static void main(String[] args) {
        /*a*/
        Deque<String> listaEspera = new ArrayDeque<>();
        int tamanoLista = 0;
        
        /*b*/
        listaEspera.add("Pepe");
        listaEspera.add("Juan"); 
        listaEspera.add("Roberto"); 
        listaEspera.add("Julian");
        listaEspera.add("Manolo");
        
        /*c*/
        Iterator<String> it = listaEspera.iterator();

        for (int pos = 1 ; pos <= listaEspera.size() ; pos++){ 
            System.out.println("Posición : " + pos + " Nombre : " + 
                                it.next());   
        }
        
        /*d*/
        for (int index = 1 ; index <= 3 ; index++){
            System.out.println("La persona " + listaEspera.removeFirst() 
            + " ha salido de la cola");
        }
        
        
        
        
    }
}
