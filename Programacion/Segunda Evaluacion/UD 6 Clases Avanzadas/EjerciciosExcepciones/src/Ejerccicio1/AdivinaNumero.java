package Ejerccicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdivinaNumero {

    public static void main(String[] args) {
        boolean adivinado = false;
        int counter = 0 ;
        Scanner sc = new Scanner(System.in);
        int randomNumber = (int) ((Math.random() * 500 )+1);
        System.out.println(randomNumber);
        do {
            System.out.println("Introduce un numero entre 1 y 500 ");
                try {
                    int userNum = sc.nextInt();
                    if(userNum < 1 ){
                        throw new FueraDeRango("Numero por debajo de 1");
                    }
                    if(userNum > 500){
                        throw new FueraDeRango("El Numero esta por encima de 500");
                    }

                    if (userNum == randomNumber) {
                        adivinado = true;
                    }else{
                        System.out.println("NO , intentalo de nuevo");
                    }
                }catch(InputMismatchException e) {
                    sc.nextLine();
                    System.out.println("No has introducido un numero valido ERAN LETRAS ");
                }catch(FueraDeRango e ){
                    System.out.println(e);
                }
            counter++;
        } while (!adivinado);

        System.out.println("NUMERO ADIVINADO , era : " + randomNumber + " En " + counter + " intentos"  );
    }
}
