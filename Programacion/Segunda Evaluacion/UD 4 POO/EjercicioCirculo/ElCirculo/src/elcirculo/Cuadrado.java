/*
Crea una clase llamada Cuadrado con los siguiente método:
perimetro: Obtiene el perímetro del cuadrado en función del tamaño del lado.
Perímetro = 4 * Lado
area: Obtiene el area del cuadrado en función del tamaño del lado.
Area = Lado * Lado
lados: Obtiene el Nº de lados del cuadrado.
Lados = 4
10. Modifica el programa Principal para que ahora muestre el “Area”, ”Perímetro” y “Lados” de un
Cuadrado con lado 15
 */
package elcirculo;

public class Cuadrado {
    public double perimetro(double lado){
        double perimetro = this.lados() * lado; 
        return perimetro ; 
    }
    
    public double area(double lado ){
        double area = Math.pow(lado, 2);
        return area; 
    }
    
    public int lados(){
        int lados = 4; 
        return lados; 
    }
}
