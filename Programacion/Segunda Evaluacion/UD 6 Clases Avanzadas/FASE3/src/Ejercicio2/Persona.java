
package Ejercicio2;

public abstract class Persona {

    protected String nombre;
    protected String apellido;
    protected int anyos;
    private static int numPersonas = 0;

    public Persona() {
        numPersonas++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getAnyos() {
        return anyos;
    }

    public void setAnyos(int anyos) {
        this.anyos = anyos;
    }

    public static int getNumPersonas() {
        return numPersonas;
    }

    public  String datos(){
        String msg;
        msg = " El nombre es: " + nombre;
        msg += " \n El apellido es: " + apellido;
        msg += " \n La edad es: " + anyos + "\n"; 
        
        return msg;
    };
// fíjate no hay implementación
}
