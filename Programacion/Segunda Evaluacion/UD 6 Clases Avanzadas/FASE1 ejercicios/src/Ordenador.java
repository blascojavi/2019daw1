import java.util.HashMap;
import java.util.Map;

public class Ordenador {
    private static int id = 0;
    private Map<String , String> nameAndSo = new HashMap<>();
    private String typeOfProcessor ;
    private Integer amountRam ;

    public Ordenador(String name , String so ,String processor ,Integer ram){
        nameAndSo.put(name,so);
        this.typeOfProcessor = processor;
        this.amountRam = ram;
        id++;
    }


    public Integer numerodeOrdenadores(){
        return id;
    }


    @Override
    public String toString() {
        return "Ordenador{" +
                "nameAndSo=" + nameAndSo +
                ", typeOfProcessor='" + typeOfProcessor + '\'' +
                ", amountRam=" + amountRam +
                '}';
    }
}
