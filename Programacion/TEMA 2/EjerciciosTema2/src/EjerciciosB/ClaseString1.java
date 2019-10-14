

package EjerciciosB;

import java.util.Scanner;

public class ClaseString1 {

    
    public static void main(String args[]){
        String valueCompare ;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Introduce una frase: ");
        String frase = scan.nextLine();
        
        System.out.println("Caracteres en total: " + frase.length());
        System.out.println("Cuetro primeros carácteres : " + frase.substring(0, 3));
        System.out.println("Introduce una frase: ");
        String frase2 = scan.nextLine();
        if (frase.equals(frase2)){
            valueCompare = "SON IGUALES"; 
        }else {
            valueCompare = "SON DIFERENTES"; 
        }
        System.out.println("Comparando con frase 2 : " + valueCompare);
        String frase3 = frase.concat(frase2);
        System.out.println("Uniendo frases: " + frase3);
        frase3 = frase3.replace("a", "X");
        System.out.println("Reemplazadas a por X : " + frase3);
        
        if (frase3.contains("pos")){
            System.out.println("La frase 3 SI CONTIENE POS");
        }else{
            System.out.println("La frase 3 NO CONTIENE POS");
        }
        
        if (frase3.charAt(0) == 'M'){
            System.out.println("COMIENZA POR M");
        }else{
            System.out.println("NO COMIENZA POR M");
        }
    }   

}
