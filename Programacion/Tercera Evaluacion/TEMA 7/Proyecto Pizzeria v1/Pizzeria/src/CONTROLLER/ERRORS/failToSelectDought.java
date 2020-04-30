package CONTROLLER.ERRORS;

import MODEL.PRICES.BoardPricesInterface;

public class failToSelectDought extends PizzeriaErrors implements BoardPricesInterface {
    public failToSelectDought(String msj) {
        super("SELECCION DE MASA :" + msj);
    }
}
