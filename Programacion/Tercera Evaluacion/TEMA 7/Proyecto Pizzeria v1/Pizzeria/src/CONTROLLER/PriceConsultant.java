package CONTROLLER;

import MODEL.PRICES.*;
import MODEL.PRODUCTS.Pizza;

import java.util.Map;

public class PriceConsultant {
    private Pizza pizza;

    private Map<String,Double> masaPricesList = MasaPricesList.getInstance().getPricesList();
    private Map<String,Double> typesPricesList = TypesPricesList.getInstace().getPricesList();
    private Map<String,Double> extraIngredientsPricesList = ExtraIngredientsPricesList.getInstance().getPricesList();
    private Map<String,Double> toastPricesList ;
    private Map<String,Double> sizePricesList ;

    public PriceConsultant(Pizza pizza) {
        this.pizza = pizza;
    }

    public Double getMasaPrice() {
        Double doughtPrice = 0.0;
        for (Map.Entry<String,Double> masa  : masaPricesList.entrySet()){
            if(masa.getKey().equals(this.pizza.getDough())){
                doughtPrice = masa.getValue();
            }
        }
        sizePricesList =  SizePricesList.getInstace().getPricesList(doughtPrice);
        toastPricesList = ToastPricesList.getInstance().getPricesList(doughtPrice);
        return doughtPrice;
    }

    public Double getExtraIngredientsPrice() {
        Double extraIngredientsPrice = 0.0;
        for(String extraSelected : this.pizza.getExtraIngredients()){
            for (Map.Entry<String , Double > extra : extraIngredientsPricesList.entrySet()){
                if(extra.getKey().equals(extraSelected)){
                    extraIngredientsPrice += extra.getValue();
                }
            }
        }
        return extraIngredientsPrice;
    }
    public Double getTypePizzaPrice() {
        Double typeSelectedPrice = 0.0;
        for(Map.Entry<String,Double> type : typesPricesList.entrySet()){
            if(type.getKey().equals(this.pizza.getPizzaType())){
                typeSelectedPrice = type.getValue();
            }
        }
        return typeSelectedPrice ;
    }
    public Double getSizeSelectedPrice() {
        Double sizePrice = 0.0;
        for(Map.Entry<String,Double> size : sizePricesList.entrySet()){
            if(size.getKey().equals(this.pizza.getPizzaSize())){
                sizePrice = size.getValue();
            }
        }
        return sizePrice;
    }
    public Double getToastPrice(String typeOfToast , boolean toastIsSelected){
        Double toastPrice = 0.0 ;
        if(toastIsSelected) {
            toastPricesList = ToastPricesList.getInstance().getPricesList(getMasaPrice());
            for (Map.Entry<String, Double> toast : toastPricesList.entrySet()) {
                if (toast.getKey().equals(typeOfToast)) {
                    toastPrice = toast.getValue();
                }
            }
        }
        return toastPrice ;
    }



}

