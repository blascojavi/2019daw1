package MODEL;

import java.util.Map;

public abstract class AbstracListPrices implements InterfaceTablePrices {


    public abstract Map<String, Double> getPricesList(Double masaSelectedPrice );
}
