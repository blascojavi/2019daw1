/*
a.Crea un ArrayList para almacenar los
nombres de tus mejores amigos.
b.Recorre la lista y muestra por pantalla los nombres introducidos.
c.Ordenalos alfabeticamente y muestralos
d.Recoge por pantalla un nuevo nombre y añadelo. Muestra la lista por pantalla.
*/

package Repaso_temario;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListEjercicios {
    public static void main(String[] args) {
        String amigoIntroducido ; 
        /*a*/
        List<String> listaAmigos = new ArrayList<>();
        
        listaAmigos.add("Pepe"); 
        listaAmigos.add("Juan"); 
        listaAmigos.add("Perico"); 
        listaAmigos.add("Andres"); 
        
        
        /*b*/
        for(String amigo : listaAmigos){
            System.out.println("con foreach :  " + amigo);
        }
        
        /*b2*/
        Iterator<String> it = listaAmigos.iterator();
        
        while(it.hasNext()){
            System.out.println("con iterator : " + it.next());
        }
        
        
        /*c*/
        listaAmigos.sort(null);
        for(String amigoOrdenado : listaAmigos){
            System.out.println("ordenado : " + amigoOrdenado);
        }
        
        /*d*/
        Scanner scan = new Scanner(System.in);
        System.out.println("nombre nuevo amigo : ");
        amigoIntroducido = scan.next();
        System.out.println("introdujo : " + amigoIntroducido);
        
        listaAmigos.add(amigoIntroducido); 
        
        Iterator<String> it2 = listaAmigos.iterator();
        
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
        
    }
    

}
