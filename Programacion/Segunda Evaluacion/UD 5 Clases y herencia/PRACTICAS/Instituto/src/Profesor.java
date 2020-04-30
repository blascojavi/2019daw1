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
               totalHoras = totalHoras + asign.getHorasSemanales();
          }
     }

     private boolean noSuperaHorasSemamanales(Asignatura asign) {
          return ((super.totalHoras + asign.getHorasSemanales()) < MAX_HORAS_SEMANAL);

     }

     @Override
     public String toString() {
          String  dataProfesor = super.getNombre() + " Pertenece al departamento " + departamento + " e imparte las asignaturas : " + "\n";
          for (Asignatura asignaturaImpartida : asignaturas){
              dataProfesor = dataProfesor.concat(asignaturaImpartida.getNombre() + " , " );
          }

           dataProfesor = dataProfesor.concat(" (Total horas : " + super.totalHoras +"h )") ;
          return dataProfesor;
     }
}
