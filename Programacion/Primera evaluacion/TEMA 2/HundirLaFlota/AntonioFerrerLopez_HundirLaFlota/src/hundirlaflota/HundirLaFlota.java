/*
Antonio Ferrer Lopez
Juego Hundir la flota para curso DAW 
 */
package hundirlaflota;

import java.util.Scanner;

public class HundirLaFlota {
  
    public static void main(String[] args) {
    
    //DECLARACIONES DE VARIABLES Y CONSTANTES//
        //Posibles estados de la casilla 
        final String VACIO = "[------]"; 
        final String AGUA = "[-AGUA-]"; 
        final String REPETIDO = "[-REPE-]"; 
        final String BARCO = "[BARCO-]";
        final int rangoMinimo = 4; //Rango minimo del tablero
        final int rangoMaximo = 20; //Rango Máximo del tablero
        final int POS_INICIAL_ARRAY = 0 ;
        final int POS_CERO_ARRAY = 1 ; //Seleccionar celda 1 de la tabla de juego
        final int POS_PRIMERA_ARRAY = 1; // Se emplea para cargar el estado inicial
        final int restaMovimientos = 10 ; //Restar estos movimientos a intentos
        final int SIN_INTENTOS = 0 ; //Usuario no tiene intentos
        final int VALOR_ANTERIOR = -1; // valor anterior de fila o columna 
        final int VALOR_SIGUIENTE = 1; //Valor siguiente de fila o columna

        //Declaración y_pos setup de variables iniciales
        boolean validateOK = false ; //Flag de validación
        boolean haGanado = false; //FLag de validación Usuario Gana
        
        int rows= 6; //Num de filas por defecto
        int cols = 8; // Num de columnas por defecto
        int userRows , userCols ; //Almacenaran los valores introducidos en config de usuario
        int attempts; //Total Intentos
        int x_pos , y_pos  ; // Coordenadas X e Y para punteros de tablas
        String letra_Fila = "" ; // Letras de las filas 
        int colBoat , rowBoat ;  //Coordenadas del  barco a hundir 
        int valueRowInt = 1, valueColInt = 1 ; // para parsear a integer valores de entrada
        int tiradasRealizadas = 0 ; //Contador de tiradas realizadas default 0 
        
        //Declaración de entrada de datos 
        Scanner scanValues = new Scanner(System.in); 
        String valueUserRow ; //Valor de letra seleccionado 
        int valueUserCol = 0 ;  //Selección del usuario fila y_pos col
        String valorPosSeleccionada; 
        String rowBoatToLetter ; // de numero de posición a letra para presentación
        
        //Variable de validación 
        String validaLetra; //Valida si la letra introducida está en el rango
        
        //Declaración de tableros 
        String[][] boardPlayer ;  //Tablero del jugador 
        String[][] boardMachine ; //Tablero de la maquina
        
    //COMIENZA EL JUEGO ,  PRESENTACIÓN y_pos CONFIGURACIÓN DE TABLEROS//
    
        //Imprimiendo pantalla inicial
        System.out.println("");
        System.out.println("<< HUNDIR LA FLOTA >>");
        System.out.println("CONFIGURACION DEL TABLERO DE JUEGO");
        System.out.println("----------------------------------");
        
        //Cuestionario para obtención de tamaño de tablero
        do{
        System.out.println("Cuantas FILAS quieres que tenga (entre 4 y 20) : ");
        userRows = (scanValues.nextInt()); 
            if (userRows >= rangoMinimo && userRows <= rangoMaximo ){ //si está en rango 
               rows = userRows+POS_CERO_ARRAY; 
               validateOK = true; //Datos ok salgo del while 
            }else{
               System.out.println("Este valor no está permitido intentalo de nuevo "); 
            }
        }while(validateOK == false);
        validateOK = false; //Reseteo flag de validación        
        do{
        System.out.println("Cuantas COLUMNAS quieres que tenga (entre 4 y 20) : ");
            System.out.println("");
        userCols = (scanValues.nextInt()); 
            if (userCols >= rangoMinimo && userCols <= rangoMaximo ){ //si está en rango 
               cols = userCols+POS_CERO_ARRAY; 
               validateOK = true; //Datos ok salgo del while 
            }else{
               System.out.println("Este valor no está permitido intentalo de nuevo "); 
                System.out.println("");    
            }
        }while(validateOK == false);
        validateOK = false; //Reseteo flag de validación 
        
    //SETUP DE PARTIDA // 
        //Instanciando tablas de jugador y_pos maquina
        boardPlayer = new String[rows][cols] ; 
        boardMachine = new String[rows][cols] ; 
        //Cargando estado inicial de los array's 
        for (y_pos = POS_INICIAL_ARRAY ; y_pos <= rows-POS_CERO_ARRAY ; y_pos++){
            for (x_pos = POS_PRIMERA_ARRAY ; x_pos <= cols-POS_CERO_ARRAY ; x_pos++ ){
                boardPlayer[y_pos][x_pos] = VACIO;
                boardMachine[y_pos][x_pos] = VACIO;
            }
        }
        // Generando coordenadas aleatorias donde esta situado el barco a hundir 
        rowBoat = (int)(Math.random()*(rows - POS_CERO_ARRAY)+POS_PRIMERA_ARRAY);
        colBoat = (int)(Math.random()*(cols - POS_CERO_ARRAY)+POS_PRIMERA_ARRAY);

         //Insertando el valor del barco en tablero de maquina
        boardMachine[rowBoat][colBoat] = BARCO;
        //Estableciendo número de intentos que dispone el usuario 
        attempts =((rows-POS_CERO_ARRAY)*(cols-POS_CERO_ARRAY))- restaMovimientos ; 
    
    //COMIENZO SECUENCIA DE JUEGO 
        do{ 
            System.out.println("");
            System.out.println("");
            System.out.println("Dispone de " + attempts + " intentos para hundir mi barco" );
            System.out.println("");
            System.out.println("---TABLERO DE JUEGO---");
            System.out.println("");
            
            //Imprimiendo tablero de usuario   
            for(y_pos = POS_INICIAL_ARRAY ; y_pos <=(rows-POS_CERO_ARRAY) ; y_pos ++){
               if (y_pos == POS_INICIAL_ARRAY){
                    System.out.print(""); 
                }else{
                    //Cambio de Numero a letra 
                    switch(y_pos) {
                        case 1: 
                           letra_Fila = "A";
                        break;
                        case 2: 
                           letra_Fila = "B";
                        break;
                       case 3: 
                           letra_Fila = "C";
                        break;
                        case 4: 
                           letra_Fila = "D";
                        break;
                        case 5: 
                           letra_Fila = "E";
                        break;
                        case 6: 
                           letra_Fila = "F";
                        break;
                        case 7: 
                           letra_Fila = "G";
                        break;
                        case 8: 
                           letra_Fila = "H";
                        break;
                        case 9: 
                           letra_Fila = "I";
                        break;
                        case 10: 
                           letra_Fila = "J";
                        break;
                        case 11: 
                           letra_Fila = "K";
                        break;
                        case 12: 
                           letra_Fila = "L";
                        break;
                        case 13: 
                           letra_Fila = "M";
                        break;
                        case 14: 
                           letra_Fila = "N";
                        break;
                        case 15: 
                           letra_Fila = "Ñ";
                        break;
                        case 16: 
                           letra_Fila = "O";
                        break;
                        case 17: 
                           letra_Fila = "P";
                        break;
                        case 18: 
                           letra_Fila = "Q";
                        break;
                        case 19: 
                           letra_Fila = "R";
                        break;
                        case 20: 
                           letra_Fila = "S";
                        break;
                        default:
                            letra_Fila = "";
                   }    
                   System.out.print(letra_Fila + " ");
                }
               //Imprimiendo el tablero del jugador
                for (x_pos = POS_PRIMERA_ARRAY ; x_pos <= (cols-POS_CERO_ARRAY) ; x_pos ++){
                    if (y_pos == POS_INICIAL_ARRAY){
                        if (x_pos <=9 ){
                            System.out.print("      " + x_pos + " ");
                        }else{
                            System.out.print("      " + x_pos + "");
                        }
                    }else{
                      System.out.print(boardPlayer[y_pos][x_pos] ); 
                   }
                }
               System.out.println("");
            }

         //COMENZANDO CUESTIONARIO DE TIRADA

            //Pidiendo FILA 
            do{        
                System.out.println("");
                System.out.print("SELECCIONE UNA FILA (de A a " + 
                                  letra_Fila + ") : ");
                valueUserRow =  scanValues.next().toUpperCase(); 
                
                //Validación de letra si existe y está en rango 
                validaLetra = "^[A-" + letra_Fila +"]";
                if (valueUserRow.matches(validaLetra)){
                    //Cambio de LETRA A NUMERO
                    switch(valueUserRow) {
                        case "A": 
                           valueRowInt = 1;
                        break;
                        case "B": 
                           valueRowInt = 2;
                        break;
                       case "C": 
                           valueRowInt = 3;
                        break;
                        case "D": 
                           valueRowInt = 4;
                        break;
                        case "E": 
                           valueRowInt = 5;
                        break;
                        case "F": 
                           valueRowInt = 6;
                        break;
                        case "G": 
                           valueRowInt = 7;
                        break;
                        case "H": 
                           valueRowInt = 8;
                        break;
                        case "I": 
                           valueRowInt = 9;
                        break;
                        case "J": 
                           valueRowInt = 10;
                        break;
                        case "K": 
                           valueRowInt = 11;
                        break;
                        case "L": 
                           valueRowInt = 12;
                        break;
                        case "M": 
                          valueRowInt = 13;
                        break;
                        case "N": 
                          valueRowInt = 14;
                        break;
                        case "Ñ": 
                           valueRowInt = 15;
                        break;
                        case "O": 
                           valueRowInt = 16;
                        break;
                        case "P": 
                           valueRowInt = 17;
                        break;
                        case "Q": 
                           valueRowInt = 18;
                        break;
                        case "R": 
                           valueRowInt = 19;
                        break;
                        case "S": 
                           valueRowInt = 20;
                        break;
                        default:
                            valueRowInt = 0;
                   }  
                   validateOK = true;
                   System.out.println("FILA SELECCIONADA : " + valueUserRow ); 
                }else{
                    System.out.println("Valor introducido no valido , intentelo de nuevo");
                }
             //Repetir hasta que se introduzca un valor correcto
            }while(validateOK == false); 
      
            validateOK = false; // Reset del Flag de validación 

            //Pidiendo COLUMNA 
            do{        
                System.out.println("");
                System.out.print("SELECCIONE UNA COLUMNA (de 1 a " 
                        + (cols-POS_CERO_ARRAY) + ") : ");
                
                //Controlando que usuario no intruduzca valores que produzcan una excepción
                try {
                    valueUserCol = scanValues.nextInt();
                    // Validación si la fila existe
                    if(valueUserCol <= (cols-POS_CERO_ARRAY) && 
                            valueUserCol >= POS_PRIMERA_ARRAY ){
                        validateOK = true; 
                        valueColInt = valueUserCol;
                        System.out.println("COLUMNA SELECCIONADA : " + valueUserCol);
                    }else{
                        System.out.println("El valor no es correcto , " +
                                           "por favor intentelo de nuevo");
                    } 
                } catch (Exception e) {
                    scanValues.nextLine(); //Limpiamos cache del Scanner
                    System.out.println("El valor no es correcto , " +
                                       "por favor intentelo de nuevo");
                }
            }while(validateOK == false);
            validateOK = false; 

            //Informando de la tirada realizada
            System.out.println("Usted ha seleccionado la fila : " + valueUserRow 
                                + " y la columna : " + valueUserCol);
            System.out.println("");

            //RESULTADO DE TIRADA 
            switch(valorPosSeleccionada = boardMachine[valueRowInt][valueColInt]){
                case VACIO :
                    //A dado en AGUA
                    haGanado = false; 
                    attempts--; // Restamos un intento
                    tiradasRealizadas++; // Sumamos 1 a tidadas realizadas

                    //Modificamos el valor del tablero de la maquina y_pos del jugador marcamos AGUA
                    boardMachine[valueRowInt][valueColInt] = AGUA; 
                    boardPlayer[valueRowInt][valueColInt] = AGUA;
                    break; 
                case AGUA: case REPETIDO: //En este caso es que ha repetido el usuario 
                      //A dado en AGUA
                    haGanado = false; 
                    attempts--; // Restamos un intento
                    tiradasRealizadas++; // mas 1 tirada realizada 

                    //Modificamos el valor del tablero de la maquina y_pos del jugador marcamos REPETIDO 
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
                    for (x_pos = VALOR_ANTERIOR ; x_pos <= VALOR_SIGUIENTE ; x_pos++){
                        for (y_pos = VALOR_ANTERIOR ; y_pos <= VALOR_SIGUIENTE ; y_pos++){
                            //Validación , si se sale del tablero no alteres array
                           if((x_pos+rowBoat) >= POS_PRIMERA_ARRAY && (x_pos+rowBoat) <= rows - POS_CERO_ARRAY &&
                                  (y_pos+colBoat) >= POS_PRIMERA_ARRAY && (y_pos+colBoat) <= cols - POS_CERO_ARRAY){
                                 boardPlayer[x_pos+rowBoat][y_pos+colBoat] = AGUA;
                            } 
                        }
                    }
                    boardPlayer[valueRowInt][valueColInt] = BARCO;
                    break;
            }   
        }while(haGanado != true && attempts != SIN_INTENTOS) ;//Se hara hasta que gane 
      
    //FIN DEL JUEGO
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
            
            //Imprimiendo tablero jugador  
            for(y_pos = POS_INICIAL_ARRAY ; y_pos <=(rows-POS_CERO_ARRAY) ; y_pos ++){
                if (y_pos == POS_INICIAL_ARRAY){
                    System.out.print(""); 
                }else{
                    System.out.print(y_pos);
                }

                for (x_pos = POS_PRIMERA_ARRAY ; x_pos <= (cols-POS_CERO_ARRAY) ; x_pos ++){
                   if (y_pos == POS_INICIAL_ARRAY){
                      System.out.print("    " + x_pos + "   ");  
                    }else{
                      System.out.print(boardPlayer[y_pos][x_pos] ); 
                   }
                }
               System.out.println("");
            }
        //Ha perdido
        }else{
            //Convirtiendo rowBoat a Letra para indicar coordenada del barco
            switch(rowBoat) {
                case 1: 
                   rowBoatToLetter = "A";
                break;
                case 2: 
                   rowBoatToLetter = "B";
                break;
                case 3: 
                   rowBoatToLetter = "C";
                break;
                case 4: 
                   rowBoatToLetter = "D";
                break;
                case 5: 
                   rowBoatToLetter = "E";
                break;
                case 6: 
                   rowBoatToLetter = "F";
                break;
                case 7: 
                   rowBoatToLetter = "G";
                break;
                case 8: 
                   rowBoatToLetter = "H";
                break;
                case 9: 
                   rowBoatToLetter = "I";
                break;
                case 10: 
                  rowBoatToLetter = "J";
                break;
                case 11: 
                   rowBoatToLetter = "K";
                break;
                case 12: 
                   rowBoatToLetter = "L";
                break;
                case 13: 
                   rowBoatToLetter = "M";
                break;
                case 14: 
                   rowBoatToLetter = "N";
                break;
                case 15: 
                   rowBoatToLetter = "Ñ";
                break;
                case 16: 
                   rowBoatToLetter = "O";
                break;
                case 17: 
                   rowBoatToLetter = "P";
                break;
                case 18: 
                   rowBoatToLetter = "Q";
                break;
                case 19: 
                   rowBoatToLetter = "R";
                break;
                case 20: 
                   rowBoatToLetter = "S";
                break;
                default:
                    rowBoatToLetter = "";
                   }    
            //Informamos que no ha conseguido acertar y la posición del barco
            System.out.println("");
            System.out.println("------------------------------------------");
            System.out.println("----------NO TE QUEDAN MÁS INTENTOS-------");
            System.out.println("------El barco estaba en las coordenadas--"); 
            System.out.println("----------------  "+ rowBoatToLetter +" - "
                                +colBoat+"  -----------------");
            System.out.println("-----------Intentalo de nuevo-------------");
            System.out.println("-----------Gracias por jugar--------------");
            System.out.println("------------------------------------------");
            System.out.println("");
        }
    }  
}

 

