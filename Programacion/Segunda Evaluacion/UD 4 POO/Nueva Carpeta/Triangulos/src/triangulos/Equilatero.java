
package triangulos;


public class Equilatero {
    private double lado ; 
    private double altura ;
    private final int LADOS = 3; 

    public double getLado() {
        return lado;
    }

    public double getAltura() {
        return altura;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public double area(double base ){
        double area = base * (Math.sqrt(3)/2);
                
        return area; 
    }
    
    public double perimetro(double base){
        double perimetro = this.LADOS * base; 
        return perimetro;
    }
    
    
    
}
