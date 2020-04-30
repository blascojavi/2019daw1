import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.text.DecimalFormat;

public class ImcController {


    private static final String YELLOW_BACKGROUND = "-fx-background-color: #FFFF00;" ;
    private static final String DEFAULT_BACKGROUND = "-fx-background-color: white;" ;
    private static final String RED_TEXT = "-fx-text-fill: red;" ;
    private static final String DEFAULT_TEXT = "-fx-text-fill: black;" ;
    public TextField txtAltura;
    public TextField txtPeso;
    public Button btnCalcular;
    public TextField txtResult;
    public RadioButton rdObesidad;
    public RadioButton rdSobrepeso;
    public RadioButton rdNormal;
    public RadioButton rdExtraDelgado;

    private final double OBESITY_MAX = 30.0;
    private final double OVERLOAD_MAX = 29.9;
    private final double OVERLOAD_MIN= 25.0;
    private final double NORMAL_MAX= 24.9;
    private final double NORMAL_MIN= 18.5;
    private final double EXTRA_THIN_MAX= 18.4;
    public ToggleGroup imcDegree;


    private double altura ;
    private double peso ;

    public void calcularImc(ActionEvent actionEvent) {

        if(checkIntroducedValues()){
         clearWindow();
         double result = calcular();
         paintResults(result);
        }else{
            System.out.println("VALORES POR DEBAJO O POR ENCIMA");
        }

    }

    private void paintResults(double result) {
        DecimalFormat df = new DecimalFormat("##.00");
        System.out.println(result);
        txtResult.setText(String.valueOf(df.format(result)));
        if(result >= OBESITY_MAX){
            System.out.println("OBESIDAD");
            rdObesidad.setSelected(true);
            generateAlert("OBESIDAD" , "Deberia hacer dieta , ejercicio y consultar a su medico");
            txtResult.setStyle(YELLOW_BACKGROUND);
        }
        if(result <= OVERLOAD_MAX && result >= OVERLOAD_MIN ){
            System.out.println("SOBREPESO");
            rdSobrepeso.setSelected(true);
        }
        if(result <= NORMAL_MAX && result >=  NORMAL_MIN ){
            System.out.println("NORMAL");
            rdNormal.setSelected(true);
        }
        if(result < EXTRA_THIN_MAX){
            System.out.println("Extra delgadez");
            rdExtraDelgado.setSelected(true);
            generateAlert("EXTREMA DELGADEZ" , "Consulte con su medico. Puede sufrir problemas de salud");
            txtResult.setStyle(YELLOW_BACKGROUND);
        }
    }

    private void generateAlert(String resultObteined, String messaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("PELIGRO");
        alerta.setHeaderText(resultObteined);
        alerta.setContentText(messaje);
        alerta.show();
    }

    private double calcular() {
        double alturaMetros = altura/100;
        return (peso / (Math.pow(alturaMetros,2)));
    }

    private boolean checkIntroducedValues() {
        if(convertValue(txtAltura) != null){
            this.altura = convertValue(txtAltura);
        }
        if(convertValue(txtPeso) != null){
            this.peso = convertValue(txtPeso);
        }


        if(this.peso < 20.0 || this.peso > 180.0){
            txtPeso.setStyle(RED_TEXT);
            imcDegree.selectToggle(null);
            return false;
        }
        if(this.altura < 40.0 || this.altura > 220.0 ){
            txtAltura.setStyle(RED_TEXT);
            imcDegree.selectToggle(null);
            return false;
        }
        return true;
    }

    private void clearWindow(){
        txtResult.setText("");
        txtAltura.setText("");
        txtPeso.setText("");
        txtResult.setStyle(DEFAULT_BACKGROUND);
        txtAltura.setStyle(DEFAULT_TEXT);
        txtPeso.setStyle(DEFAULT_TEXT);
        imcDegree.selectToggle(null);
    }

    private Double convertValue(TextField valueToConvert) {
        Double valueConverted = null;
        try{
           valueConverted = Double.parseDouble(valueToConvert.getText());
        }catch (Exception e ){
            System.out.println("Ha introducido un valor incorrecto");
        }
        return valueConverted;
    }
}
