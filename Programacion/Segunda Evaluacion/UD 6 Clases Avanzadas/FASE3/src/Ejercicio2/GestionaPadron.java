package Ejercicio2;

import java.util.List;

public interface GestionaPadron {
    boolean darAlta(Persona p);
    List<Persona> buscar(boolean candidato);
    List<Persona> buscar(int edad);
    List<Persona> buscar(String pais);

}
