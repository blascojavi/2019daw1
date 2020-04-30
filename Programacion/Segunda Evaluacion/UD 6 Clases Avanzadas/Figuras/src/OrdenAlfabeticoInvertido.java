import java.util.Comparator;

public class OrdenAlfabeticoInvertido implements Comparator<Rectangulo> {
    @Override
    public int compare(Rectangulo r1, Rectangulo r2) {
        int valueOf = r1.color.compareTo(r2.color);
        return valueOf;
    }
}
