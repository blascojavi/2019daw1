package MODEL;

import java.util.HashMap;
import java.util.Map;


public class ExtraIngredientsPricesList implements InterfaceTablePrices {
    private static ExtraIngredientsPricesList list = null ;
    private ExtraIngredientsPricesList(){

    }

    public static ExtraIngredientsPricesList getInstance(){
        if(list == null ){
            list = new ExtraIngredientsPricesList();
        }
        return list;
    }

    @Override
    public Map<String, Double> getPricesList() {
        Map<String,Double> extraIngPricesList = new HashMap<>();
        extraIngPricesList.put("Jamón" , 0.5);
        extraIngPricesList.put("Queso" , 0.75);
        extraIngPricesList.put("Tomate" , 1.5);
        extraIngPricesList.put("Cabolla" , 0.75);
        extraIngPricesList.put("Olivas" , 1.0);
        return extraIngPricesList;
    }
}
