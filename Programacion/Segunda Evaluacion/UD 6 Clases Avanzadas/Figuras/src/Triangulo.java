public class Triangulo extends Figura {

    private final double base;
    private final double altura;

    public Triangulo(double base , double altura){
        super();
        super.setFiguraEnLista(this);
        this.base = base ;
        this.altura = altura ;
    }
    public void setColor(String color){
        super.color = color ;
    }

    @Override
    public double area() {
        return ( base * altura ) /2;
    }

    @Override
    public String toString() {
        return "Triangulo{" +
                "base=" + base +
                ", altura=" + altura +
                ", color='" + color + '\'' +
                '}';
    }


}
