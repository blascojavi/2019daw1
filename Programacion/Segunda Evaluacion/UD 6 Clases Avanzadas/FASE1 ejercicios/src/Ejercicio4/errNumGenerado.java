package Ejercicio4;

public class errNumGenerado extends RuntimeException {
    public errNumGenerado(){
        super("Número de escape generado");
    }

    public errNumGenerado(String msj){
        super("Han pasado " + msj + " ciclos para generar el número de escape");
    }
}
