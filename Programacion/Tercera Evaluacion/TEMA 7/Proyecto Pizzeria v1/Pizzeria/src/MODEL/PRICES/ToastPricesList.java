package MODEL.PRICES;

import java.util.HashMap;
import java.util.Map;

public class ToastPricesList implements DependentPricesInterface{
    private static ToastPricesList instance = null ;

    private ToastPricesList(){}

    public static ToastPricesList getInstance(){
        if(instance == null){
            instance = new ToastPricesList();
        }
        return instance;
    }

    @Override
    public Map<String, Double> getPricesList(Double masaSelectedPrice) {
        Map<String,Double> toastPrices = new HashMap<>();
            toastPrices.put("Gratinado" ,  ((masaSelectedPrice*2)/100));
        return toastPrices;
    }


}
