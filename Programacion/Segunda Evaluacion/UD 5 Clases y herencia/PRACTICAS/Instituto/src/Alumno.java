public class Alumno extends Persona {
    private static final int MAX_HORAS_SEMANALES = 30 ;
    private String grupo = "SINGRUPO" ;

    public Alumno(String nombre, String direccion, int anyo_nacimiento, String grupo) {
        super(nombre, direccion, anyo_nacimiento);
        groupNeverBeNull(this.grupo = grupo);
    }

    public String getGrupo() {
        return grupo;
    }

    public void matricular(Asignatura asig){
        if(noSuperaHorasSemanales(asig)){
            super.getAsignaturas().add(asig);
            totalHoras += asig.getHorasSemanales();
        }
    }

    private boolean noSuperaHorasSemanales(Asignatura asig) {
        return (super.totalHoras + asig.getHorasSemanales() ) < MAX_HORAS_SEMANALES;
    }


    private  void groupNeverBeNull(String grupoNuevo){
        if(grupoNuevo == null ){
            this.grupo = "SINGRUPO";
        }
    }

    private int numAsignaturasMatriculado(){
        return asignaturas.size();
    }

    @Override
    public String toString() {
        String dataAlumno = "ALUMNO ->  " + getNombre() + " está matriculado en " + getGrupo() + " de " +  numAsignaturasMatriculado() +
                " asignaturas (total horas " + super.totalHoras + "h )";
        return  dataAlumno;
    }
}
