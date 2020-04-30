package MODEL;

import CONTROLLER.PricesCalculator;
import MODEL.PRODUCTS.Pizza;

import java.util.HashMap;
import java.util.Map;

public class Demand {
    private Map<Integer,Pizza> listOfPizzas = new HashMap();
    private boolean hasDrink ;
    private Double price;

    public Demand() {

    }

    public  Map<Integer, Pizza> getListOfPizzas() {
        return listOfPizzas;
    }

    public  void setListOfPizzas(Map<Integer, Pizza> listOfPizzas) {
        this.listOfPizzas = listOfPizzas;
    }

    public  boolean itHashDrink(){
        return hasDrink;
    }

    public void setDemandPrice(Double price){
        this.price = price ;
    }


}
