/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coche;

import java.awt.BorderLayout;
import java.util.Scanner;

/**
 *
 * @author buceo
 */
public class Main {



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int count = 0 ; 
       String metal ; 
       Scanner scan = new Scanner(System.in); 
        System.out.println("Indiqueme la matricula : " );
        String matricula = scan.next(); 
        System.out.println("Indiqueme el modelo : " );
        String modelo = scan.next(); 

        Coche coche1 = new Coche(matricula , modelo); 
        
        System.out.println("Indiqueme el color del coche : " );
        coche1.setColor(scan.next()); 
        do{
           System.out.println("Su pintura es metalizada ");
           metal = scan.next();
  
            if (Integer.parseInt(metal) == 1 ){
                coche1.setMetalizada(true);
            }else{
                coche1.setMetalizada(false);
            }
        }
        while (metal.matches("^[1-2]$") ==  false );

        
        System.out.println("Que tipo de coche es : ");
        for(String tipo : coche1.getTipoCoche()){
            System.out.println(count + ". " + tipo);
            count++;
        }
        int tipoSeleccionado = scan.nextInt(); 
        coche1.setTipoCoche(tipoSeleccionado);
        
        System.out.println("Año de fabricación : ");
        coche1.setaFabricacion(scan.nextInt()); 
        count = 0 ;
        System.out.println("Que modalidad de seguro prefiere : ");
        for (String modalidad : coche1.getTipoSeguro()){
            System.out.println(count + " . " + modalidad);
            count++;
        }
        
        coche1.setTipoSeguro(scan.nextInt());
        
        

        System.out.println(coche1.verDatosBasicos());
        
       
    }
    
}
