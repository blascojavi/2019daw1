package GestionBancariaAntonioFerrer;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Principal {
    private static final String MENU_ATRAS = "0" ;
    private static final String RESET_SELECTOR = "0" ;
    private static final String SALIR = "0";
    private static String respuesta = MENU_ATRAS;
    private static Banco banco = new Banco();
    private static String regExpTipoMovimineto = "^[TEI]$";

    public static void main(String[] args) {
        banco.datosInicio();
        System.out.println("GESTION BANCARIA\n");
        menuInicial();
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


    private static void subMenuSelector(CuentaBancaria cuenta) {
        do {
            try {
                respuesta = subMenuCuentaSeleccionada();
                switch (respuesta) {
                    case "1":
                        addTitular(cuenta);
                        break;
                    case "2":
                        deleteTitular(cuenta);
                        break;
                    case "3":
                        autorizarTitular(cuenta);
                        break;
                    case "4":
                        desautorizarTitular(cuenta);
                        break;
                    case "5":
                        ingresar(cuenta);
                        break;
                    case "6":
                        sacar(cuenta);
                        break;
                    case "7":
                        verInformacion(cuenta);
                        break;
                    case "8":
                        listarMovimientos(cuenta);
                        break;
                    case "0":
                        menuInicial();
                        break;
                    default:
                        System.out.println("Debe seleccionar un numero correcto");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR:   Debe introducir  un número");
                System.out.println();
            }
        } while (!respuesta.equals(MENU_ATRAS));
    }

    private static String mainMenu() {
        System.out.println("MENÚ PRINCIPAL \n\n");
        System.out.println("1. Listar Cuentas que superen cantidad límite.");
        System.out.println("2. Seleccionar una cuenta y operar.");
        System.out.println("0. SALIR.");
        return getScanner().nextLine();
    }

    public static String subMenuCuentaSeleccionada() {
        System.out.println("\n\n MENÚ DE OPARACIONES CON CUENTA \n\n");
        System.out.println("1. Añadir  nuevo titular.");
        System.out.println("2. Eliminar titular.");
        System.out.println("3. Autorizar usuario.");
        System.out.println("4. Desautorizar usuario.");
        System.out.println("5. Ingresar.");
        System.out.println("6. Sacar.");
        System.out.println("7. Ver información de la cuenta.");
        System.out.println("8. Listar movimientos.");
        System.out.println("0. Ir al menú principal\n"); //TODO: no devuelve al menu correcto , sale del programa
        respuesta = getScanner().nextLine();
        return respuesta;
    }

    private static void listarCuentas(Banco banco) {
        System.out.println("Establezca el saldo minimo que debe tener cada cuenta : ");
        double saldoMinimo = getScanner().nextDouble();
        System.out.println(banco.listarCuentas(saldoMinimo).toString());
    }


    private static void seleccionarCuentaYoperar(Banco banco) {
        System.out.println("LISTANDO CUENTAS PARA SELECCIONAR :" );
        listarCuentas(banco);
        System.out.println("indique el numero de la cuenta con la que operar : ");
       try {
          Long numCuenta = getScanner().nextLong();
          CuentaBancaria cuenta =  banco.getCuentas().get(numCuenta);
          respuesta = RESET_SELECTOR;
           subMenuSelector(cuenta);
       }catch (InputMismatchException e) {
           System.out.println("Seleccion incorrecta , revise los datos");
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

    private static void autorizarTitular(CuentaBancaria cuenta) {
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

    public static void desautorizarTitular(CuentaBancaria cuenta) {
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

    private static void listarMovimientos(CuentaBancaria cuenta) {
        boolean correctValue = false;
        char seleccion ;
        System.out.println("SELECCIONE EL TIPO DE MOVIMIENTO A LISTAR :" );
        System.out.println("T - Todos");
        System.out.println("E - Extracciones");
        System.out.println("I - Ingresos");
        do {
            String opcion = getScanner().next();
            correctValue = Pattern.matches(regExpTipoMovimineto, opcion)? true : false;
            seleccion = opcion.charAt(0);
        }while(correctValue = false);
        System.out.println(cuenta.listarMovimientos(Character.toUpperCase((seleccion))));
    }

    private static Scanner getScanner(){
        Scanner sc = new Scanner(System.in);
        return sc;
    }

}

