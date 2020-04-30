package CONTROLLER;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;


public class imc implements Initializable {

    private static final double MAX_TICKS = 20;
    private static final int MIN_TICKS = 5;
    private  final Double MAX_WEIGHT = 180.0;
    private final Double MIN_WEIGHT = 20.0;
    public ListView listResults;

    private double actualWeight ;
    private double actualHeight ;
    private DecimalFormat df = new DecimalFormat("###.00");

    public Label lblResult;
    public Label lblHeight;
    public Label lblWeight;
    public Slider sldHeight;
    public Slider sldWeight;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initListView();
        initSliderWeight();
        initDataValues();
        updateWeight();
        updateHeight();

    }

    private void initListView() {
        ObservableList<String> lista = FXCollections.observableArrayList("Obesidad" ,"Sobrepeso" ,  "Normal" , "Extradelgadez") ;

        listResults.setItems(lista);

    }

    private void initDataValues() {
        actualWeight  = sldWeight.getValue();
        actualHeight  = sldHeight.getValue();
    }
    private void initSliderWeight() {
        sldWeight.setMax(MAX_WEIGHT);
        sldWeight.setMin(MIN_WEIGHT);
        sldWeight.setValue(MAX_WEIGHT/2);
        sldWeight.setShowTickLabels(true);
        sldWeight.setShowTickMarks(true);
        sldWeight.setSnapToTicks(true);
        sldWeight.setMajorTickUnit(MAX_TICKS);
        sldWeight.setMinorTickCount(MIN_TICKS);
    }

    private void updateWeight() {
        lblWeight.setText(df.format(actualWeight) + " Kg");
    }


    private void updateHeight() {
        lblHeight.setText(df.format(actualHeight) + " cm");
    }

    public void weightChanged(MouseEvent mouseEvent) {
        actualWeight =  sldWeight.getValue();
        updateWeight();
        calculateImc();
    }

    public void heightChanged(MouseEvent mouseEvent) {

        actualHeight = sldHeight.getValue();
        updateHeight();
        calculateImc();
    }


    private void calculateImc(){
        double imc = 0.0 ;
        double heightInMeters = actualHeight / 100 ;
        imc = actualWeight / (Math.pow(heightInMeters , 2));
        printValues(imc);
        selectListValue(imc);
    }

    private void selectListValue(double imc) {
        if(imc > 30 ){
            listResults.getSelectionModel().select("Obesidad");
        }
        if (imc >= 25 && imc <= 29.9){
            listResults.getSelectionModel().select("Sobrepeso");
        }
        if(imc >= 18.5 && imc <= 24.9 ){
            listResults.getSelectionModel().select("Normal");
        }
        if(imc <= 18.4){
            listResults.getSelectionModel().select("Extradelgadez");
        }
    }

    private void printValues(double imc) {
        DecimalFormat df = new DecimalFormat("###.00");
        lblResult.setText("Su IMC es : " + df.format(imc));

    }


}
