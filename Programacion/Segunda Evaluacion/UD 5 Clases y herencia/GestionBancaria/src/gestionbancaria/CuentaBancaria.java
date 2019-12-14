

package gestionbancaria;

import java.util.HashSet;
import java.util.Set;


public class CuentaBancaria {
    private long numCuenta;
    private Persona titular; 
    private Set<Persona> autorizados = new HashSet<>();
    private double saldo; 
    
    private final double CANTIDAD_CERO = 0.0; 
    
    public CuentaBancaria(long nCuenta , Persona titular ){
        this.numCuenta = nCuenta; 
        this.titular = titular;
        this.saldo = saldo; 
    }
    
    //No se permite modificar el numero de cuenta ni el titular: 
    public long getNumCuenta(){
        return this.numCuenta;
    }
    public Persona getTitular(){
        return this.titular; 
    }
    public Set<Persona> getAutorizados(){
        return autorizados; 
    }
    
    public Double getSaldo(){
        return this.saldo; 
    }
   
       
    public boolean autorizar (Persona autorizado){
        return autorizados.add(autorizado); 
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
                +"Numero de cuenta :" + this.numCuenta  + " - " + this.titular + "\n" ;
        
        if (this.autorizados.size() > 0 ){
          datosTitular =  datosTitular.concat("AUTORIZADOS:\n" + this.autorizados.toString());
        }
        return datosTitular.concat("\nSu saldo actual es de : " + this.saldo + "€ \n");
        
    }
}
