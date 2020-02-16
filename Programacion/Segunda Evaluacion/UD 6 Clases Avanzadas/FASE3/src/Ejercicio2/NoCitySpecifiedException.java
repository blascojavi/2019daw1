package Ejercicio2;

public class NoCitySpecifiedException extends RuntimeException {

    public NoCitySpecifiedException(){
        super("Ha ocurrido un error");
    }

    public NoCitySpecifiedException(String msjError){
        super("ERROR: " + msjError + " Ciudad no especificada.");
    }

}
