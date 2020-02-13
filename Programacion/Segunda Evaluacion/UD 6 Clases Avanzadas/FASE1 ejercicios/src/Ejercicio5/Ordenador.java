package Ejercicio5;

public class Ordenador {
    private String nombre ;
    private String so;
    private String tipoProcesador ;
    private int ram ;
    private static int numOrdenadorCreado = 0 ;
    private int idOrdenador ;

    public Ordenador (String nombre , String so , String tipoProcesador , int ram ){
        if(ram < 2 || ram  > 20 ){
            throw new memoriaRAMincorrecta(ram , getIdOrdenador());
        }

        this.idOrdenador = numOrdenadorCreado;
        numOrdenadorCreado++;
    }

    public int numeroOrdenador(){
        return numOrdenadorCreado;
    }

    public int getIdOrdenador() {
        return idOrdenador;
    }

    public void cambiarRam(int ram) {
        if(ram >= 2 || ram <=  20 ){
            this.ram = ram;
        }
        throw new memoriaRAMincorrecta(ram , this.getIdOrdenador());
    }
}
