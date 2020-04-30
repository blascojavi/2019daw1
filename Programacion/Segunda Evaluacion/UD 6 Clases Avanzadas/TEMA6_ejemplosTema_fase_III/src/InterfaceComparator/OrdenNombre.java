package InterfaceComparator;

import java.util.Comparator;

public class OrdenNombre implements Comparator<Persona> {

    @Override
    public int compare(Persona o1, Persona o2) {
        int comparacion = 0;
        if (o1.getNombre().compareTo(o2.getNombre()) < 0) {
            comparacion = -1;
        } else if (o1.getNombre().compareTo(o2.getNombre()) > 0) {
            comparacion = 1;
        }

        return comparacion;

    }
}
