package modelo;

public class Objetosin {
    private String ingresado;

    public Objetosin() {
    }

    public Objetosin(String ingresado) {
        this.ingresado = ingresado;
    }

    public String getIngresado() {
        return ingresado;
    }

    public void setIngrsado(String ingresado) {
        this.ingresado = ingresado;
    }
    
    public String toString(){
        return ingresado;
    }
}
