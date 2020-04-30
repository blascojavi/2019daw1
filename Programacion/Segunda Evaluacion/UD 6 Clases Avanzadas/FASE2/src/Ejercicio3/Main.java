package Ejercicio3;

public class Main {

    public static void main(String[] args) {
        BilleteTren billeteSuperior = new BilleteTren("Valencia" , "Madrid" , 120 , tiposBillete.SUPERIOR);
        BilleteTren billeteTurista = new BilleteTren("Valencia" , "Madrid" , 120 , tiposBillete.TURISTA);


        System.out.println(billeteSuperior.toString());
        System.out.println(billeteTurista.toString());

        System.out.println(billeteSuperior.aPagar());
        System.out.println(billeteSuperior.aPagar(50));
        System.out.println(billeteSuperior.aPagar(true));
        System.out.println(billeteTurista.aPagar());
        System.out.println(billeteTurista.aPagar(99));
        System.out.println(billeteTurista.aPagar(false));
    }
}
