import java.util.Comparator;

public class Circulo implements Comparable<Circulo> {
    private double r ;

    public Circulo(double radio){
        this.r = radio ;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "r=" + this.r +

                '}';
    }

    @Override
    public int compareTo(Circulo circulo) {
        return 0;
    }
}
