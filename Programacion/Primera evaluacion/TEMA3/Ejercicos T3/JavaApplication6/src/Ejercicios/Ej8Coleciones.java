/*
. Almacena en un HashMap los códigos postales de las provincias de la Comunidad Valenciana y
Aragón.
    a. Muestra por pantalla los datos introducidos
    b. Pide un código postal y muestra la provincia asociada si existe sino avisa al usuario
    c. Elimina la provincia con código 8
    d. Elimina la provincia Castellón (no conoces el código). Haz un recorrido eficiente.
    e. Muestra por pantalla los datos 
 */
package Ejercicios;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Ej8Coleciones {


    public static void main(String[] args) {
        Map<String , String> cpcv = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        String select , substr ;
        String validadorCP = "^[0-4]?[2-6]{1}[0-9]{3}$";
        
        cpcv.put("46", "Valencia");
        cpcv.put("03", "Alicante");
        cpcv.put("12", "Castellon");
        cpcv.put("8", "Provincia Eliminar");

        /*a*/
        System.out.println("LISTA DE CODIGOS POSTALES");
        Iterator<String> it = cpcv.keySet().iterator(); //Creo iterador con las keys
        while(it.hasNext()){ //Mientras que exista siguiente clave en el iterador
            String code = it.next(); // capturo el codigo al que apunta y salto al siguiente
            System.out.println("- CP: " + code + " Provincia : " + cpcv.get(code));
        }
        
        /*b*/
        System.out.println("Introduce un código postal : ");
        select = scan.next();
        if (select.matches(validadorCP)){
            System.out.println("CODIGO POSTAL VÁLIDO , buscando...");
                substr = select.substring(0, 2);
                System.out.println("SUBSTRING " + substr);
            if (cpcv.containsKey(substr)){
                System.out.println("El CP " + select + " pertenece a la provincia : "
                + cpcv.get(substr));
            }{System.out.println("NO EXISTE ESE CP en la C55omunidad Valenciana");}
        }else {System.out.println("CP no valido");}
        
        /*c*/
        System.out.println("ELIMINANDO PROVINCIA CON CÓDIGO 8 ...");
        cpcv.remove("8");
        
        /*d*/
        System.out.println("ELIMINANDO PROVINCIA DE CASTELLON ...");
        
        
    }
    
}
