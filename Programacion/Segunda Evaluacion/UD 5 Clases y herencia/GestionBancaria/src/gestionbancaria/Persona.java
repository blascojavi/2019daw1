

package gestionbancaria;


public class Persona {

    private String nif; 
    private String nombre; 
    
    public  Persona (String nif , String nombre){
        this.nif = nif ; 
        this.nombre = nombre ; 
        
    }

    public void setNif (String nif){
        this.nif = nif; 
    }
    public String getNif (){
        return this.nif; 
    }
    
    public String getNombre (){
        return this.nombre; 
    }
    // ends setters and getters 
    
    @Override
    public String toString(){
        return "Nombre : " + this.nombre + " NIF: " + this.nif;
     }
    
    public boolean igual(Persona person){
        if (this.nif == person.getNif()){
            return true;
        }
        return false; 
    }
    
    public boolean igual(String nif){
        if (this.nif.equals(nif)){
            return true; 
        }
        return false; 
    }


}
