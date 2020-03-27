package CONTROLLER;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculadoraAvanzada {
    public TextField display;
    public Button one;
    public Button two;
    public Button three;
    public Button plus;
    public Button four;
    public Button five;
    public Button six;
    public Button minus;
    public Button seven;
    public Button eight;
    public Button nine;
    public Button multiply;
    public Button equal;
    public Button zero;
    public Button clear;
    public Button division;
    private String operation;
    private Double number1 = null;
    private Double number2 = null;
    private double result;


    public void handleButtonAction(ActionEvent buttonPresed) {
        actionOnButtonPressed(buttonPresed);

    }

    private void actionOnButtonPressed(ActionEvent buttonPresed) {
        if (buttonPresed.getSource() == one ) {
            clearIfFirstIsZero();
        display.setText(display.getText().concat(one.getAccessibleText()));
        }
        if (buttonPresed.getSource() == two ) {
            display.setText(display.getText().concat("2"));
        }
        if (buttonPresed.getSource() == three ) {
            display.setText(display.getText().concat("3"));
        }
        if (buttonPresed.getSource() == four) {
            display.setText(display.getText().concat("4"));
        }
        if (buttonPresed.getSource() == five ) {
            display.setText(display.getText().concat("5"));
        }
        if (buttonPresed.getSource() == six ) {
            display.setText(display.getText().concat("6"));
        }
        if (buttonPresed.getSource() == seven ) {
            display.setText(display.getText().concat("7"));
        }
        if (buttonPresed.getSource() == eight ) {
            display.setText(display.getText().concat("8"));
        }
        if (buttonPresed.getSource() == nine ) {
            display.setText(display.getText().concat("9"));
        }
        if (buttonPresed.getSource() == zero ) {
            display.setText(display.getText().concat("0"));
        }
        if (buttonPresed.getSource() == plus ||buttonPresed.getSource() == minus ||
                buttonPresed.getSource() == division || buttonPresed.getSource() == multiply ) {
            //STRING TOKENUIZER


           }
        }


    }

    private String setOperationType(Object buttonPressed) {
        if(buttonPressed.equals(plus)){
            return "+";
        }
        if(buttonPressed.equals(minus)){
            return "-";
        }
        if(buttonPressed.equals(division)){
            return "/";
        }
        if(buttonPressed.equals(multiply)){
            return "*";
        }
        return null;
    }


    private void clearIfFirstIsZero() {
        if(display.getText().equals("0")){
            display.setText("");
        }
    }
}

