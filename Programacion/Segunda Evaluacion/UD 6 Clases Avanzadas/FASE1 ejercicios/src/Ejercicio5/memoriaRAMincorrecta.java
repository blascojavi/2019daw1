package Ejercicio5;

public class memoriaRAMincorrecta extends RuntimeException {
    public memoriaRAMincorrecta(){
        super("ERROR -> MEMORIA ram incorrecta");
    }

    public memoriaRAMincorrecta(int msj , int idOrdenador){
        super("Ordenador id = " + idOrdenador + " " + msj + "GB introducidos y se requieren valores de entre 2GB y 20GB");
    }

}
