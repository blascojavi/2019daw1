package CONTROLLER;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Calculadora {
    public TextField num1;
    public TextField num2;
    public TextField resultado;
    public Button btnClear;
    private Double[] number = new Double[2];

    
    

    private Double[] validateNumbers(){

            try{
               Double num1Double = Double.parseDouble(num1.getText());
               Double num2Double = Double.parseDouble(num2.getText());
                number[0] = num1Double; 
                number[1] = num2Double; 
            }catch(NumberFormatException ex){
                resultado.setText("DATOS NO VALIDOS");
                throw new IsNotNumberException("ERROR: ");
            }


        return number;
    }

    public void sumar(ActionEvent actionEvent) {
        validateNumbers();
        resultado.setText(String.valueOf( number[0] + number[1] ));
    }

    public void porcentaje(ActionEvent actionEvent) {
        validateNumbers();
        resultado.setText(String.valueOf( (number[0] * number[1])/100) );
    }

    public void elevar(ActionEvent actionEvent) {
        validateNumbers();
        resultado.setText(String.valueOf( Math.pow(number[0] , number[1]) ));
    }

    public void dividir(ActionEvent actionEvent) {
        validateNumbers();
            if(number[1] == 0 ){
                resultado.setText("ERROR.");
                throw new DivisionByZeroException();
            }
            resultado.setText(String.valueOf(number[0] / number[1]));
    }

    public void clear(ActionEvent actionEvent) {
        num1.setText("");
        num2.setText("");
        resultado.setText("");

    }
}
