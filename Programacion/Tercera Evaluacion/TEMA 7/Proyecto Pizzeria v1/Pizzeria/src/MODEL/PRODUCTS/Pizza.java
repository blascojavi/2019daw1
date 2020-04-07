package MODEL.PRODUCTS;

import CONTROLLER.PricesCalculator;

import java.util.List;

public class Pizza {
    private String dough;
    private String pizzaType ;
    private List<String> extraIngredients ;
    private String pizzaSize ;
    private boolean pizzaIsToast;
    private Double pizzaPrice;

    public Pizza(String dough, String pizzaType, List<String> extraIngredients, String pizzaSize, boolean isToast) {
        this.dough = dough;
        this.pizzaType = pizzaType;
        this.extraIngredients = extraIngredients;
        this.pizzaSize = pizzaSize;
        this.pizzaIsToast = isToast;
        setPizzaPrice();
    }

    private void setPizzaPrice() {
        this.pizzaPrice = new PricesCalculator(this).getTotalPizzaPrice();
    }

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public List<String> getExtraIngredients() {
        return extraIngredients;
    }

    public void setExtraIngredients(List<String> extraIngredients) {
        this.extraIngredients = extraIngredients;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public boolean isToast() {
        return pizzaIsToast;
    }

    public void setToast(boolean toast) {
        pizzaIsToast= toast;
    }

    public Double getPizzaPrice(){
        return this.pizzaPrice;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "dough='" + dough + '\'' +
                ", pizzaType='" + pizzaType + '\'' +
                ", extraIngredients=" + extraIngredients +
                ", pizzaSize='" + pizzaSize + '\'' +
                '}';
    }
}
