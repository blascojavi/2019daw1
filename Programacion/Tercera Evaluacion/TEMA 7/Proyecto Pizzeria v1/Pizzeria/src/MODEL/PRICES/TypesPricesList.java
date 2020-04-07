package MODEL.PRICES;

import java.util.HashMap;
import java.util.Map;

public class TypesPricesList implements FixedPricesInterface{
    private  static TypesPricesList instance = null ;

    private TypesPricesList() { }
    public static TypesPricesList getInstace(){
        if(instance == null ){
           instance = new TypesPricesList();
        }
        return instance ;

    }

    @Override
    public Map<String, Double> getPricesList() {
        Map<String,Double> typesPricesList = new HashMap<>();
        typesPricesList.put("Básica" , 3.0);
        typesPricesList.put("Cuatro Quesos" , 5.0);
        typesPricesList.put("Barbacoa" , 7.0);
        typesPricesList.put("Mexicana" , 8.5);
        return typesPricesList;
    }

    public String toString() {
        return "Types Prices List{" +
                "Types Prices List=" + this.getPricesList() +
                '}';
    }
}
