import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent rootPanel = FXMLLoader.load(getClass().getResource("./VIEW/Pizzeria.fxml"));
        Scene mainsScene = new Scene(rootPanel);
        primaryStage.setScene(mainsScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
