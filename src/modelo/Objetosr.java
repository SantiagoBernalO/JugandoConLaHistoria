package modelo;



public class Objetosr {
   private String respuestaa;
   
   
   public Objetosr(){
       
   }

    public Objetosr(String respuestaa) {
        this.respuestaa = respuestaa;
    }

    public String getRespuestaa() {
        return respuestaa;
    }

    public void setRespuestaa(String respuestaa) {
        this.respuestaa = respuestaa;
    }
   
    public String toString(){
        return respuestaa;
    }
   
}
