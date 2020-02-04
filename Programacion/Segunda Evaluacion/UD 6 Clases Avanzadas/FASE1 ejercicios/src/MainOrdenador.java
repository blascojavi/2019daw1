public class MainOrdenador {
    public static void main(String[] args) {


        Ordenador or1 = new Ordenador("primero" , "windows" , "Pentium" , 16);
        Ordenador or2 = new Ordenador("segundo" , "linux", "AMD" , 32);


        System.out.println(or1.numerodeOrdenadores());
        System.out.println(or2.numerodeOrdenadores());
        Ordenador or3 = new Ordenador("tercero" , "freedos", "ARM" , 2);
        Ordenador or4 = new Ordenador("cuarto" , "windows" , "AMD" , 64);
        System.out.println(or3.numerodeOrdenadores());
        System.out.println(or4.numerodeOrdenadores());

        System.out.println(or1);
        System.out.println(or2);
        System.out.println(or3);
        System.out.println(or4);
    }
}
