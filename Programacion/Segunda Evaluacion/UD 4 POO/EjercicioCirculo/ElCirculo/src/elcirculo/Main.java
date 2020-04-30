
package elcirculo;


public class Main {


    public static void main(String[] args) {

        
        Circulo circ = new Circulo(); 
        
        System.out.println("Area circulo de radio 10 : " + circ.area(10));
        
        System.out.println("PERIMETRO DE CIRCULO RADIO 10 :" + circ.perimetro(10));
        System.out.println("AREA DEL SECTOR ANGULO 90 radio de circulo 10" + 
                circ.areaSector(10, 90));
        
        //“Diámetro”, ”Area”, ”Perímetro” y “AreaSector” de un Círculo de radio 20.
        System.out.println(" DIAMETRO CIRCULO RADIO 20 :" + circ.diametro(20));
        System.out.println("Area CIRCULO RADIO 20 : " + circ.area(20));
        
        System.out.println("Area SECTOR DE 90 grados CIRCULO RADIO 20 : " 
                + circ.areaSector(20 , 90));
        
        // Modifica el programa Principal para que ahora muestre el “Area”, ”Perímetro” y “Lados” de un
        // Cuadrado con lado 15
        Cuadrado cuad = new Cuadrado();
        System.out.println("Area de cuadrado lado 15 : " + cuad.area(15));
        System.out.println("Perimetro de cuadrado lado 15: " + cuad.perimetro(15));
        System.out.println("Lados de un cuadrado :  " + cuad.lados());
    }
    
}
