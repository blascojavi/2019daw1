package MODEL;

import java.util.HashMap;
import java.util.Map;

public class SizePricesList extends AbstracListPrices {


    @Override
    public Map<String, Double> getPricesList(Double masaSelectedPrice) {
        Map<String,Double> sizePricesList = new HashMap<>();
        sizePricesList.put("Pequeña" , masaSelectedPrice);
        sizePricesList.put("Mediana" , masaSelectedPrice + ((masaSelectedPrice*15)/100) );
        sizePricesList.put("Familiar" , masaSelectedPrice + ((masaSelectedPrice*30)/100) );
        return sizePricesList;
    }

    @Override
    public Map<String, Double> getPricesList() {
        return null;
    }
}
