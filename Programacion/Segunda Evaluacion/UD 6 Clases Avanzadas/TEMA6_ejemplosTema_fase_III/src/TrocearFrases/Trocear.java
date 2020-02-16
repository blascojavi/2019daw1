package TrocearFrases;

import java.util.StringTokenizer;

public class Trocear {

    public static void main(String[] args) {

        StringTokenizer st = new StringTokenizer("this is a test. Probamos separador. Y lo separamos", ".");
        
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }

}
