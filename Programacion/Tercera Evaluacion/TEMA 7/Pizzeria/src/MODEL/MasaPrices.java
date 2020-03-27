package MODEL;

import java.util.HashMap;
import java.util.Map;

public class MasaPrices implements InterfaceTablePrices {
    @Override
    public Map<String, Double> getPricesList() {
        Map<String,Double> masaPricesList = new HashMap<>();
        masaPricesList.put("Normal" , 3.0);
        masaPricesList.put("Integral" , 3.5);
        return masaPricesList;
    }
}
