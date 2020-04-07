package MODEL.PRODUCTS.FEATURES;

import MODEL.PRICES.SizePricesList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Map;

public class SizesOfPizza implements ListedFeatures {
    private final Double NO_NEED_PRICE = 0.0;
    @Override
    public ObservableList<String> generateFeatureList() {
        Map<String,Double> sizes = SizePricesList.getInstace().getPricesList(NO_NEED_PRICE);
        ObservableList<String> sizesList = FXCollections.observableArrayList();

        for(Map.Entry<String,Double> size : sizes.entrySet()){
            sizesList.add(size.getKey());
        }

        return sizesList;
    }
}
