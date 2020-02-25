import java.util.Comparator;

public class Rectangulo extends Figura implements   Comparable<Rectangulo> {
    private double alto;
    private double ancho;


    public Rectangulo(double alto , double ancho ){
        super();
        super.setFiguraEnLista(this);
        this.alto = alto ;
        this.ancho = ancho;
    }

    @Override
    public double area() {
        return alto + ancho;
    }

    @Override
    public void setColor(String color) {
        super.color = color;
    }

    @Override
    public String toString() {
        return "Rectangulo{" +
                "alto=" + alto +
                ", ancho=" + ancho +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public int compareTo(Rectangulo otroRect) {
        int valueOf = 0;
        if(this.ancho > otroRect.ancho ){
            valueOf =  -1;
        }else if(this.ancho == otroRect.ancho ){
            valueOf =  0;
        }else if(this.ancho < otroRect.ancho ){
            valueOf =  valueOf;
        }
        return -1;
    }
}
