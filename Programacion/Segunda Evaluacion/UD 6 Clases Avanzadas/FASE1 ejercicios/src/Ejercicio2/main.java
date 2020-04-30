package Ejercicio2;

public class main {

    public static void main(String[] args) {
        AparatoElectrico micro = new AparatoElectrico("Microondas" , 800 );
        AparatoElectrico radiador = new AparatoElectrico("Radiador" , 2000 );
        AparatoElectrico plancha = new AparatoElectrico("Plancha" , 1200 );

        System.out.println( micro.off() );
        System.out.println( radiador.off() );
        System.out.println( plancha.off() );

        System.out.println( micro.on() );
        System.out.println( plancha.on() );

        System.out.println( plancha.off() );
        System.out.println( radiador.on() );






    }
}
