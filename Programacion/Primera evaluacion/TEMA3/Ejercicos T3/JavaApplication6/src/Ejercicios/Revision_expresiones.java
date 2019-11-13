
package Ejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Revision_expresiones {


    public static void main(String[] args) {
       List<String> lista = new ArrayList<>();
       
       lista.add("aaaa"); 
       lista.add("oooo"); 
       
       lista.add("zzzz"); 
       lista.add("ssss"); 
       
       lista.sort(null);
       Collections.reverse(lista);
        System.out.println(lista);
        
        Iterator it ; 
        
        it = lista.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
        
        
    }
    
}
