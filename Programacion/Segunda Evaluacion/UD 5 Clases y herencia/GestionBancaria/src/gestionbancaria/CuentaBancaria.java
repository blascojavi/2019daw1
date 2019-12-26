

package gestionbancaria;

import java.util.HashSet;
import java.util.Set;


public class CuentaBancaria {
    private long numCuenta;
    private Set<Persona> titulares = new HashSet<>();
    private Set<Persona> autorizados = new HashSet<>();
    private double saldo;
    private final String TITULAR_NO_ENCONTRADO = "NO SE HA ENCONTRADO NINGÚN TITULAR CON EL NIF ";
    private final String TITULAR_A_CERO = "LA CUENTA NO PUEDE QUEDARSE SIN TITULARES";
    private final String TITULAR_ELIMINADO = "SE HA ELIMINADO DE LA LISTA DE TITULARES ";
    
    private final double CANTIDAD_CERO = 0.0; 
    
    public CuentaBancaria(long nCuenta , Set<Persona> titulares ){
        this.numCuenta = nCuenta; 
        this.titulares = titulares;
        this.saldo = saldo; 
    }
    
    //No se permite modificar el numero de cuenta ni el titular: 
    public long getNumCuenta(){
        return this.numCuenta;
    }
    public Set<Persona> getTitular(){
        return this.titulares;
    }
    public Set<Persona> getAutorizados(){
        return autorizados; 
    }
    
    public Double getSaldo(){
        return this.saldo; 
    }
   
       
    public boolean autorizar(Persona autorizado){
        if (this.existe(autorizado.getNif()) != null ){
            return false; 
        }
        autorizados.add(autorizado); 
        return true; 
    }

    public boolean nuevoTitular(Persona nuevoTitular){
        if(esTitular(nuevoTitular.getNif())== null){
            titulares.add(nuevoTitular);
            System.out.println("Se ha incluido un nuevo titular " + nuevoTitular.getNombre());
            return true;
        }else{

            System.out.println(nuevoTitular.getNombre() + "Ya es un titular autorizado ");
            return false;
        }

    }

    public String eliminarTitular(String nif){

        if(titulares.size() == 1) {
            return TITULAR_A_CERO;
        }

        for (Persona titular : titulares){
            if(titular.getNif().equals(nif)){
                titulares.remove(titular);
                return titular + TITULAR_ELIMINADO;
            }else{
                return TITULAR_NO_ENCONTRADO + nif;
            }

        }
        return null ;

    }


    public boolean desautorizar(String nif){
        if(this.existe(nif) !=null ){
            autorizados.remove(nif);
            return true;
        }
        return false; 
    }
    
    public double ingresar(double cantidad){
        
        if (cantidad >= CANTIDAD_CERO ){
          this.saldo += cantidad; 
         return this.saldo;       
        }
        return this.saldo;
    }
    
    public boolean sacar(double cantidad){
        if(this.saldo > cantidad ){
            if (cantidad >= CANTIDAD_CERO){
                this.saldo -= cantidad; 
                return true; 
            }     
        }
        return false; 
    }
    
    public String informacionCuenta(){
        
        String datosTitular =  "Aqui tiene los datos solicitados : \n"
                +"Numero de cuenta :" + this.numCuenta  + " - " + this.titulares + "\n" ;
        
        if (this.autorizados.size() > 0 ){
          datosTitular =  datosTitular.concat("AUTORIZADOS:\n" + this.autorizados.toString());
        }
        return datosTitular.concat("\nSu saldo actual es de : " + this.saldo + "€ \n");
        
    }
    
    public Persona existe(String nif) {
        for(Persona autorizado : this.autorizados ){
            if (autorizado.igual(nif)){
                return autorizado;
            }
        }
           return null;   
    }

    public Persona esTitular(String nif){
            for(Persona titular : titulares){
                if(titular.getNif().equals(nif)){
                    return titular;
                }
            }
        return null;
    }
        
      
}
