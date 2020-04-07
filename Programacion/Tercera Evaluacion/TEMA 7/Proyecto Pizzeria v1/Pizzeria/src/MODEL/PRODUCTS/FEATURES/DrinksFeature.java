package MODEL.PRODUCTS.FEATURES;

import MODEL.PRICES.DrinksPricesList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DrinksFeature implements UnlistedFeatures {
    List<String> drinksList = new ArrayList<String>();
    public DrinksFeature(){
        Map<String,Double> drinks = DrinksPricesList.getInstance().getPricesList();
        for(Map.Entry<String,Double> drink : drinks.entrySet()) {
            drinksList.add(drink.getKey());
        }
    }

    @Override
    public String generateFeatureList(String type) {
        drinksList.indexOf(type);
        return drinksList.get(drinksList.indexOf(type));
    }
}

