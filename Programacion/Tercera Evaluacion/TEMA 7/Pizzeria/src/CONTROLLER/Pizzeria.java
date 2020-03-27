package CONTROLLER;

import MODEL.ExtraIngredientsPricesList;
import MODEL.InterfaceTablePrices;
import MODEL.MasaPrices;
import MODEL.PriceBoard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.InterfaceAddress;
import java.net.URL;
import java.util.*;

public class Pizzeria implements Initializable {
    public RadioButton rdNormal;
    public RadioButton rdIntegral;
    public ComboBox cbType;
    public ComboBox cbPizzaSize;
    public ListView lbExtraIngredients;
    public Button btnCalculate;
    public TextArea txaDemand;
    public Label lblTotalDemand;

    private ExtraIngredientsPricesList extraIngredients = ExtraIngredientsPricesList.getInstance();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buildingCombos();
        buildExtraIngredientsListView();
        PriceBoard board = new PriceBoard();
        System.out.println(extraIngredients);
        System.out.println(board.getList(extraIngredients));
    }

    private ObservableList<String> generateTypesOfPizzaList(){
     ObservableList<String> typesOfPizza = FXCollections.observableArrayList();
     typesOfPizza.add("Básica");
     typesOfPizza.add("Cuatro Quesos");
     typesOfPizza.add("Barbacoa");
     typesOfPizza.add("Mexicana");

     return typesOfPizza;
    }

    private ObservableList<String> generateSizesOfPizzaList(){
        ObservableList<String> sizesList = FXCollections.observableArrayList();
        sizesList.add("Pequeña");
        sizesList.add("Mediana");
        sizesList.add("Familiar");

        return sizesList;
    }

    private void buildingCombos(){
        cbType.setItems(generateTypesOfPizzaList());
        cbType.getSelectionModel().selectFirst();
        cbPizzaSize.setItems(generateSizesOfPizzaList());
        cbPizzaSize.getSelectionModel().selectFirst();
    }

    private ObservableList<String> generateExtraIngredientsList(){
        ObservableList<String> extraIngredientsList = FXCollections.observableArrayList();
        extraIngredientsList.add("Jamón");
        extraIngredientsList.add("Queso");
        extraIngredientsList.add("Tomate");
        extraIngredientsList.add("Cebolla");
        extraIngredientsList.add("Olivas");

        return extraIngredientsList;

    }
    private void buildExtraIngredientsListView(){
        lbExtraIngredients.setItems(generateExtraIngredientsList());
        lbExtraIngredients.setEditable(false);
        lbExtraIngredients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }


    public void calculatePrizeAndDemand(ActionEvent actionEvent) {

    }
}
