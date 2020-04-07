package MODEL.PRODUCTS.FEATURES;

import MODEL.PRICES.ExtraIngredientsPricesList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Map;

public class ExtraIngredients implements ListedFeatures {
    @Override
    public ObservableList<String> generateFeatureList() {
        Map<String ,Double> extras =  ExtraIngredientsPricesList.getInstance().getPricesList();
        ObservableList<String> extraIngredientsList = FXCollections.observableArrayList();

        for(Map.Entry<String,Double> extra : extras.entrySet()) {
            extraIngredientsList.add(extra.getKey());
        }

        return extraIngredientsList;
    }
}
