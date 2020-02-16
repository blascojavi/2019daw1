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
public class SDos implements Serie {

    int inicio , val;

    SDos() {
        inicio = 0;
        val = 0;
    }

       
    @Override
   public int getSiguiente() {
        val += 2;
        return val;
    }
}
