package Ejerccicio1;

public class FueraDeRango extends RuntimeException{

    public FueraDeRango(){
        super("Error ");
    }
    public FueraDeRango(String mensaje){
        super(mensaje);

    }

}
