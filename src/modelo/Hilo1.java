package modelo;


import modelo.Board2;

public class Hilo1 extends Thread{
    
//Calculate the duration in which you make the movements   
    int  minutes=0, seconds=0;
    public void run() {
        try{
         while(true){ 
           synchronized(Board2.time){
             if(seconds==59) { seconds=0; minutes++; }            
               seconds++;
                 if(seconds>9)
                   Board2.time.setText(minutes+":"+seconds);
                 else
                   Board2.time.setText(minutes+":0"+seconds);
                    this.sleep(1000); }
         }
        }
        catch (InterruptedException e) { System.out.println(e.getMessage()); }
    }
}        
    
    
    
    
    
    




