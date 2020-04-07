package CONTROLLER;

import MODEL.PRODUCTS.FEATURES.ExtraIngredients;
import MODEL.PRODUCTS.FEATURES.MasaPizzaTypes;
import MODEL.PRODUCTS.Pizza;
import MODEL.PRODUCTS.FEATURES.SizesOfPizza;
import MODEL.PRODUCTS.FEATURES.TypesOfPizza;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.*;
public class Pizzeria implements Initializable {

    public RadioButton rdNormal;
    public RadioButton rdIntegral;
    public ComboBox<String> cbType;
    public ComboBox<String> cbPizzaSize;
    public ListView<String> lbExtraIngredients;
    public TextArea txaDemand;
    public Label lblTotalDemand;
    public CheckBox chToast;
    public CheckBox chDrink;

    private ToggleGroup tgMasa = new ToggleGroup();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buildingCombos();
        buildExtraIngredientsListView();
        rdNormal.setToggleGroup(tgMasa);
        rdIntegral.setToggleGroup(tgMasa);
        tgMasa.selectToggle(rdNormal);
        chDrink.setAccessibleText("Bebida");
        chToast.setAccessibleText("Gratinado");
        doughtIsChanged();
        recalculateValues();
    }
    private void buildingCombos(){
        cbType.setItems(new TypesOfPizza().generateFeatureList());
        cbType.getSelectionModel().selectFirst();
        cbPizzaSize.setItems(new SizesOfPizza().generateFeatureList());
        cbPizzaSize.getSelectionModel().selectFirst();
    }
    private void buildExtraIngredientsListView(){
        lbExtraIngredients.setItems(new ExtraIngredients().generateFeatureList());
        lbExtraIngredients.setEditable(false);
        lbExtraIngredients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    private String getSelectedDought() {
        String dought = "";
        if (rdNormal.isSelected()) {
            dought =  new MasaPizzaTypes().generateFeatureList("Normal");
        }
        if (rdIntegral.isSelected()) {
            dought = new MasaPizzaTypes().generateFeatureList("Integral");
        }
        return dought;
    }
    private void doughtIsChanged() {
        tgMasa.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                recalculateValues();
            }
        });
    }
    public void extraIngredientsIsChanged(MouseEvent mouseEvent) { recalculateValues(); }
    public void typeChanged(ActionEvent actionEvent) { recalculateValues(); }
    public void sizeIsChanged(ActionEvent actionEvent) { recalculateValues(); }
    public void toastIsChanged(ActionEvent actionEvent) { recalculateValues(); }
    public void drinkIsChanged(ActionEvent actionEvent) { recalculateValues(); }
    private Pizza preparePizza(){
        String dought = getSelectedDought();
        String pizzaType = cbType.getValue();
        List<String> extraIngredients = lbExtraIngredients.getSelectionModel().getSelectedItems();
        String pizzaSize = cbPizzaSize.getValue();
        boolean isToast = chToast.isSelected() ;
        return new Pizza(dought , pizzaType  , extraIngredients , pizzaSize,isToast);
    }
    private void recalculateValues() {
        Double subTotalPrice ;
        String demandFormatted = new DemandFormatter().format(preparePizza(),chDrink.isSelected(),chDrink.getAccessibleText() , chToast.isSelected(), chToast.getAccessibleText());
        PricesCalculator calc = new PricesCalculator(preparePizza());
        if(chDrink.isSelected()){
            subTotalPrice =  calc.getTotalPizzaPrice() + calc.getDrinkPrice(chDrink.getAccessibleText());
        }else{
          subTotalPrice = calc.getTotalPizzaPrice();
        }
        subTotalPrice += calc.getToastPrice(chToast.getAccessibleText());
        renderPreDemand(demandFormatted ,subTotalPrice);
    }
    private void renderPreDemand(String demandFormatted,Double subTotalPrice){
        txaDemand.setText(demandFormatted);
        lblTotalDemand.setText("PRECIO TOTAL : " + subTotalPrice + " €");
    }
}


