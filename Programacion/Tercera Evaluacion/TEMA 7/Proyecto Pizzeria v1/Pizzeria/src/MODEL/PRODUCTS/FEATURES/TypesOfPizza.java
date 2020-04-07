package MODEL.PRODUCTS.FEATURES;

import MODEL.PRICES.TypesPricesList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Map;

public class TypesOfPizza  implements ListedFeatures{
    @Override
    public  ObservableList<String> generateFeatureList() {
        Map<String,Double> tyesOfPizza = TypesPricesList.getInstace().getPricesList();
        ObservableList<String> typesOfPizza = FXCollections.observableArrayList();
            for(Map.Entry<String,Double> type : tyesOfPizza.entrySet() ){
               typesOfPizza.add(type.getKey());
        }

        return typesOfPizza;
    }
}
