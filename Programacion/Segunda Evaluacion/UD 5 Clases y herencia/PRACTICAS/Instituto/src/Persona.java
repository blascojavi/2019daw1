import java.util.ArrayList;
import java.util.List;

public class Persona {

    private static final int ZERO_HOURS = 0;

    private String nombre ;
    private String direccion;
    private int anyo_nacimiento;
    protected List<Asignatura> asignaturas = new ArrayList<>();
    protected int totalHoras = ZERO_HOURS;


    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public Persona(String nombre, String direccion, int anyo_nacimiento) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.anyo_nacimiento = anyo_nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    protected void totalHoras() {
        for (Asignatura asignatura : asignaturas){
            totalHoras += asignatura.getHorasSemanales();
        }
    }



    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", anyo_nacimiento=" + anyo_nacimiento +
                '}';
    }

    public void setAsignaturas(Asignatura asign) {
        asignaturas.add(asign);
    }
}
