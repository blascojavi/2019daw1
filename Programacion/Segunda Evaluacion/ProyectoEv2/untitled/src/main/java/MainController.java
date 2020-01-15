import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainController {
    public JFXDrawer drawer1;
    public Button btn;
    public JFXDrawersStack stack;

    @FXML
    public void intitialize(){


    }

    public void openClose(ActionEvent actionEvent) throws IOException {
        FXMLLoader load = new FXMLLoader();
      //  StackPane leftDrawerPane = new StackPane();
       // leftDrawerPane.getChildren().add((Node) load.load(getClass().getResource("menu1.fxml")));
        drawer1.setSidePane((Node) load.load(getClass().getResource("menu1.fxml")));
        
        if(drawer1.isShown()){
            drawer1.close();
        }else{
            drawer1.open();
        }
    }


}
