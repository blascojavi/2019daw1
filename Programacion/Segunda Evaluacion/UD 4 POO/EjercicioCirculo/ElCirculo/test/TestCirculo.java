/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.oracle.jrockit.jfr.ContentType.Percentage;
import elcirculo.Circulo;
import static jdk.nashorn.internal.objects.NativeRegExp.test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.Double;



/**
 *
 * @author buceo
 */
public class TestCirculo {
   Circulo circulo = new Circulo();
    
    public TestCirculo() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void areaCirculoRadio10(){
        // Se espera que el area de un circulo de radio 10 sea de 314.16 
        
        double radio = 10 ;
        double esperado = 314.16; 
        double resultado = circulo.area(radio);

        assertEquals(esperado, resultado, 0.01);
   }
    
    
    @Test
    public void calculaDiametroEnFuncionDelRadio(){
        // dado un radio obtener el diametro 
        double radio = 35; 
        double esperado = 70 ; 
        double resultado = circulo.diametro(radio); 
        
        assertEquals(esperado , resultado , 0.01);
    }
    
    @Test
    public void CalculaPerimetroEnFuncionDelRadio(){
        // Perímetro = 2 * radio * PI
        double esperado = 219.91;
        double radio = 35; 
        double resultado = circulo.perimetro(radio); 
        
        assertEquals(esperado, resultado , 0.01);
    }
    
    @Test
    public void calculaSectorDeDiametroCirculo(){
        //Area Sector = (Angulo/360) * radio2 * PI
        double angulo = 25.9; 
        double radio = 35; 
        double esperado = (25.9/360) * Math.pow(radio, 2) * Math.PI;
        
        assertEquals(esperado, circulo.areaSector(radio , angulo) , 0.01);
    }
}
