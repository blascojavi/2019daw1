package Ejercicio3;



public class BilleteTren {
    private int INCREMENTO_TURISTA = 0;
    private int INCREMENTO_SUPERIOR = 15;
    private int INCREMENTO_LUJO = 25;
    private int INCREMENTO_CON_MASCOTA = 7;


    private String origen;
    private String destino;
    private double precioBase ;
    private tiposBillete tipo;

    public BilleteTren(String origen, String destino, tiposBillete tipo) {
        this.origen = origen;
        this.destino = destino;
        this.precioBase = precioBase;
        this.tipo = tipo;
    }

    public double aPagar(){
        double totalApagar = 0 ;

        switch (this.tipo){
            case TURISTA :
                totalApagar = this.precioBase+(this.precioBase*INCREMENTO_TURISTA)/100;
                break;

            case SUPERIOR:
                totalApagar = this.precioBase+(this.precioBase*INCREMENTO_SUPERIOR)/100;
                break;

            case LUJO:
                totalApagar = this.precioBase+(this.precioBase*INCREMENTO_LUJO)/100;
                break;
        }

        return totalApagar;
    }

    public double aPagar(int descuento){
        double totalApagar = 0 ;
        totalApagar = this.precioBase-(this.precioBase*descuento)/100;

        return totalApagar;
    }

    public double aPagar(boolean mascota){
        double totalApagar = 0 ;

        if(mascota){
            totalApagar = this.precioBase+(this.precioBase*INCREMENTO_CON_MASCOTA)/100;
        }
        return totalApagar;
    }


    @Override
    public String
    toString() {
        return "BilleteTren{" +
                "origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", precioBase=" + precioBase +
                ", tipo=" + tipo +
                '}';
    }
}
