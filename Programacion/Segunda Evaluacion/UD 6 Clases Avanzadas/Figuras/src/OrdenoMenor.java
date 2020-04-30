import java.util.Comparator;

public class OrdenoMenor implements Comparator<Circulo> {


    @Override
    public int compare(Circulo circulo, Circulo otroCirculo) {
        int valueOf = 0 ;
        if(circulo.getR() < otroCirculo.getR()){
            valueOf = 1;
        }
         if(circulo.getR() == otroCirculo.getR()){
            valueOf = -1;
        }
         if(circulo.getR() > otroCirculo.getR()){
            valueOf = -1;
        }
         return valueOf;

    }
}
