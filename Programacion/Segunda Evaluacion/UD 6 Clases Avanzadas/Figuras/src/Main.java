import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        String string = "esto es una frase con = varios Tokens";

        StringTokenizer strTok = new StringTokenizer(string, "t=");

        while(strTok.hasMoreTokens()){
        System.out.println(strTok.nextToken());

        }
    }

}