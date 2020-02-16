package Ejercicio2;

public class Main {

    public static void main(String[] args) {
       boolean state = false ;
        Padron padron = new Padron();
       Ciudadano persona1 = new Ciudadano();
       Ciudadano persona2 = new Ciudadano();
       Ciudadano persona3 = new Ciudadano();
       Ciudadano persona4 = new Ciudadano();
       Ciudadano persona5 = new Ciudadano();
       Ciudadano persona6 = new Ciudadano();

       persona1.setNombre("Pepito");
       persona1.setApellido("Flores");
       persona1.setAnyos(18);
       persona1.setCiudad("Londres");

        persona2.setNombre("Pepito");
        persona2.setApellido("Ramirez");
        persona2.setAnyos(25);
        persona2.setCiudad("Paris");
        persona3.setNombre("Manolito");
        persona3.setApellido("Gafotas");
        persona3.setAnyos(80);
        persona3.setCiudad("Londres");

        persona4.setNombre("Ruperta");
        persona4.setApellido("Ramirez");
        persona4.setAnyos(50);
        persona4.setCiudad("Paris");

        persona5.setNombre("Manuel");
        persona5.setApellido("Falla");
        persona5.setAnyos(12);
        persona5.setCiudad("Paris");

        persona6.setNombre("Rigoberta");
        persona6.setApellido("Miranda");
        persona6.setAnyos(18);

        padron.darAlta(persona1);
        padron.darAlta(persona2);
        padron.darAlta(persona3);
        padron.darAlta(persona4);
        padron.darAlta(persona5);
        padron.darAlta(persona6);

        persona6.setCandidato(true);

        System.out.println(padron.getEmpadronados().size());

        System.out.println(padron.formatearListado(padron.buscar(true)));

        System.out.println(padron.formatearListado(padron.buscar(18)));

        System.out.println(padron.formatearListado(padron.buscar("Londres")));
    }


}
