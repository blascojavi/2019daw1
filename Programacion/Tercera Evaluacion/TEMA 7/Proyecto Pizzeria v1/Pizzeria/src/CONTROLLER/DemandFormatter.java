package CONTROLLER;

import MODEL.PRICES.DrinksPricesList;
import MODEL.PRODUCTS.Pizza;

public class DemandFormatter {
    private static final String BREACK_LINE = "\n";
    private static final String NO_SELECTED = " NO ";
    private static final String IS_SELECTED = " SI ";
    private Double drinkPrice = 0.0;

    public String format(Pizza pizzaDemanded, boolean hasDrink, String drinkType, boolean hasToast, String accessibleText) {
        PriceConsultant consultant = new PriceConsultant(pizzaDemanded);
        String itHasDrinkSelected ;
        String itHasToastSelected ;
        if(hasDrink){
           drinkPrice =  DrinksPricesList.getInstance().getPricesList().get(drinkType);
           itHasDrinkSelected = IS_SELECTED;
        }else{
            itHasDrinkSelected = NO_SELECTED;
        }
        if(hasToast){
            itHasToastSelected = IS_SELECTED;
        }else{
            itHasToastSelected = NO_SELECTED;
        }
        String demandFormated = "";
        demandFormated = "MASA : " + pizzaDemanded.getDough() +  " " + consultant.getMasaPrice() + " €" + BREACK_LINE +
                "TIPO : " + pizzaDemanded.getPizzaType() + " " + consultant.getTypePizzaPrice() + " €" + BREACK_LINE +
                "INGREDIENTES EXTRA : " + pizzaDemanded.getExtraIngredients() +  " " + consultant.getExtraIngredientsPrice() + " €" + BREACK_LINE +
                "GRATINADA :" + itHasToastSelected  + " " + consultant.getToastPrice("Gratinado" , hasToast) + " €" + BREACK_LINE +
                "TAMAÑO : " + pizzaDemanded.getPizzaSize() +  " " + consultant.getSizeSelectedPrice() + " €" + BREACK_LINE +
                "SELECCIÓN DE BEBIDA : " + itHasDrinkSelected + " " + drinkPrice + " €";

        return demandFormated;
    }

}
