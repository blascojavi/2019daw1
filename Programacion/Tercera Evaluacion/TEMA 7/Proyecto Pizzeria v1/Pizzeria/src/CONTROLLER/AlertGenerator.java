package CONTROLLER;

import javafx.scene.control.Alert;

public class AlertGenerator {

    private static final String INFO = "Información" ;
    private AlertGenerator instance = null ;
    private static Alert alert = null;

    private AlertGenerator() {
    }

    public AlertGenerator getInstace(){
        if(instance == null ){
             instance = new AlertGenerator();
        }
        return instance;
    }


    public static void generateConfirmation(String msj){

        generateContext(Alert.AlertType.CONFIRMATION, msj);
    }


    public static void generateWarning(String msj){
        generateContext(Alert.AlertType.WARNING,msj);
    }

    private static void generateContext(Alert.AlertType type, String msj) {
        alert = new Alert(type);
        alert.setHeaderText(INFO);
        alert.setContentText(msj);
        alert.showAndWait();
    }


}
