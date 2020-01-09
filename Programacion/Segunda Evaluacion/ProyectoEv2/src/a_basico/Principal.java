package a_basico;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        String respuesta = "0";
        Persona titular = new Persona("33444666S", "Raquel Lopez");
        CuentaBancaria cuenta = new CuentaBancaria(123456789, titular);

        do {
            try {
                respuesta = menu();

                switch (respuesta) {
                    case "1": //INGRESAR DINERO
                        ingresar(cuenta);
                        break;
                    case "2": //SACAR DINERO
                        sacar(cuenta);
                        break;
                    case "3": //INFORMACION CUENTA
                        verInformacion(cuenta);
                        break;
                    case "4": //AUTORIZAR
                        autorizar(cuenta);
                        break;
                    case "5": // DESAUTORIZAR
                        desautorizar(cuenta);
                        break;
                    case "6": // NUEVO TITULAR
                        addTitular(cuenta);
                        break;
                    case "7": // NUEVO TITULAR
                        deleteTitular(cuenta);
                        break;
                    case "0":
                        System.out.println("Gracias por usar nuestra aplicacion");
                        break;
                    default:
                        System.out.println("Debe seleccionar un numero correcto");
                }

            } catch (InputMismatchException e) {
                System.out.println("ERROR:   Debe introducir  un número");
                System.out.println();
            }
        } while (!respuesta.equals("0"));
    }

    public static String menu() {
        String respuesta;
        System.out.println("GESTION DE CUENTA BANCARIA");
        System.out.println("1-Ingresar dinero.");
        System.out.println("2-Sacar dinero.");
        System.out.println("3- Informacion cuenta.");
        System.out.println("4-Autorizar una persona.");
        System.out.println("5-Desautorizar una persona.");
        System.out.println("6-Añadir nuevo titular.");
        System.out.println("7-Eliminar titular.");
        System.out.println("0-Salir\n");
    respuesta = getScanner().nextLine();

        return respuesta;
}

    public static void ingresar(CuentaBancaria cuenta) {
        double cantidad;
        System.out.println("Indique su NIF porfavor :");
        String nifRealiza = getScanner().nextLine();
        System.out.println("¿Cuánto dinero desea ingresar?");
        cantidad = getScanner().nextDouble();
        System.out.println("Descripción del movimiento: ");
        String descripcion = getScanner().nextLine();
        cuenta.ingresar(cantidad,nifRealiza,descripcion);
        System.out.println("Se ha ingresado: " + cantidad + "€ .Su saldo total es de: " + cuenta.getSaldo() + "€");
        System.out.println();
    }

    public static void sacar(CuentaBancaria cuenta) {
        double cantidad;
        System.out.println("Indique su NIF porfavor :");
        String nifRealiza = getScanner().nextLine();
        System.out.println("¿Cuánto dinero desea sacar?");
        cantidad = getScanner().nextDouble();
        System.out.println("Descripción del movimiento: ");
        String descripcion = getScanner().nextLine();
        if (cuenta.sacar(cantidad,nifRealiza,descripcion)) {
            System.out.println("Se ha sacado: " + cantidad + "€ .Su saldo total es de: " + cuenta.getSaldo() + "€");
        } else {
            System.out.println("No hay suficiente dinero en la cuenta para sacar " + cantidad + "€");
        }
        System.out.println();
    }

    public static void verInformacion(CuentaBancaria cuenta) {
        System.out.println("Aqui tiene la informacion solicitada");
        System.out.println(cuenta.informacionCuenta());
        System.out.println("");
    }

    public static void autorizar(CuentaBancaria cuenta) {
        String nif, nombre;
        System.out.println("Nif de la persona que desea autorizar: ");
        nif = getScanner().nextLine().toUpperCase();
        System.out.println("Nombre de la persona que desea autorizar: ");
        nombre = getScanner().nextLine();
        if (cuenta.autorizar(nif, nombre)) {
            System.out.println("Se ha autorizado a: " + nombre);
        } else {
            System.out.println("No se ha podido autorizar, ya que esa persona ya esta autorizada");
        }
        System.out.println();
    }

    public static void desautorizar(CuentaBancaria cuenta) {
        String nif;
        boolean desautorizado = false;
        System.out.println("Escriba el nif de la persona que desea desautorizar: ");
        nif = getScanner().nextLine().toUpperCase();
        desautorizado = cuenta.desautorizar(nif);
        if (desautorizado) {
            System.out.println("Se ha desautorizado al nif " + nif);
        } else {
            System.out.println("Error al desautorizar");
        }
    }

    private static void addTitular(CuentaBancaria cuenta) {
        System.out.println("Indica el Nif del nuevo titular : ");
        String nuevoTitularNif = getScanner().nextLine().toUpperCase();
        System.out.println("Indica el nombre del nuevo titular : ");
        String nuevoTitularNombre = getScanner().nextLine();

        Persona nuevoTitular = new Persona(nuevoTitularNif, nuevoTitularNombre);
        cuenta.addNuevoTitular(nuevoTitular);
    }

    private static void deleteTitular(CuentaBancaria cuenta) {
        System.out.println("Indique el NIF del titular a eliminar: ");
        System.out.println(cuenta.deleteTitular(getScanner().nextLine()));
    }

    private static Scanner getScanner() {
        Scanner scan = new Scanner(System.in);
        return scan;
    }

}
