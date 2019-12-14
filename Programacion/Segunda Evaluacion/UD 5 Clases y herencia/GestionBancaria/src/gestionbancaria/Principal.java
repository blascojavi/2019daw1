
package gestionbancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String respuesta = "0";
        Persona titular = new Persona("33444666S", "Raquel Lopez");
        Persona autorizado = new Persona("24378964K" , "Antonio Ferrer"); 
        CuentaBancaria cuenta = new CuentaBancaria(123456789, titular);
        cuenta.autorizar(autorizado);
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
    
    
    
}