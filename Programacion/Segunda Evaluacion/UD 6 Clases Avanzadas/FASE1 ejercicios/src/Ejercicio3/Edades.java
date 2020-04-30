package Ejercicio3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Edades {
    public static void main(String[] args) {
        List<String> valoresIntroducidos = new ArrayList();
        int edadTotal = 0;
        double media = 0;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i <= 9; i++) {
            System.out.println("Introduce Edad");
            valoresIntroducidos.add(sc.next());
        }

        for (String valor : valoresIntroducidos) {
            edadTotal += Integer.parseInt(valor);
        }

        media = (double) edadTotal / valoresIntroducidos.size();
        System.out.println(media);

    }
}
