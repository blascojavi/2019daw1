package Ejercicio4;

import java.util.regex.Matcher;

public class Aleatorios {
    static int counter = 0 ;
    public static void main(String[] args) {
        boolean infinite = true;
        while (infinite ){
         generateNumber();
         counter++;
        }
    }

    private static void generateNumber() {
        int aleatNumber = (int) (Math.random()*1000000 ) +1 ;

        if(aleatNumber == 42089){
            throw new errNumGenerado( String.valueOf(counter) );
        }

    }

}
