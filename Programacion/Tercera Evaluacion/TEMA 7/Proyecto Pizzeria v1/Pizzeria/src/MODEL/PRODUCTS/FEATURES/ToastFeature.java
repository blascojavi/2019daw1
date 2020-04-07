package MODEL.PRODUCTS.FEATURES;

import MODEL.PRICES.ToastPricesList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class ToastFeature implements UnlistedFeatures {
    private final Double  NO_INCREMENT = 0.0;
    List<String> toastList = new ArrayList<String>();
    public ToastFeature(){
        Map<String,Double> toast = ToastPricesList.getInstance().getPricesList(NO_INCREMENT);
        for(Map.Entry<String,Double> toastType : toast.entrySet()) {
            toastList.add(toastType.getKey());
        }
    }
    @Override
    public String generateFeatureList(String type) {
        toastList.indexOf(type);
        return toastList.get(toastList.indexOf(type));
    }
}