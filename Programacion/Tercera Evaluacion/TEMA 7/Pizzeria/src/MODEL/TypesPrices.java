package MODEL;

import java.util.HashMap;
import java.util.Map;

public class TypesPrices implements InterfaceTablePrices {
    @Override
    public Map<String, Double> getPricesList() {
        Map<String,Double> typesPricesList = new HashMap<>();
        typesPricesList.put("Básica" , 3.0);
        typesPricesList.put("Cuatro quesos" , 3.5);
        typesPricesList.put("Barbacoa" , 7.0);
        typesPricesList.put("Mexicana" , 8.5);
        return typesPricesList;
    }
}
