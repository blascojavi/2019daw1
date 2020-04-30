package GestionBancariaAntonioFerrer;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;


public class Principal {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    private static final String MENU_ATRAS = "0" ;
    private static final String RESET_SELECTOR = "0" ;
    private static final String SALIR = "0";
    private static final CuentaBancaria NO_EXISTE = null ;
    private static String respuesta = MENU_ATRAS;
    private static final Banco banco = new Banco();
    public static void main(String[] args) {
        banco.datosInicio();
        System.out.println(ANSI_BLUE + "\n"+banco.getNombreBanco()+"\n" + ANSI_RESET);
        menuInicial();
    }

    private static String mainMenu() {
        System.out.println("\nMENÚ PRINCIPAL\n");
        System.out.println("1. Listar Cuentas con saldo superior a...");
        System.out.println("2. Gestionar una cuenta");
        System.out.println("0. SALIR");
        return getScanner().nextLine();
    }
    private static void menuInicial(){
        do {
            try {
                respuesta = mainMenu();
                switch(respuesta) {
                    case "1":
                        listarCuentas(banco);
                        break;
                    case "2":
                        seleccionarCuentaYoperar(banco);
                        break;
                    case "0":
                        respuesta = SALIR;
                        System.out.println("Gracias por usar nuestros servicios.");
                        break;
                }
            }catch (InputMismatchException e) {
                System.out.println("ERROR:Debe introducir un número");
                System.out.println();
            }
        }while(!respuesta.equals(MENU_ATRAS));
    }
    private static void listarCuentas(Banco banco) {
        System.out.println("Por favor indique la cantidad límite a buscar: ");
        double saldoMinimo = getScanner().nextDouble();
        System.out.println("Cuentas cuyo saldo supera "  + saldoMinimo + "€" );
        Set<CuentaBancaria> listado =  banco.listarCuentas(saldoMinimo);
        for (CuentaBancaria cuentaEncontrada : listado){
            System.out.println(cuentaEncontrada);
        }
    }
    private static void seleccionarCuentaYoperar(Banco banco) {
        System.out.println("Especifique la cuenta con la que desea realizar las operaciones: ");
        try {
            Long numCuenta = getScanner().nextLong();
            if(banco.localizarCuenta(numCuenta) != NO_EXISTE ){
                CuentaBancaria cuenta = banco.getCuentas().get(numCuenta);
                respuesta = RESET_SELECTOR;
                subMenuSelector(cuenta);
            }else{
                System.out.println(ANSI_RED + "La cuenta no existe" + ANSI_RESET);
            }
        }catch (InputMismatchException errorNotMatch) {
            System.out.println(ANSI_RED + "El valor introducido no se corresponde con un numero de cuenta válido" +  ANSI_RESET);
        }
    }
    public static String subMenuCuentaSeleccionada(CuentaBancaria cuenta) {
        System.out.println("\n\n OPERATIVA en cuenta "+ ANSI_BLUE + cuenta.getNumCuenta() + ANSI_RESET +"\n\n");
        System.out.println("1. Ingresar dinero");
        System.out.println("2. Sacar dinero.");
        System.out.println("3. Información cuenta.");
        System.out.println("4. Autorizar.");
        System.out.println("5. Desautorizar.");
        System.out.println("6. Poner titular.");
        System.out.println("7. Quitar titular.");
        System.out.println("8. Imprimir movimientos.");
        System.out.println("0. Menu principal\n");
        respuesta = getScanner().nextLine();
        return respuesta;
    }

    private static void subMenuSelector(CuentaBancaria cuenta) {
        do {
            try {
                respuesta = subMenuCuentaSeleccionada(cuenta);
                switch (respuesta) {
                    case "1":
                        ingresar(cuenta);
                        break;
                    case "2":
                        sacar(cuenta);
                        break;
                    case "3":
                        verInformacion(cuenta);
                        break;
                    case "4":
                        autorizarPersona(cuenta);
                        break;
                    case "5":
                        desautorizarPersona(cuenta);
                        break;
                    case "6":
                        addTitular(cuenta);
                        break;
                    case "7":
                        deleteTitular(cuenta);
                        break;
                    case "8":
                        imprimirMovimientos(cuenta);
                        break;
                    case "0":
                        menuInicial();
                        break;
                    default:
                        System.out.println(ANSI_RED + "Debe seleccionar un numero correcto" + ANSI_RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "ERROR: Debe introducir un número" + ANSI_RESET);
                System.out.println();
            }
        } while (!respuesta.equals(MENU_ATRAS));
    }
    public static void ingresar(CuentaBancaria cuenta) {
        double cantidad;
        System.out.println("Indique su NIF porfavor :");
        String nifRealiza = getScanner().nextLine();
        System.out.println("Indique el concepto: ");
        String descripcion = getScanner().nextLine();
        System.out.println("¿Cuánto dinero desea ingresar?");
        cantidad = getScanner().nextDouble();
        cuenta.ingresar(cantidad,nifRealiza,descripcion);
        System.out.println("Se ha ingresado: "+ANSI_GREEN + cantidad + "€" +ANSI_RESET+ " .Su saldo total es de: "
                            +ANSI_GREEN + cuenta.getSaldo() + "€"+ ANSI_RESET);
        System.out.println();
    }
    public static void sacar(CuentaBancaria cuenta) {
        double cantidad;
        System.out.println("Indique su NIF porfavor :");
        String nifRealiza = getScanner().nextLine();
        System.out.println("Descripción del movimiento: ");
        String descripcion = getScanner().nextLine();
        System.out.println("¿Cuánto dinero desea sacar?");
        cantidad = getScanner().nextDouble();
        if (cuenta.sacar(cantidad,nifRealiza,descripcion)) {
            System.out.println("Se ha sacado: " +ANSI_RED+ + cantidad+ "€" +ANSI_RESET+ " .Su saldo total es de: "
                    +ANSI_RED+ + cuenta.getSaldo() + "€" +ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "No hay suficiente dinero en la cuenta para sacar " + cantidad + "€" + ANSI_RESET);
        }
        System.out.println();
    }
    public static void verInformacion(CuentaBancaria cuenta) {
        System.out.println("Aqui tiene la informacion solicitada");
        System.out.println(cuenta.informacionCuenta());
        System.out.println();
    }
    private static void autorizarPersona(CuentaBancaria cuenta) {
        String nif, nombre;
        System.out.println("Nif de la persona que desea autorizar: ");
        nif = getScanner().nextLine().toUpperCase();
        System.out.println("Nombre de la persona que desea autorizar: ");
        nombre = getScanner().nextLine();
        if (cuenta.autorizar(nif, nombre)) {
            System.out.println("Se ha autorizado a: "+ ANSI_GREEN + nombre +ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "No se ha podido autorizar, ya que esa persona ya esta autorizada" + ANSI_RESET);
        }
        System.out.println();
    }
    public static void desautorizarPersona(CuentaBancaria cuenta) {
        String nif;
        boolean desautorizado;
        System.out.println("Escriba el nif de la persona que desea desautorizar: ");
        nif = getScanner().nextLine().toUpperCase();
        desautorizado = cuenta.desautorizar(nif);
        if (desautorizado) {
            System.out.println("Se ha desautorizado al nif " + ANSI_YELLOW + nif + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Error al desautorizar" + ANSI_RESET);
        }
    }
    private static void addTitular(CuentaBancaria cuenta) {
        System.out.println("Indica el Nif del nuevo titular : ");
        String nuevoTitularNif = getScanner().nextLine().toUpperCase();
        System.out.println("Indica el nombre del nuevo titular : ");
        String nuevoTitularNombre = getScanner().nextLine();
        Persona nuevoTitular = new Persona(nuevoTitularNif, nuevoTitularNombre);
        if(cuenta.addNuevoTitular(nuevoTitular)){
            System.out.println("Nuevo titular "+ ANSI_GREEN + nuevoTitularNombre + ANSI_RESET +" añadido");
        }else{
            System.out.println(ANSI_RED + "No ha podido añadirse el titular (posiblemente ya exista)." + ANSI_RESET);
        }
    }
    private static void deleteTitular(CuentaBancaria cuenta) {
        System.out.println("Indique el NIF del titular a eliminar: ");
        System.out.println(cuenta.deleteTitular(getScanner().nextLine().toUpperCase()));
    }
    private static void imprimirMovimientos(CuentaBancaria cuenta) {
        boolean correctValue = false;
        char seleccion ;
        System.out.println("SELECCIONE EL TIPO DE MOVIMIENTO A LISTAR :" );
        System.out.println("T - Todos");
        System.out.println("E - Extracciones");
        System.out.println("I - Ingresos");
        do {
            String opcion = getScanner().next();
            String regExpTipoMovimineto = "^[TEI]$";
            correctValue = Pattern.matches(regExpTipoMovimineto, opcion)? true : false;
            seleccion = opcion.charAt(0);
        }while(correctValue == true);
        System.out.println(cuenta.listarMovimientos(Character.toUpperCase((seleccion))));
        System.out.println("\n Saldo actual : " + cuenta.getSaldo());
    }


    private static Scanner getScanner(){
        return new Scanner(System.in);
    }

}

