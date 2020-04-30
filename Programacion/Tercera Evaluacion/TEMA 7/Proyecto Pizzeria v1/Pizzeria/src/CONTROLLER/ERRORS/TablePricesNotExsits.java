package CONTROLLER.ERRORS;

import MODEL.PRICES.BoardPricesInterface;

public class TablePricesNotExsits extends PizzeriaErrors implements BoardPricesInterface {
    public TablePricesNotExsits(String message) {
        super(message);
    }
}
