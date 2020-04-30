package InterfaceComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PruebaInterfaz {

    public static void main(String[] args) {
        List<Persona> lista = new ArrayList<>();

        Persona p1 = new Persona();
        p1.setNombre("Paco");
        p1.setApellido("Smith");
        p1.setAnyos(60);
        System.out.println(p1.datos());

        Persona p2 = new Persona();
        p2.setNombre("Raquel");
        p2.setApellido("Suarez");
        p2.setAnyos(30);
        System.out.println(p2.datos());

        Persona p3 = new Persona();
        p3.setNombre("Brad");
        p3.setApellido("Pit");
        p3.setAnyos(45);
        System.out.println(p3.datos());

        Persona p4 = new Persona();
        p4.setNombre("Pedro");
        p4.setApellido("Sanchez");
        p4.setAnyos(50);
        System.out.println(p4.datos());

        System.out.println("");
        System.out.println("El número total de personas es: " + InterfaceComparator.Persona.getNumPersonas());

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);

        System.out.println(lista);

        Collections.sort(lista);
        System.out.println("Orden ascendente por años: " + lista);

    }

}
