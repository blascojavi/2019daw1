/* UD 1 . INTRODUCCIÓN
*4. Dado un total de participantes en un sorteo y el número de mujeres. ¿Cuantos hombres habrán?
*
* --Datos de entrada--
*
*  -    Participantes del sorteo
*  -    Número de mujeres
*
* --Procedimiento--
*
*   1. RESTAMOS Participantes del sorteo A numero de mujeres OBTENEMOS numero de hombres
*
*
* --Casos de prueba--
*
*  Para Participantes del sorteo = 10
*   Y numero de mujeres = 4
*   SE ESPERA = 6
*

* */


public  class MensAndWomens {

    public int calcNumberOfMen ( int drawParticipant , int womenParticipant){

        int numberOfMen =  drawParticipant - womenParticipant ;

        System.out.println("Numero de hombres participantes : " + numberOfMen);
        return numberOfMen;
    }

    public static void main (String[] args ){
        MensAndWomens calcMens = new MensAndWomens();

        calcMens.calcNumberOfMen(10 , 4 );

    }

}




