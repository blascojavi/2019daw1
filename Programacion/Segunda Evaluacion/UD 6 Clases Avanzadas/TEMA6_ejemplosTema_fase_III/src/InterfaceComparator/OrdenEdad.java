
package InterfaceComparator;

import java.util.Comparator;


public class OrdenEdad implements Comparator<Persona>{

    @Override
    public int compare(Persona o1, Persona o2) {
         int comparacion = 0;
        if (o1.anyos < o2.getAnyos())
            comparacion = -1;
        else if (o1.anyos > o2.getAnyos())
            comparacion = 1;
       
        return comparacion;
    }

  
}
