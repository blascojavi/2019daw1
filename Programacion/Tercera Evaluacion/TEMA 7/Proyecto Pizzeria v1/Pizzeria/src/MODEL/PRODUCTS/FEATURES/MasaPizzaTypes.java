package MODEL.PRODUCTS.FEATURES;

import MODEL.PRICES.MasaPricesList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MasaPizzaTypes implements UnlistedFeatures {
    List<String> doughtList = new ArrayList<String>();

    public MasaPizzaTypes(){
        Map<String,Double> masaTypes = MasaPricesList.getInstance().getPricesList();
        for(Map.Entry<String,Double> dought : masaTypes.entrySet()) {
            doughtList.add(dought.getKey());
        }
    }

    @Override
    public String generateFeatureList(String type) {
       doughtList.indexOf(type);
        return doughtList.get(doughtList.indexOf(type));
    }
}
