import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class app extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Pane panel =  FXMLLoader.load(this.getClass().getResource("main.fxml"));
        Scene scene = new Scene(panel);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
