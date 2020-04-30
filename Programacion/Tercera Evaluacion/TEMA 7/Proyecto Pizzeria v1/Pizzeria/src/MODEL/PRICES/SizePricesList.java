package MODEL.PRICES;

import java.util.HashMap;
import java.util.Map;

public class SizePricesList implements DependentPricesInterface {
    private static SizePricesList  instance = null ;
    private final Double  NO_INCREMENT = 0.0;

    private SizePricesList() { }

    public static SizePricesList getInstace(){
        if(instance == null ){
            instance  = new SizePricesList();
        }
        return instance;
    }


    @Override
    public Map<String, Double> getPricesList(Double masaSelectedPrice) {
        Map<String,Double> sizePricesList = new HashMap<>();
        sizePricesList.put("Pequeña" , NO_INCREMENT);
        sizePricesList.put("Mediana" , masaSelectedPrice + ((masaSelectedPrice*15)/100) );
        sizePricesList.put("Familiar" , masaSelectedPrice + ((masaSelectedPrice*30)/100) );
        return sizePricesList;
    }


}
