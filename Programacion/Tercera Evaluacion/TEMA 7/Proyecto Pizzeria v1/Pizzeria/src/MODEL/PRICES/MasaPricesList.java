package MODEL.PRICES;

import java.util.HashMap;
import java.util.Map;

public class MasaPricesList implements FixedPricesInterface {
    private static MasaPricesList instance = null ;


    private MasaPricesList() {
    }

    public static MasaPricesList getInstance(){
        if(instance == null ){
            instance  = new MasaPricesList();
        }
        return instance;
    }

    @Override
    public Map<String, Double> getPricesList() {
        Map<String,Double> masaPricesList = new HashMap<>();
        masaPricesList = new HashMap<>();
        masaPricesList.put("Normal" , 3.0);
        masaPricesList.put("Integral" , 3.5);
        return masaPricesList;
    }

    public String toString() {
        return "Masa Prices List{" +
                "Masa Prices List=" + getPricesList() +
                '}';
    }
}
