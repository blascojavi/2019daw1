
package coche;

public class Coche {
    private String modelo ; 
    private String color; 
    private boolean metalizada; 
    private String matricula; 
    private String tipoCoche[] = {"mini","utilitario","familiar","deportivo"};
    private String tipoSeleccionado; 
    private int aFabricacion;
    private String tipoSeguro[] = {"a todo riesgo", "a terceros"}; 
    private String seguro ; 
    
    
    public Coche(String matricula, String modelo){
        this.matricula = matricula;
        this.modelo = modelo; 
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isMetalizada() {
        return metalizada;
    }

    public void setMetalizada(boolean metalizada) {
        this.metalizada = metalizada;
    }

    public String[] getTipoCoche() {
        return tipoCoche;
    }

    public void setTipoCoche(int indiceCoche ) {
       this.tipoSeleccionado =  this.tipoCoche[indiceCoche]; 
        
    }

    public int getaFabricacion() {
        return aFabricacion;
    }

    public void setaFabricacion(int aFabricacion) {
        this.aFabricacion = aFabricacion;
    }

    public String[] getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(int indiceSeleccionado) {
        this.seguro = this.tipoSeguro[indiceSeleccionado];
    }
    
    public String verDatosBasicos(){
            
        
        return "El coche matricula " + this.matricula + " Modelo " + this.modelo 
                + " es de color " + this.color + "\n " 
                + " Color metalizado : " + this.metalizada  + "\n" 
                + " Tipo de coche :" + this.tipoSeleccionado + "\n"
                + " Año de fabricación: " + this.aFabricacion;
    } 
    
    
    
}
