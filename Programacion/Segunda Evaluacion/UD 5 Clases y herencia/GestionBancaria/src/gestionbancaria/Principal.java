
package gestionbancaria;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Principal {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String respuesta = "0";
        Set<Persona> titulares = new HashSet<>();
        Persona titularPrincipal = new Persona("33444666S", "Antonio Ferrer");
        titulares.add(titularPrincipal);
        Persona autorizado = new Persona("444444g" , "Pepe sancho");
        CuentaBancaria cuenta = new CuentaBancaria(123456789, titulares);

        do {
            respuesta = menu();
            switch (respuesta) {
                case "1": //INGRESAR DINERO
                    System.out.println("ACCION INGRESAR");
                    ingresar(cuenta);
                   break;
                case "0":
                    System.out.println("Gracias por usar nuestra aplicacion");
                    break;
                case "2": 
                    sacar(cuenta);
                    break;
                case "3": 
                    verInformacion(cuenta);
                     break;  
                case "4": 
                    autorizar(cuenta);
                     break;
                case "5": 
                    desautorizar(cuenta);
                     break;
                case "6":
                    nuevoTitular(cuenta);
                    break;
                case "7":
                    eliminaTitular(cuenta);
                    break;
                default:
                    System.out.println("Debe seleccionar un numero correcto");
            }
        } while (!respuesta.equals("0"));
    }
    public static String menu() {
        String respuesta;
        System.out.println("\n\n");
        System.out.println("----------------------------");
        System.out.println("-GESTION DE CUENTA BANCARIA-");
        System.out.println("----------------------------");
        System.out.println("1-Ingresar dinero.");
        System.out.println("2-Sacar dinero.");
        System.out.println("3-Informacion de la cuenta.");
        System.out.println("4-Autorizar.");
        System.out.println("5-Desautorizar.");
        System.out.println("6-Nuevo titular.");
        System.out.println("7-Eliminar titular.");
        System.out.println("0-Salir\n");
        respuesta = sc.nextLine();
        return respuesta;
    }
    
    public static void ingresar(CuentaBancaria cuenta){
        System.out.println("Actualmente su saldo es de : " + cuenta.getSaldo());
        System.out.println("CUENTO DINERO DESEA INGRESAR EN SU CUENTA : ");
        try {
            double cantidad = sc.nextDouble();
            cuenta.ingresar(cantidad);
            System.out.println("Su saldo actual es de : " + cuenta.getSaldo());
            sc.nextLine();
        }catch(InputMismatchException e){
            
            System.out.println("El dato introducido no es correcto.");
        }
    }
    
    public static void sacar(CuentaBancaria cuenta){
        System.out.println("Actualmente dispone de un saldo de : " + cuenta.getSaldo());
        System.out.println("cuento desea sacar : ");
        
        try {
            double cantidad = sc.nextDouble(); 
            if(cuenta.sacar(cantidad)){
                System.out.println("Su saldo actual es de :" + cuenta.getSaldo());
            }else{
                System.out.println("No dispone de suficiente saldo para sacar : "
                + cantidad + "€");
                
            } 
            sc.nextLine();
            
        } catch(InputMismatchException e) {
            System.out.println("DATOS INCORRECTOS , intentelo de nuevo");
        }
    }
    
    public static void verInformacion(CuentaBancaria cuenta){
        System.out.println( cuenta.informacionCuenta());

    }
    
    public static void autorizar( CuentaBancaria cuenta){

        System.out.println("Nif de la persona a autorizar : ");
        String nif = sc.nextLine();
        System.out.println("nombre de la persona a autorizar: ");
        String nombre = sc.nextLine();

        Persona nuevoAutorizado = new Persona(nif , nombre);

        if (cuenta.autorizar(nuevoAutorizado)){
            System.out.println(nuevoAutorizado.getNombre() + " Ha sido autorizado con exito.");
        }else{
            System.out.println(nuevoAutorizado.getNombre() + " No ha podido ser autorizado , revise los datos");
        }

    }

    public static void desautorizar(CuentaBancaria cuenta){

        System.out.println("NIF de la persona a DESAUTORIZAR: ");
        String nif = sc.nextLine();

        if(cuenta.desautorizar(nif)){
            System.out.println("ha sido desautorizada");
        }else{
            System.out.println("No se ha podido proceder a la desautorización");
        }

    }

    public static void nuevoTitular(CuentaBancaria cuenta){
        System.out.println("Introduza el NIF del nuevo titular : ");
        String nif = sc.nextLine();
        System.out.println("Introduza el NOMBRE del nuevo titular : ");
        String nombre = sc.nextLine();

        Persona nuevoTitular = new Persona(nif , nombre);
        cuenta.nuevoTitular(nuevoTitular);
    }

    public static void eliminaTitular(CuentaBancaria cuenta){
        System.out.println("Introduzca el nif del titular a eliminar :  ");
        String nif = sc.nextLine();

        System.out.println(cuenta.eliminarTitular(nif));
    }
    
}