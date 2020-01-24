import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Asignatura asignatura1 = new Asignatura("PROG" , "Programación" , 8);
        Asignatura asignatura2 = new Asignatura("BBDD" , "Bases de datos" , 5);
        Asignatura asignatura3 = new Asignatura("ED" , "Entornos de dasarrollo" , 3);

        Alumno alumno1 = new Alumno("Pepito" , "Calle 1 " , 1981 , "INFOR1");
        Alumno alumno2 = new Alumno("Juanita" , "Calle 2 " , 1970 , "INFOR2");

        Profesor profe1 = new Profesor("Roberto" , "Calle del  profesor 1" , 1880 ,
                "Informatica" , 1900 );
        Profesor profe2 = new Profesor("Pepa" , "Calle profe 2 " , 1875 ,
                "Programacion" , 1899 );


        profe1.impartir(asignatura1);
        profe1.impartir(asignatura2);
        profe1.impartir(asignatura3);

        profe2.impartir(asignatura1);
        profe2.impartir(asignatura2);

        alumno1.matricular(asignatura1);
        alumno1.matricular(asignatura2);
        alumno1.matricular(asignatura3);

        alumno2.matricular(asignatura1);
        alumno2.matricular(asignatura3);

        List<Persona> listaAlumnosYProfesores = new ArrayList<>();

        listaAlumnosYProfesores.add(profe1);
        listaAlumnosYProfesores.add(profe2);
        listaAlumnosYProfesores.add(alumno1);
        listaAlumnosYProfesores.add(alumno2);


        for(Persona personaEnLista : listaAlumnosYProfesores){
            if(isProfesor(personaEnLista)){
                System.out.println("PROFESOR -> " + personaEnLista);

            }
            if(isAlumno(personaEnLista)){
                System.out.println("ALUMNO -> " + personaEnLista);
            }
        }


    }

    private static boolean isAlumno(Persona personaenLista) {
        return personaenLista instanceof Alumno;
    }

    private static boolean isProfesor(Persona personaenLista) {
        return personaenLista instanceof Profesor;
    }
}
