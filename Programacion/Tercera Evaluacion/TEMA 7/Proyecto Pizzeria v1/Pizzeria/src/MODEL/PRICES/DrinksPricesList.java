package MODEL.PRICES;

import java.util.HashMap;
import java.util.Map;

public class DrinksPricesList implements FixedPricesInterface {
    private static DrinksPricesList instance = null ;
    private DrinksPricesList(){}

    public static DrinksPricesList getInstance(){
        if(instance == null){
            instance = new DrinksPricesList();
        }
        return instance;
    }


    @Override
    public Map<String, Double> getPricesList() {
        Map<String,Double> drinks = new HashMap<>();

        drinks.put("Bebida" , 2.0);

        return drinks;
    }
}
