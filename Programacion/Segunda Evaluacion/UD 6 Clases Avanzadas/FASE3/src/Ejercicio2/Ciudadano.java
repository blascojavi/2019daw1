package Ejercicio2;

public class Ciudadano extends Persona implements Votante {

    private String dni;
    private String ciudad;
    private boolean candidato;

    public String getdni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // MÉTODO DE LA INTERFAZ VOTANTE
    @Override
    public boolean isCandidato() {
        return candidato;
    }

    // MÉTODO DE LA INTERFAZ VOTANTE
    @Override
    public String getMesa() {
        String mesa;

        if (ciudad == null) {
            mesa = "Mesa no asignada";
        } else {
            if (ciudad.equals("Valencia")) {
                mesa = "Mesa 1";
            } else if (ciudad.equals("Alicante")) {
                mesa = "Mesa 2";
            } else {
                mesa = "Mesa 3";
            }
        }

        return mesa;
    }

    public void setCandidato(boolean candidato) {
        this.candidato = candidato;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    
    @Override
    public String datos() {
        String respuesta = super.datos();
        
        respuesta += "El DNI es" + dni;
        
        if (this.candidato) {
            respuesta += " El ciudadano es candidato";
        } else {
            respuesta += " El ciudadano no es candidato";
        }
        respuesta += " La mesa donde debe votar el ciudadano es " + this.getMesa();
        
        return respuesta;
    }
}
