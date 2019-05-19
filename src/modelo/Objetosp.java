package modelo;

public class Objetosp {
   private String preguntaa;
  
   public Objetosp(){
    
    }
    public Objetosp(String preguntaa) {
        this.preguntaa = preguntaa;
    }
    
    public String getPregunta() {
        return preguntaa;  
    }

    public void setPregunta(String preguntaa) {
        this.preguntaa = preguntaa;
    }
   
    public String toString(){
        return "Pregunta: "+preguntaa;
    }
    
   
}
