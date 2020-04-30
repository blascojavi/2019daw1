package Ejercicio5;


public class creadorOrdenadores {

    public static void main(String[] args) {
        Ordenador or1 = new Ordenador("Ordenador1 ", "Windows", "Intel", 16);
        Ordenador or2 = new Ordenador("Ordenador2 ", "Linux", "AMD", 8);
        Ordenador or3 = new Ordenador("Ordenador3 ", "Windows", "Intel", 20);
        Ordenador or4 = new Ordenador("Ordenador4 ", "Linux", "Intel", 2);

        System.out.println("Total ordenadores creados: " + or1.numeroOrdenador() + " Id de ordenador: " + or1.getIdOrdenador());
        System.out.println("Total ordenadores creados: " + or2.numeroOrdenador() + " Id de ordenador: " + or2.getIdOrdenador());
        System.out.println("Total ordenadores creados: " + or3.numeroOrdenador() + " Id de ordenador: " + or3.getIdOrdenador());
        System.out.println("Total ordenadores creados: " + or4.numeroOrdenador() + " Id de ordenador: " + or4.getIdOrdenador());

        or3.cambiarRam(1);
    }
}
