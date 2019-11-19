/*
Examen primera eval Antonio Ferrer 
 */
package examenantonioferrer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ExamenAntonioFerrer {


    public static void main(String[] args) {
        //Definicion de constantes de limite para random 
        final int VAL_MAX = 30000000;
        final int VAL_MIN = 15000000;
        //Variables empleadas
        int numGenerado ;
        int restoDni ; 
        String letraDNI;
        Scanner sc = new Scanner(System.in);
        String valorIntroducido ; 
        String regEx = "^[TRWAGMYFPDXBNJZSQVHLCKE]{1}$"; 
        boolean flag = false; 
       
        //Listados empleados 
        List<Integer> listaNumAleat = new ArrayList<>(); //Lista de num aleatorios entre valores
        List<String> tablaConv = new ArrayList<>(); //Lista con la tabla de equivalencias para letra
        List<String> dniConLetra = new ArrayList<>(); //Lista de Dni con su letra
        List<String> listaDniConM = new ArrayList<>(); //Lista de dnis con letra M 
        List<String> listaDniConZ = new ArrayList<>(); //Lista de dnis con letra Z
        List<String> listaConValorIntroducido = new ArrayList<>(); // Lista con los Dnis cuya letra coincida con la introducida 
        
        
        //CREANDO MAPA DE TABLA CONVERSIÓN NUMERO 
        tablaConv.add("T"); 
        tablaConv.add("R"); 
        tablaConv.add("W"); 
        tablaConv.add("A"); 
        tablaConv.add("G"); 
        tablaConv.add("M"); 
        tablaConv.add("Y"); 
        tablaConv.add("F"); 
        tablaConv.add("P"); 
        tablaConv.add("D"); 
        tablaConv.add("X"); 
        tablaConv.add("B"); 
        tablaConv.add("N"); 
        tablaConv.add("J"); 
        tablaConv.add("Z"); 
        tablaConv.add("S"); 
        tablaConv.add("Q"); 
        tablaConv.add("V"); 
        tablaConv.add("H"); 
        tablaConv.add("L"); 
        tablaConv.add("C"); 
        tablaConv.add("K"); 
        tablaConv.add("E"); 
        
        Random  numRand = new Random(); 
       
        
        for (int i = 1 ; i <= 100 ; i++){
           numGenerado = numRand.nextInt(VAL_MAX-VAL_MIN)+VAL_MIN;
           listaNumAleat.add(numGenerado);
        }
        
        for(int dni : listaNumAleat){
            restoDni = dni%23; 
            
           letraDNI = tablaConv.get(restoDni);
           dniConLetra.add(dni + "-" + letraDNI);// AÑADIMOS a lista general 
           
           //APARTADO A clasificar según si es M o Z 
           if (letraDNI.compareTo("M") == 0  ){
               
               // SI LA LETRA ES M almaceno en su lista 
               listaDniConM.add(dni + "-" + letraDNI);
           }if (letraDNI.compareTo("Z") == 0 ){
                            
               // SI LA LETRA ES Z almaceno en su lista 
               listaDniConZ.add(dni + "-" + letraDNI); 
           }
           
        }
        
        for(String dniCompleto : dniConLetra){
            System.out.println(dniCompleto);
        }
        
        // APARTADO B 
        do{ 
            System.out.println("Dime una letra  ");

            valorIntroducido = sc.next().toUpperCase(); 
            if (valorIntroducido.matches(regEx)){
                
                for(String dniX : dniConLetra  ){
                    if(dniX.contains(valorIntroducido)){
                        listaConValorIntroducido.add(dniX);
                    }
                   
                }
                System.out.println("Estos son los nif encontrados: " );
                
                for(String encontrado : listaConValorIntroducido){
                    System.out.print(encontrado + " ");
                }
                System.out.println("");
                System.out.println("TOTAL DNIs con la letra " + valorIntroducido + " : "  + listaConValorIntroducido.size());
                
                flag =  true; 
            }else{
                System.out.println("El valor no es correcto , intentelo de nuevo");
            }
        }while(flag == false);
       
        // APARTADO C
        dniConLetra.removeAll(listaConValorIntroducido);
        System.out.println("Tras eliminar los de la letra " + valorIntroducido + 
                " quedan: " + dniConLetra.size() );
        System.out.println("");        
    }
}
