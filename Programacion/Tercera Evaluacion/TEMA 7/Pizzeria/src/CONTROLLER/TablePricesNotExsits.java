package CONTROLLER;

import MODEL.InterfaceTablePrices;

import java.util.Map;

public class TablePricesNotExsits extends RuntimeException implements InterfaceTablePrices {
    public TablePricesNotExsits(String message) {
        super(message);
    }

    @Override
    public Map<String, Double> getPricesList() {
        return null;
    }
}
