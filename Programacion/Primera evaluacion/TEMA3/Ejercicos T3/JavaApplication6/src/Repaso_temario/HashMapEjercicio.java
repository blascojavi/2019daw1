/*
a.crea un HashMap para almacenar los nombres
    de los meses del año y la cantidad de días de
    cada uno. Rellénala

b.Recorre el HashMap y muestra por pantalla los
    meses introducidos, indicando entre paréntesis
    el número de días de cada uno. (usa un bucle
    for-each)
*/

package Repaso_temario;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
        

public class HashMapEjercicio {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String mesSolicitado;  
        
        
        /*a*/
        Map<String , Integer> mesesAno = new HashMap<>();
        
        mesesAno.put("enero", 31);
        mesesAno.put("Febrero", 28);
        mesesAno.put("Marzo", 31);
        mesesAno.put("Abril", 30);
        mesesAno.put("Mayo", 31);
        mesesAno.put("Junio", 30);
        mesesAno.put("Julio", 31);
        mesesAno.put("Agosto", 31);
        mesesAno.put("Septiembre", 30);
        mesesAno.put("Octubre", 31);
        mesesAno.put("Noviembre", 30);
        mesesAno.put("Diciembre", 31);
        

        Iterator it = mesesAno.keySet().iterator();
        while(it.hasNext()){
            System.out.println(mesesAno.get(it.next()));
        }
        
        
        System.out.println("");
        /*c solicitar el mes y que retorne cuantos dias tiene */
        System.out.println("Que mes necesitas saber : ");
        mesSolicitado = scan.next();
        
        System.out.println("El mes " + mesSolicitado + " tiene " + 
                mesesAno.get(mesSolicitado) + " dias.");
    }

}
