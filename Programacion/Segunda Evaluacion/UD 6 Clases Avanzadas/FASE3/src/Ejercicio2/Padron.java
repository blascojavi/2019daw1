package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Padron implements GestionaPadron {

    public List<Persona> getEmpadronados() {
        return empadronados;
    }

    private  List<Persona> empadronados = new ArrayList<>();

    @Override
    public boolean darAlta(Persona p) {
        boolean addOk = false;
        if(!estaEnLaLista(p)){
            this.empadronados.add(p);
            addOk = true;
        }
        return addOk;
    }

    private boolean estaEnLaLista(Persona p) {
        boolean siEsta = false ;
        for(Persona persona : empadronados){
            if(persona.nombre.equals(p.nombre) && persona.apellido.equals(p.apellido)){
                siEsta = true;
            }
        }
        return siEsta;
    }

    @Override
    public List<Persona> buscar(boolean candidato) {
        List<Persona> listaCandadatos = new ArrayList<>();
        Ciudadano ciudadano = null ;

        for(Persona persona : empadronados){
            if(persona instanceof Ciudadano ){
                ciudadano = (Ciudadano) persona;
                if(ciudadano.isCandidato()){
                    listaCandadatos.add(ciudadano);
                }
            }
        }
        return listaCandadatos;
    }

    @Override
    public List<Persona> buscar(int edad) {
        List<Persona> personasconEdadX = new ArrayList<>();
        for(Persona persona : empadronados){
            if(persona.getAnyos() == edad){
                personasconEdadX.add(persona);
            }
        }
        return personasconEdadX;
    }

    @Override
    public List<Persona> buscar(String pais) {
        List<Persona> personasEnCiudad = new ArrayList<>();
        Ciudadano ciudadano = null ;
        for(Persona persona : empadronados){
            try{
                if(persona instanceof Ciudadano) {
                    ciudadano = (Ciudadano) persona;
                    if(ciudadano.getCiudad() == null ){
                        throw new NoCitySpecifiedException();
                    }
                    if (ciudadano.getCiudad().equalsIgnoreCase(pais)) {
                        personasEnCiudad.add(persona);
                    }
                }
            }catch(NoCitySpecifiedException e){
                System.out.println(e);
            }

        }
        return personasEnCiudad;
    }


    public String formatearListado(List<Persona> lista){
        Ciudadano ciudadano ;
        String listaFormateada = "";
        for(Persona personaEnLista : lista){
            if(personaEnLista instanceof Ciudadano){
                listaFormateada += personaEnLista.nombre.concat(" ").concat(personaEnLista.apellido).concat( " \n");
            }

        }
        return listaFormateada;
    }
}
