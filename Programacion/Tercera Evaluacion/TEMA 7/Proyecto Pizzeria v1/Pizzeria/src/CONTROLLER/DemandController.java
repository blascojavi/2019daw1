package CONTROLLER;

import MODEL.Demand;
import MODEL.PRODUCTS.Pizza;

import java.util.Map;

public class DemandController implements CRUDInterface<Pizza> {

    private static Integer pizzaCounter = 0 ;
    private Demand demand;

    public DemandController(Demand demand) {
        this.demand = demand;
    }

    @Override
    public boolean add(Pizza pizza) {
        boolean isAdded = false;
        pizzaCounter++;
        try{
            demand.getListOfPizzas().put(pizzaCounter , pizza);
            isAdded = true;
        }catch (Exception e){
        }
        return isAdded;
    }

    @Override
    public Map<Integer, Pizza> readAll() {
        setPrice(demand.getListOfPizzas(),demand.itHashDrink());
        return demand.getListOfPizzas();
    }

    @Override
    public Pizza read(Integer index) {
        setPrice(demand.getListOfPizzas(),demand.itHashDrink());
        return this.readAll().get(index);
    }

    @Override
    public boolean update(Integer index ,Pizza pizza) {
        boolean isUpdated = false;
        try {
            this.readAll().replace(index, pizza);
            setPrice(demand.getListOfPizzas(),demand.itHashDrink());
            isUpdated = true;
        }catch (Exception e){
        }
        return isUpdated;
    }

    @Override
    public boolean delete(Integer index) {
        boolean isDeleted = false;
        try{
            this.readAll().remove(index);
            setPrice(demand.getListOfPizzas(),demand.itHashDrink());
            isDeleted = true;
        }catch (Exception e){
            isDeleted = false;
        }
        return isDeleted;
    }

    private void setPrice(Map<Integer,Pizza> listOfPizzas , boolean hasDrink){
        Double price = 0.0;
        for(Map.Entry<Integer,Pizza> pizzaOnList : listOfPizzas.entrySet()){
            price += pizzaOnList.getValue().getPizzaPrice();
        }
        if(hasDrink){
            price += new PricesCalculator().getDrinkPrice("Bebida");
        }
         demand.setDemandPrice(price);
    }
}
