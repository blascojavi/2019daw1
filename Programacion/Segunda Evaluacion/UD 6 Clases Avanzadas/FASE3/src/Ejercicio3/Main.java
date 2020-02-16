package Ejercicio3;

import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Atleta at1 = new Atleta("Pepito" ,0001 , 5.6);
        Atleta at2 = new Atleta("Juanita" ,0002 , 4.6);
        Atleta at3 = new Atleta("Manolito" ,0003 , 5.7);
        Atleta at4 = new Atleta("Roberto" ,0004 , 2.6);

        Collections.sort(Atleta.atletasParticipantes);
        for (Atleta enLista : Atleta.atletasParticipantes){
            System.out.println(enLista);
        }



    }
}
