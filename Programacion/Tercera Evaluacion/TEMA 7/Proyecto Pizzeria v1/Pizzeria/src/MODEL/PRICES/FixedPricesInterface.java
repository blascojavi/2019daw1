package MODEL.PRICES;

import java.util.Map;

public interface FixedPricesInterface extends BoardPricesInterface {
    public Map<String, Double> getPricesList();
}
