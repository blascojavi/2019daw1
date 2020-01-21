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
        }
    }

    private boolean noSuperaHorasSemanales(Asignatura asig) {
        return (super.totalHorasMatriculado() + asig.getHorasSemanales() ) < MAX_HORAS_SEMANALES;
    }


    private  void groupNeverBeNull(String grupoNuevo){
        if(grupoNuevo == null ){
            this.grupo = "SINGRUPO";
        }
    }

    @Override
    public String toString() {
        return  "Nombre :  " + super.getNombre() + "\n" +
                "Grupo : " +  this.grupo  + "\n" +
                "Asignaturas : " + asignaturas +
                "Total horas : " + totalHorasMatriculado;
    }
}
