package CONTROLLER;

import MODEL.Demand;
import MODEL.PRICES.*;
import MODEL.PRODUCTS.Pizza;

import java.util.Map;

public class PricesCalculator {

    PriceConsultant consultant ;
    public PricesCalculator(){};
    private Double totalPizzaPrice = 0.0;
    private Demand demand = new Demand();
    private Pizza pizza ;

    public PricesCalculator(Pizza pizza) {
       this.consultant = new PriceConsultant(pizza);
       this.pizza = pizza;
    }


    public Double getTotalPizzaPrice() {
        return calculateTotalPrice();
    }

    private Double calculateTotalPrice() {
        totalPizzaPrice += consultant.getMasaPrice();
        totalPizzaPrice += consultant.getTypePizzaPrice();
        totalPizzaPrice += consultant.getExtraIngredientsPrice();
        totalPizzaPrice += consultant.getSizeSelectedPrice();

        return totalPizzaPrice ;
    }

    public Double getDrinkPrice(String key){
        return DrinksPricesList.getInstance().getPricesList().get(key);
    }

    public Double getToastPrice(String key){
       Double toastPrice = 0.0 ;
            toastPrice = consultant.getToastPrice(key , pizza.isToast());
        return toastPrice;
    }
}
