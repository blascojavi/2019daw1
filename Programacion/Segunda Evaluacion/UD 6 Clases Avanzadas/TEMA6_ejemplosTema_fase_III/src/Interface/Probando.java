/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author raquel
 */
public class Probando {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SDos sDos = new SDos();
   STres sTres = new STres();
   Serie serie;  // variable de referencia a la interface
   for (int i=0; i < 5; i++){
      serie = sDos;   
      System.out.println("Siguiente SDos: "+ serie.getSiguiente());
      serie = sTres;
      System.out.println("Siguiente STres: "+ serie.getSiguiente());
   }
   
   

    }
    
}
