
package InterfazVotante;


public class PruebaInterfaz {

   
    public static void main(String[] args) {
        /* Persona p1= new Persona(); Esto da error porque la clase es abstract  */
        Persona p1 = new Ciudadano(); // Esto sí que funciona!! ejemplo polimorfismo
        p1.setNombre("Paco");
        p1.setApellido("Smith");
        p1.setAnyos(22);
        System.out.println(p1.datos());         

//     sin embargo
//      p1.setDni("333333-4");  //No funciona porque es un metodo de Ciudadano
       
        System.out.println("");
        ExtranjeroTransito et1 = new ExtranjeroTransito();
        et1.setPaisOrigen("Francia");
        et1.setTiempoPermanencia(30);// usamos métodos propios
        et1.setNombre("Jean");
        et1.setApellido("Dacon");
        et1.setAnyos(25);// usamos métodos de la clase padre
        System.out.println(et1.datos()); // usamos un método de la clase hija que usa métodos del padre
        
        System.out.println("");
        Ciudadano c1 = new Ciudadano();
        c1.setNombre("Juan");
        c1.setApellido("Martinez");
        c1.setAnyos(21);
        c1.setDni("22222222-e");
        c1.setCandidato(true);
        c1.setCiudad("Valencia");
        System.out.println( c1.datos() );
        System.out.println("");

        System.out.println("El número total de personas es: " + Persona.getNumPersonas());

        Ciudadano c2 = new Ciudadano();
        c2.setNombre("Juan");
        c2.setApellido("Martinez");
        c2.setAnyos(21);
        c2.setDni("22222222-e");
        c2.setCandidato(true);
        c2.setCiudad("Valencia");
        System.out.println(c2.datos());
       
        System.out.println("");
        System.out.println("El número total de personas es: " + Persona.getNumPersonas());
    }

}
