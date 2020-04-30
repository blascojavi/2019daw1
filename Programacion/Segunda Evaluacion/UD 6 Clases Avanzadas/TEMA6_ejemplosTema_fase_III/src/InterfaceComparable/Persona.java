
package InterfaceComparable;

public  class Persona implements Comparable<Persona>{
    private String nombre;
    private String apellido;
    private Integer anyos;
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

    @Override
    public String toString(){
        return this.nombre + "-" + this.anyos ;
    }
    
    public  String datos(){
        String msg;
        msg = " El nombre es: " + nombre;
        msg += " \n El apellido es: " + apellido;
        msg += " \n La edad es: " + anyos + "\n"; 
        
        return msg;
    }

    @Override
    public int compareTo(Persona o) {        
        int comparacion = 0;
        if (this.anyos < o.getAnyos())
            comparacion = -1;
        else if (this.anyos > o.getAnyos())
            comparacion = 1;
       
        return comparacion;        
//        OTRA FORMA
//        return  anyos.compareTo(o.anyos);
    }
}
