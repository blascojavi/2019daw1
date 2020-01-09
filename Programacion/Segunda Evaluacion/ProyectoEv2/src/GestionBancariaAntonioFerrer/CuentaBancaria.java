package GestionBancariaAntonioFerrer;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



public class CuentaBancaria {

    public static final int MINIMO_NUM_TITULARES = 1;
    public static final Persona NO_EXISTE = null;
    private long numCuenta;
    private double saldo;
    private Set<Persona> autorizados = new HashSet<>();
    private Set<Persona> titulares = new HashSet<>();
    private List<Movimiento> movimientos = new ArrayList<Movimiento>();


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


    public boolean ingresar(double cantidad , String nifRealiza, String descripcion) {
        boolean ingresadoOk = false;
        if (cantidad >= 0) {
           Movimiento ingreso = new Movimiento(nifRealiza , cantidad , descripcion);
           movimientos.add(ingreso);
           saldo = saldo + cantidad;
           ingresadoOk = true;
        }
        return ingresadoOk;
    }

    public boolean sacar(double cantidad , String nifRealiza, String descripcion) {
        boolean extraidoOk = false;
        if (cantidad <= saldo && cantidad >= 0) {

            Movimiento extraccion = new Movimiento(nifRealiza , (cantidad)*-1 , descripcion);
            movimientos.add(extraccion);
            saldo = saldo - cantidad;
            extraidoOk = true;
        }
        return extraidoOk;
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
        if(esTitular(nuevoTitular.getNif()) == NO_EXISTE){
            titulares.add(nuevoTitular);
            System.out.println("Nuevo titular añadido");
            return true;
        }else{
            System.out.println("No ha podido añadirse el titular (posiblemente ya exista).");
            return false;
        }
    }
    public String deleteTitular(String nif){
        Persona titularAeliminar = esTitular(nif);
        if(titularAeliminar != NO_EXISTE ){
            if(titulares.size() > MINIMO_NUM_TITULARES){
                titulares.remove(titularAeliminar);
                return "Se ha ELIMINADO el titular con el nif " + nif;
            }else{
                return "No se puede eliminar el único titular de la cuenta";
            }
        }else{
            return "no se ha encontrado el titular con el NIF : " + nif ;
        }
    }

    public String listarMovimientos(char tipo){
        String movimientosEncontrados = "";
        switch (Character.toUpperCase(tipo)){
            case 'T':
                movimientosEncontrados = movimientos.toString();
                break;
            case 'E':
                List<Movimiento> extracciones = new ArrayList<>();
                for(Movimiento movimiento : movimientos){
                    if(movimiento.getCantidad() < 0 ){
                        extracciones.add(movimiento);
                    }
                    movimientosEncontrados = extracciones.toString();
                }
                break;
            case 'I':
                List<Movimiento> ingresos = new ArrayList<Movimiento>();
                for(Movimiento movimiento : movimientos){
                    if(movimiento.getCantidad() >= 0 ){
                        ingresos.add(movimiento);
                    }
                    movimientosEncontrados = ingresos.toString();
                }
                break;
            default:
                movimientosEncontrados = "NO EXISTE ESA OPCIÓN";
        }
        return movimientosEncontrados;
    }

    public Persona esTitular(String nif) {
        Persona existeTitular = NO_EXISTE;
        for (Persona titular : titulares){
           if(titular.getNif().equals(nif)){
               existeTitular = titular;
           }
        }
        return existeTitular;
    }
    public Persona existe(String nif) {
        Persona personaAbuscar = NO_EXISTE;
        Persona encontrado = NO_EXISTE;
        Iterator<Persona> it = this.autorizados.iterator();
        while (it.hasNext() && encontrado == null) {
            personaAbuscar = it.next();
            if (personaAbuscar.igual(nif)) {
                encontrado = personaAbuscar;
            }
        }
        return encontrado;
    }

    @Override
    public String toString() {
        return "Numero de cuenta : " + numCuenta +
                "Saldo actual: " + saldo +
                '\n';
    }
}
