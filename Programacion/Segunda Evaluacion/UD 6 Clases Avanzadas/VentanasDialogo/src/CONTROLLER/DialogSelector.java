
package CONTROLLER;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class DialogSelector {


    public void muestraInformation(MouseEvent mouseEvent) {
        Alert.AlertType alertAlertType;
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setContentText("");
        alert.showAndWait();
    }

    public void muestraAlertaConfirmation(ActionEvent actionEvent) {
    }

    public void muestraInputDialog(ActionEvent actionEvent) {
    }

    public void muestraWarning(ActionEvent actionEvent) {
    }

    public void muestraAlertaConfirmationVarios(ActionEvent actionEvent) {
    }

    public void MuestraInputDalogVarios(ActionEvent actionEvent) {
    }
}
