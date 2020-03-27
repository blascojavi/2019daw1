package MODEL;

import java.util.HashMap;
import java.util.Map;

public interface InterfaceTablePrices {
    Map<String,Double> pricesList = new HashMap<String , Double>();
    Map<String,Double> getPricesList();
}
