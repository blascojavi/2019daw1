import java.util.ArrayList;
import java.util.List;

public class Persona {

    private static final int ZERO_HOURS = 0;

    private String nombre ;
    private String direccion;
    private int anyo_nacimiento;
    protected List<Asignatura> asignaturas = new ArrayList<>();
    protected int totalHorasMatriculado = ZERO_HOURS;
    protected int totalHorasImparte = ZERO_HOURS;

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }


    public Persona() {
    }

    public Persona(String nombre, String direccion, int anyo_nacimiento) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.anyo_nacimiento = anyo_nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getAnyo_nacimiento() {
        return anyo_nacimiento;
    }


    protected int totalHorasMatriculado() {
        for (Asignatura asignatura : asignaturas){
            totalHorasMatriculado += asignatura.getHorasSemanales();
        }
      return totalHorasMatriculado;
    }

    protected int totalHorasImparte() {
        for (Asignatura asignatura : asignaturas){
            totalHorasImparte += asignatura.getHorasSemanales();
        }
        return totalHorasImparte;
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
