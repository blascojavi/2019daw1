package EjercicioGuardarBBDD.MODEL;

public class Parque {

    private int id ;
    private String nombre ;
    private double extension ;
    private int idComunidad;

    public Parque(int id, String nombre, double extension, int idComunidad) {
        this.id = id;
        this.nombre = nombre;
        this.extension = extension;
        this.idComunidad = idComunidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getExtension() {
        return extension;
    }

    public void setExtension(double extension) {
        this.extension = extension;
    }

    public int getIdComunidad() {
        return idComunidad;
    }

    public void setIdComunidad(int idComunidad) {
        this.idComunidad = idComunidad;
    }
}
