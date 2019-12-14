/*
Queremos poder calcular el área y el perímetro de un triángulo.
Existen tres tipos según la longitud de los lados: equilátero, isósceles y escaleno.
Crear una clase para cada tipo de triangulo, 
definir los atributos de cada uno junto a sus métodos get()/set() y 
los métodos area() y perimetro()
Buscar las fórmulas en internet conociendo las longitudes de los lados.
Crear una java main class que utilice las clases creadas 
 */
package triangulos;


public class Main {
    public static void main(String[] args) {
        Equilatero equilatero = new Equilatero(); 
        
        System.out.println("Equilatero de lado 15 :  " );
        System.out.println("Area: " + equilatero.area(15));
        System.out.println("Perimetro : " + equilatero.perimetro(15));
        
    }
    
}
