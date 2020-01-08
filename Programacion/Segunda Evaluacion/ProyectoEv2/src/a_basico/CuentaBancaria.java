package a_basico;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CuentaBancaria {

    private long numCuenta;
    private double saldo;
    private Set<Persona> autorizados = new HashSet<>();
    private Set<Persona> titulares = new HashSet<>();


    public CuentaBancaria(long ncuenta, Persona titularPrincipal) {
        this.numCuenta = ncuenta;
        this.titulares.add(titularPrincipal);
        this.saldo = 0;
    }

    public long getNumCuenta() {
        return numCuenta;
    }

    public Set<Persona> getTitular() {
        return titulares;
    }

    public void setTitular(Persona titular) {
        this.titulares.add(titular);
    }

    public double getSaldo() {
        return saldo;
    }

    public double ingresar(double cantidad) {
        if (cantidad >= 0) {
            saldo = saldo + cantidad;
        }
        return saldo;
    }

    public boolean sacar(double cantidad) {
        boolean resultado = false;
        if (cantidad <= saldo && cantidad >= 0) {
            saldo = saldo - cantidad;
            resultado = true;
        }
        return resultado;
    }



    public String informacionCuenta() {
        DecimalFormat f = new DecimalFormat("###,###.##");

        String resultado = "Nº cuenta: " + numCuenta + " - " + titulares+ " \n";
        if (!this.autorizados.isEmpty()) {
            resultado += "Personas autorizadas: " + autorizados + "\n";
        }
        resultado += "Saldo: " + f.format(saldo) + "€";
        return resultado;
    }

    public boolean autorizar(String dni, String nombre) {
        Persona autorizado = new Persona(dni, nombre);
        boolean resultado = false;

        if (autorizados.isEmpty()) {
            autorizados.add(autorizado);
            resultado = true;
        } else if (this.existe(dni) == null) {
            autorizados.add(autorizado);
            resultado = true;
        }
        return resultado;
    }

    public boolean desautorizar(String dni) {
        boolean desautorizado = false;
        Persona p = existe(dni);

        if (p != null) {
            autorizados.remove(p);
            desautorizado = true;
        }
        return desautorizado;
    }

    public boolean addNuevoTitular(Persona nuevoTitular){
        if(esTitular(nuevoTitular.getNif())){
            titulares.add(nuevoTitular);
            return true;
        }else{
            return false;
        }
    }

    public boolean esTitular(String nif) { //TODO: preg¡untar porque devolver Persona y no  boolean
        boolean existe = false;
        for (Persona titular : titulares){
           existe = (titular.getNif().equals(nif)) ? true : false;
        }
        return existe;
    }

    public Persona existe(String dni) {
        Persona person = null;
        Persona encontrado = null;
        Iterator<Persona> it = this.autorizados.iterator();

        while (it.hasNext() && encontrado == null) {
            person = it.next();
            if (person.igual(dni)) {
                encontrado = person;
            }
        }

        return encontrado;
    }

}
