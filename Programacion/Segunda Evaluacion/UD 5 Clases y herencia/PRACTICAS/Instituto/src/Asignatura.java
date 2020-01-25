public class Asignatura {

    private String codigo ;
    private String nombre ;
    private int horasSemanales;


    public Asignatura(String codigo , String nombre , Integer horasSemanales) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horasSemanales = horasSemanales;
    }

    public String getNombre( ) {
        return nombre;


    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
