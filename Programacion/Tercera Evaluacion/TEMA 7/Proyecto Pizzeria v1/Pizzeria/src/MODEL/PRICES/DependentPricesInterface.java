package MODEL.PRICES;

import java.util.Map;

public interface DependentPricesInterface extends BoardPricesInterface {

    public Map<String, Double> getPricesList(Double masaSelectedPrice) ;
}
