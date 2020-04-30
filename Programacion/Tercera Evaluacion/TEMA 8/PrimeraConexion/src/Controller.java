import Main.Datod.Dba;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Controller {
    public TextArea areaConsola;
    public TextField txtBbdd;
    public TextField txtPasswd;
    public TextField txtUser;

    public void btnTest(ActionEvent actionEvent) {
        Dba connection = new Dba();
        if(connection.conectar(this.txtUser.getText(), this.txtPasswd.getText() , this.txtBbdd.getText())){
            areaConsola.setText(obtainHour() + " -> Conexión realizada con exito a " + txtBbdd.getText() );
        }
        else{
            areaConsola.setText(obtainHour() + " -> Fallo al conectar con la base de datos");
        }

    }
    private LocalTime obtainHour(){
         LocalTime time = LocalTime.now();
         time.format()
         return time;
    }

    public void btnClose(ActionEvent actionEvent) {
    }

}
