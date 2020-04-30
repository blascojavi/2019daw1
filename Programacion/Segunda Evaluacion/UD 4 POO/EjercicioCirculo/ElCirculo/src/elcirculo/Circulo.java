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
    


  
    public double area(double radio){
        
        double area = Math.PI * (Math.pow(radio, 2));
        
        return area; 
    
    }
    public double diametro(double radio){
        double diametro = 2 * radio ; 
        
        return diametro; 
    }
    
    public double perimetro(double radio){
        double perimetro = 2 * Math.PI * radio; 
        
        return perimetro; 
    }
    
    public double areaSector(double radio , double angulo){
        double areaSector = (angulo/360) * Math.pow(radio , 2) * Math.PI;   
        
        return areaSector;
    }
    
    
}
