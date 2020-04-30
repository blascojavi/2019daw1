package Negocio;

public class FormatoFechaErroneo extends RuntimeException {

    public FormatoFechaErroneo(){
        super("ERROR");
    }

    public FormatoFechaErroneo(String msj){

        super("Error: " + msj);
    }

}
