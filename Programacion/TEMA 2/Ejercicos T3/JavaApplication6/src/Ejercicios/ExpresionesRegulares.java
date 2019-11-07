/*
EXPRESIONES REGULKARES
 */
package Ejercicios;

/**
 *
 * @author buceo
 */
public class ExpresionesRegulares {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*1. VALIDAR EMAIL QUE PERMITA _ EN USUARIO */
        
        String email = "ana_lopez@gmail.com";
        
        if (email.matches("^[A-Za-z0-9\\-\\_\\.]+@[A-Za-z0-9\\-\\.]+.[A-z]{2,}$")){
            System.out.println("VALIDO EMAIL");
        }else{
            System.out.println("invalido EMAIL");
        }
        
        /*2. CODIGOS POSTALES DE VALENCIA*/
        String cp = "46970";
        
        if (cp.matches("^46[0-9]{3}$")){
            System.out.println("VALIDO CP");
        }else{
            System.out.println("invalido CP");
        }
        
        /*Permitir que un telefono tengoa o no () en dos primeras cifras*/
        String telf = "(96)1234567";
        
        if (telf.matches("^\\(?[0-9]{2}\\)?[0-9]{7}$")){
            System.out.println("VALIDO TELF");
        }else{
            System.out.println("invalido TELF");
        }
        
        /* Validar fecha con 2 o 4 digitos en año y meses en numeros o letras*/
        
        String fecha = "20/12/20";
        
        if (fecha.matches("^(0[1-9]|[1-2][0-9]|3[0-1])\\/([0-9]{1,2}|[a-zA-Z]{4,})\\/\\d{2,4}$")){
            System.out.println("VALIDA FECHA");
        }else{
            System.out.println("invalida FECHA");
        }
    }   
    
    
}
