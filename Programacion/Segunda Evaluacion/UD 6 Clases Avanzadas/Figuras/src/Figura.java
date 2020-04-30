import java.util.ArrayList;
import java.util.List;

public abstract class Figura{
    protected String color ;
    protected static List<Figura> listadoFiguras = new ArrayList<>();

    public abstract double area();

    public abstract void setColor(String color);

    public static List<Figura> getListadoDeFiguras(){
        return listadoFiguras;
    }

    public void setFiguraEnLista(Figura figura){
        listadoFiguras.add(figura);
    }


}
