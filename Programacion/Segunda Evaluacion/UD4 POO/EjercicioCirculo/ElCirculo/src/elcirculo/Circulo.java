/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elcirculo;

/**
 *
 * @author buceo
 */
public class Circulo {
    
    private double area ; 
    private double radio ;
    
    
    
    public double areaDeR10(){
        radio = 10 ; 
        
        area = Math.PI * (Math.pow(radio, 2));
        System.out.println(area);
        return area; 
    }
    
    
}
