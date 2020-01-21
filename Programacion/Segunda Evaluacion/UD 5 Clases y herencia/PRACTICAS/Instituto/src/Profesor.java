import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persona {
     private static final int MAX_HORAS_SEMANAL = 15 ;
     private String departamento ;
     private int anyoIncorporacion;

     public Profesor(String nombre, String direccion, int anyo_nacimiento, String departamento, int anyoIncorporacion) {
          super(nombre, direccion, anyo_nacimiento);
          this.departamento = departamento;
          this.anyoIncorporacion = anyoIncorporacion;
     }

     public void impartir(Asignatura asign){
          if(noSuperaHorasSemamanales(asign)){
               super.asignaturas.add(asign);
          }
     }

     private boolean noSuperaHorasSemamanales(Asignatura asign) {
          return super.totalHorasImparte() + asign.getHorasSemanales() < MAX_HORAS_SEMANAL;
     }

     @Override
     public String toString() {
          return super.getNombre() + " Pertenece al departamento " + departamento + " e imparte las asignaturas : " + "\n"
           + asignaturas + " (Total horas : " + super.totalHorasImparte()+"h )" ;
     }
}
