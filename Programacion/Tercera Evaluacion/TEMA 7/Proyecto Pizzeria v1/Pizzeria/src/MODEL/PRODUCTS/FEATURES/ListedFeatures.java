package MODEL.PRODUCTS.FEATURES;

import javafx.collections.ObservableList;

public interface ListedFeatures extends PizzaFeatures {
    ObservableList<String> generateFeatureList();
}
