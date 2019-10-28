/*
Antonio Ferrer Lopez
Juego Hundir la flota para curso DAW 
 */
package hundirlaflota;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HundirLaFlota {
  
    public static void main(String[] args) {
        
        //Posibles estados de la casilla 
        final String VACIO = "[------]"; 
        final String AGUA = "[-AGUA-]"; 
        final String REPETIDO = "[-REPE-]"; 
        final String BARCO = "[BARCO-]";
 
        //Declaración y setup de variables iniciales
        final int restaMovimientos = 10 ; //Restar estos movimientos a intentos
        final int POS_CERO_ARRAY = 1 ; 
        final int SIN_INTENTOS = 0 ; 
        
        boolean validateOK = false ; //Flag de validación
        boolean haGanado = false; //en caso que gane pasa a true 
        
        int rows= 6; //Num de filas por defecto
        int userRows , userCols ; //Almacenaran los valores introducidos en config de usuario
        int cols = 8; // Num de columnas por defecto
        int attempts = ((rows-POS_CERO_ARRAY)*(cols-POS_CERO_ARRAY))- restaMovimientos ; //Total Intentos
        int x , y  ; // Coordenadas X e Y para punteros de tablas
        int colBoat , rowBoat ;  //Coordenadas del  barco a hundir 
        int valueRowInt , valueColInt ; // para parsear a integer valores de entrada
        int tiradasRealizadas = 0 ; //Contador de tiradas realizadas
        
        //Declaración de Expresiones regulares para validación 
        String filaExiste = "^[1-" + (rows-POS_CERO_ARRAY) +"]$";
        String columnaExiste = "^[1-" + (cols-POS_CERO_ARRAY) +"]$";
        
        //Declaración de tableros 
        String[][] boardPlayer = new String[rows][cols] ;  
        String[][] boardMachine = new String[rows][cols] ;
        
        //Declaración de entrada de datos 
        Scanner scanValues = new Scanner(System.in); 
        String valueUserRow , valueUserCol ;  //Selección del usuario fila y col
        String valorPosSeleccionada; 
        
        //Chargin initial state of Array
        for (y = 0 ; y <= 5 ; y++){
            for (x = 1 ; x <= 7 ; x++ ){
                boardPlayer[y][x] = VACIO;
                boardMachine[y][x] = VACIO;
            }
        }
        
    //INIT THE GAME 
        
        // Generando coordenadas donde esta situado el barco a hundir 
        rowBoat = (int)(Math.random()*(rows - POS_CERO_ARRAY)+1);
        colBoat = (int)(Math.random()*(cols - POS_CERO_ARRAY)+1);
        System.out.println("col: " + colBoat + " row: " + rowBoat);
 
        //Insertando el valor del barco en tablero de maquina
        boardMachine[rowBoat][colBoat] = BARCO; 
        
      //----TESTING BORRAR LUEGO ----
        //PRINTING MACHINE BOARD  
        for(y = 0 ; y <=(rows-POS_CERO_ARRAY) ; y ++){
           if (y == 0){
                System.out.print(""); 
           }else{
               System.out.print(y);
           }
           
           for (x = 1 ; x <= (cols-POS_CERO_ARRAY) ; x ++){
               if (y == 0){
                  System.out.print("    " + x + "   ");  
               }else{
                  System.out.print(boardMachine[y][x] ); 
               }
           }
           System.out.println("");
        }
      //----TESTING BORRAR LUEGO ----      

        //Imprimiendo pantalla inicial
        System.out.println("");
        System.out.println("<< HUNDIR LA FLOTA >>");
        
        System.out.println("CONFIGURACION DEL TABLERO DE JUEGO");
        System.out.println("----------------------------------");
        System.out.println("Cuantas FILAS quieres que tenga (por defecto 5) : ");
        try {
            userRows = scanValues.nextInt(); 
            rows = userRows++;
        } catch (InputMismatchException e) {
            System.out.println("El valor introducido no es válido , se toma"
                              + "EL VALOR POR DEFECTO");
        }
        
        System.out.println("Cuantas COLUMNAS quieres que tenga (por defecto 7) : ");
        try {
            userCols = scanValues.nextInt(); 
            cols = userCols++;
        } catch (InputMismatchException e) {
            System.out.println("El valor introducido no es válido , se toma"
                              + "EL VALOR POR DEFECTO");
        }
        
        
        do{ 
            System.out.println("Dispone de " + attempts + " intentos para hundir mi barco" );
            System.out.println("");
            System.out.println("---TABLERO DE JUEGO---");
            System.out.println("");

            //PRINTING player BOARD  
            for(y = 0 ; y <=(rows-POS_CERO_ARRAY) ; y ++){
               if (y == 0){
                    System.out.print(""); 
                }else{
                   System.out.print(y);
                }

                for (x = 1 ; x <= (cols-POS_CERO_ARRAY) ; x ++){
                   if (y == 0){
                      System.out.print("    " + x + "   ");  
                    }else{
                      System.out.print(boardPlayer[y][x] ); 
                   }
                }
               System.out.println("");
            }

            //COMENZANDO CUESTIONARIO DE TIRADA

            //Pidiendo FILA 
            do{        
                System.out.println("");
                System.out.print("SELECCIONE UNA FILA (de 1 a " + 
                                  (rows-POS_CERO_ARRAY) + ") : ");
                valueUserRow =  scanValues.next(); 

                // Validación si la fila existe
                if(valueUserRow.matches(filaExiste)){
                    validateOK = true; 
                    System.out.println("FILA SELECCIONADA : " + valueUserRow);
                }else{
                    System.out.println("El valor no es correcto , " +
                                        "por favor intentelo de nuevo");
                }
            }while(validateOK == false);
            validateOK = false; 

            //Pidiendo COLUMNA 
            do{        
                System.out.println("");
                System.out.print("SELECCIONE UNA COLUMNA (de 1 a " + (cols-POS_CERO_ARRAY) + ") : ");
                valueUserCol =  scanValues.next(); 
                // Validación si la fila existe
                if(valueUserCol.matches(columnaExiste)){
                    validateOK = true; 
                    System.out.println("COLUMNA SELECCIONADA : " + valueUserCol);
                }else{
                    System.out.println("El valor no es correcto , " +
                                       "por favor intentelo de nuevo");
                }
            }while(validateOK == false);
            validateOK = false; 

            //Informando de la tirada realizada
            System.out.println("Usted ha seleccionado la fila : " + valueUserRow 
                                + " y la columna : " + valueUserCol);
            System.out.println("");

            //Parseo de los valores de entrada a Integer
            valueRowInt = Integer.parseInt(valueUserRow); 
            valueColInt = Integer.parseInt(valueUserCol);

            //RESULTADO DE TIRADA 
            switch(valorPosSeleccionada = boardMachine[valueRowInt][valueColInt]){
                case VACIO :
                    //A dado en AGUA
                    haGanado = false; 
                    attempts--; // Restamos un intento
                    tiradasRealizadas++; // Sumamos 1 a tidadas realizadas

                    //Modificamos el valor del tablero de la maquina y del jugador marcamos AGUA
                    boardMachine[valueRowInt][valueColInt] = AGUA; 
                    boardPlayer[valueRowInt][valueColInt] = AGUA;
                    break; 
                case AGUA: //En este caso es que ha repetido el usuario 
                      //A dado en AGUA
                    haGanado = false; 
                    attempts--; // Restamos un intento
                    tiradasRealizadas++; // mas 1 tirada realizada 

                    //Modificamos el valor del tablero de la maquina y del jugador marcamos REPETIDO 
                    boardMachine[valueRowInt][valueColInt] = REPETIDO; 
                    boardPlayer[valueRowInt][valueColInt] = REPETIDO;
                    System.out.println("Has repetido esta casilla , "
                            + "la marco para que no te confundas de nuevo");
                    break;
                case BARCO :
                    //BARCO HUNDIDO , ha ganado
                    //A dado en AGUA
                    haGanado = true; 
                    attempts--; // Restamos un intento
                    tiradasRealizadas++; // Sumamos 1 a tidadas realizadas

                    //Modificamos el tablero JUGADOR con BOTE rodeado de AGUA 
                  
                        //TODO: reparar el OUT OF BOUNDS del relleno de agua 
                        for (int i = -1 ; i <= 1 ; i++){
                            for(int z = -1 ; z <= 1 ; z++){
                                boardPlayer[valueRowInt+i][valueColInt+z] = AGUA;
                            }
                        }
                      
                    boardPlayer[valueRowInt][valueColInt] = BARCO;
                    break;
            }   

        }while(haGanado != true && attempts != 0 ) ;//Se hara hasta que gane 
      
        System.out.println("FIN DEL JUEGO");
        
        if (haGanado == true ){
            //Imprimimos el resumen del juego GANADOR
            System.out.println("");
            System.out.println("----------------------------");
            System.out.println("---------FELICIDADES--------");
            System.out.println("-Has necesitado " + tiradasRealizadas +" intento/s-");
            System.out.println("-----Gracias por jugar------");
            System.out.println("----------------------------");
            System.out.println("");
            //PRINTING player BOARD  
            for(y = 0 ; y <=(rows-POS_CERO_ARRAY) ; y ++){
               if (y == 0){
                    System.out.print(""); 
                }else{
                   System.out.print(y);
                }

                for (x = 1 ; x <= (cols-POS_CERO_ARRAY) ; x ++){
                   if (y == 0){
                      System.out.print("    " + x + "   ");  
                    }else{
                      System.out.print(boardPlayer[y][x] ); 
                   }
                }
               System.out.println("");
            }
        }else{
            //Informamos que no ha conseguido acertar 
            System.out.println("");
            System.out.println("-----------------------------");
            System.out.println("--NO TE QUEDAN MÁS INTENTOS--");
            System.out.println("-----Intentalo de nuevo------");
            System.out.println("-----Gracias por jugar-------");
            System.out.println("-----------------------------");
            System.out.println("");
        }
            
        //REPINTADO DE TABLERO DE JUGADOR 
        // RESULTADO Y REPETICIÓN
        
        try {
            
        } catch (Exception e) {
        }
        
    }//MAIN 
    
}//CLASS 



///// PENDIENTE HACER validación de ACIERTO ... terminar a partir de alli 


//TODO: sustituir. TODO agua y luego barco en medio. 
