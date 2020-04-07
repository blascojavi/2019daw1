package MODEL.PRICES;

import java.util.HashMap;
import java.util.Map;

public class ExtraIngredientsPricesList implements FixedPricesInterface  {
    private static ExtraIngredientsPricesList instance = null ;
    
    public ExtraIngredientsPricesList(){ }

    public static ExtraIngredientsPricesList getInstance(){
        if(instance == null ){
            instance = new ExtraIngredientsPricesList();
        }
        return instance;
    }

    @Override
    public  Map<String, Double> getPricesList() {
        Map<String,Double> extraIngPricesList = new HashMap<>() ;
        extraIngPricesList.put("Jamón" , 0.5);
        extraIngPricesList.put("Queso" , 0.75);
        extraIngPricesList.put("Tomate" , 1.5);
        extraIngPricesList.put("Cabolla" , 0.75);
        extraIngPricesList.put("Olivas" , 1.0);
        extraIngPricesList.put("Bacalao" , 5.0);


        return extraIngPricesList;
    }

    @Override
    public String toString() {
        return "ExtraIngredientsPricesList{" +
                "extraIngPricesList=" + this.getPricesList() +
                '}';
    }
}
