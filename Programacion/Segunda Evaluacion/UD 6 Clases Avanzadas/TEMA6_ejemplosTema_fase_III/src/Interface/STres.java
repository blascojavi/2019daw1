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
public class STres implements Serie {

    int inicio, val;

    STres() {
        inicio = 0;
        val = 0;
    }

    
    @Override
   public int getSiguiente() {
        val += 3;
        return val;
    }
}
