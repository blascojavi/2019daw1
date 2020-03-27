package MODEL;

import CONTROLLER.TablePricesNotExsits;

public class PriceBoard {

    public InterfaceTablePrices getList(String table){
        if(table instanceof ExtraIngredientsPricesList) {
            return  ExtraIngredientsPricesList.getInstance();
        }
        if(table instanceof MasaPrices) {
            return new MasaPrices();
        }
        if(table instanceof SizePricesList) {
            return new SizePricesList();
        }
        if(table instanceof TypesPrices){
            return new TypesPrices();
        }
        return new TablePricesNotExsits("No existe este tipo de tabla de precios") ;
    }


}
