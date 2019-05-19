
package controlador;

import java.awt.*; //para el frame y demas

import java.awt.event.*; //para los eventos

import java.util.*; //para el random
import javax.swing.JOptionPane;



public class MuroBerlin extends Frame implements WindowListener,  MouseListener, MouseMotionListener, Runnable {



    Panel panel= new Panel();

    int tx=220; // ubicacion en x de la barra donde rebota la pelota

    int ty; //ubicacion en y de la barra donde rebota la pelota

    int px; // ubicacion de la pelota en x

    int py; //ubicacion de la pelota en y

    int score=0; // puntos

    int vidas=4; //cantidad de vidas

    float incX=1; 

    float incY=1;

    //incX y incY son los que dicen si la pelota tiene que cambia de rumbo dependiendo si rebota en algun lado

    boolean [] filas=  new boolean[30]; //filas sirve para saber si la pelota entro dentro de las coordenadas de un ladrillo

    boolean inicio= false;

    Random r= new Random();

    

    /** creacion de una instancia de ladrillo */

    public MuroBerlin() {

    setSize(510, 400); // tamaño de la pantalla  
    setTitle("Jugando con la historia");
    setResizable(false);

    add(panel); //agregamos el panel

    panel.setBackground(Color.orange); //se pinta de negro

    panel.addMouseMotionListener(this); // evento de mover el mouse

    panel.addMouseListener(this); // click del mouse

    px= 260; 

    py = this.getHeight()-60;

    addWindowListener(this);//si se cierra la ventana

    for (int x=0; x!=30; x++){ 

        filas[x]=true;//inicializa las filas y las pone a todas en false

    }

    }

    

    

    

    public static void main (String [] Args){

    MuroBerlin arkanoid= new MuroBerlin();

    arkanoid.show();

    arkanoid.run();//llama al thread

    }

   

    

    public void dibujar(Color [] colores){

        Graphics g = panel.getGraphics();

        g.clearRect(0,0, this.getWidth(), this.getHeight()); //borra toda la pantalla

        g.setColor(Color.cyan); //color a la pelota

        g.fillOval((int)px,(int)py, 10,10); // pelota       

        g.setColor(Color.gray); //contorno de la pelotita

        g.drawOval((int)px,(int)py, 10,10); // contorno        

        g.fillRect((int)tx,(int) ty, 80, 20); //barra

        g.setColor(Color.white); //contorno de la barra

        g.drawRect((int)tx,(int) ty, 80, 20); //contorno

        g.setColor(Color.cyan); //color del texto

       

        g.drawString("Vidas:", 275, 15);

        g.setColor(Color.yellow);

        g.drawString("Juega derribando el muro ", 10,15 );

        g.setColor(Color.white); //color del texto

        switch(vidas){//muestra la cantidad de vida con unos rectangulos arriba de la pantalla 

            //si las vidas son 4 significa que recien eempieza el juego y aparece un mensaje

            case 4: g.drawString("Hola!!! Listo para jugar?", 230, 200);

                    g.drawString("Presione el boton del derecho del mouse para comenzar", 100, 220);

                    g.setColor(Color.white);

                    g.fillRect(320,5,15,10);

                    g.fillRect(340,5,15,10);

                    g.fillRect(360,5,15,10);

                    g.setColor(Color.red);

                    g.drawRect(320,5,15,10);

                    g.drawRect(340,5,15,10);

                    g.drawRect(360,5,15,10);

                    break;

            //si las vidas son 3 muestra 3 rectangulos arriba

            case 3: g.setColor(Color.yellow);

                    g.fillRect(320,5,15,10);

                    g.fillRect(340,5,15,10);

                    g.fillRect(360,5,15,10);

                    g.setColor(Color.red);

                    g.drawRect(320,5,15,10);

                    g.drawRect(340,5,15,10);

                    g.drawRect(360,5,15,10);

                    break;

            //si las vidas son 2 muestra 2 rectangulos arriba

            case 2: g.setColor(Color.white);

                    g.fillRect(320,5,15,10);

                    g.fillRect(340,5,15,10);

                    g.setColor(Color.red);

                    g.drawRect(320,5,15,10);

                    g.drawRect(340,5,15,10);

                    break;

            //si las vidas es 1 muestra 1 rectangulo arriba

            case 1: g.setColor(Color.white);

                    g.fillRect(320,5,15,10);

                    g.setColor(Color.red);

                    g.drawRect(320,5,15,10);

                    break;

            //si las vidas son 0 muestra que perdio

            case 0: g.drawString("Lo siento...Haz perdido :(", 210, 200); 

                    g.drawString("Vamos animate, intentalo de nuevo para conocer la historia", 100, 250);
                    g.drawString("Presiona el boton  derecho del mouse para volver a jugar", 100, 220); 
                    break;

        }

        g.setColor(Color.white); //color del texto

        g.drawString("Puntuacion:", 400, 15);

        g.drawString(String.valueOf(score), 470, 15); //te muestra la cantidad de puntos

        if (score==300){

        g.drawString("Felicidades...Haz ganado!!! :)", 230, 200); 

        g.drawString("Vamos a conocer su historia", 200, 220);

        g.drawString("Presiona el boton del derecho del mouse para volver a jugar", 100, 240); 
        
            JOptionPane.showMessageDialog(null, "Al finalizar la II Guerra Mundial, tras la división de Alemania, Berlín también quedó  dividida \n en cuatro sectores de ocupación: soviético, estadounidense, francés e inglés. Las malas relaciones entre los comunistas \n  y los aliados fueron creciendo hasta llegar al punto en que surgieron dos monedas, dos ideales políticos y, finalmente, dos alemanias. :(");
            JOptionPane.showMessageDialog(null,"El Muro de Berlín acabó por convertirse en una pared de hormigón de entre 3,5 y 4 metros de altura, \n con un interior formado por cables de acero para aumentar su resistencia. En la parte superior colocaron \n  una superficie semiesférica para que nadie pudiera agarrarse a ella.");
            JOptionPane.showMessageDialog(null,"Acompañando al muro, se creó la llamada \"franja de la muerte\", formada por un foso, \n  una alambrada, una carretera por la que circulaban constantemente vehículos militares, \n  sistemas de alarma, armas automáticas, torres de vigilancia y patrullas acompañadas por perros las 24 horas del día. \n Tratar de escapar era similar a jugar a la ruleta rusa con el depósito cargado de balas. Aun así, fueron muchos los que lo intentaron. ");
            JOptionPane.showMessageDialog(null,"La caída del muro vino motivada por la apertura de fronteras entre Austria y Hungría en mayo de 1989, \n ya que cada vez más alemanes viajaban a Hungría para pedir asilo en las distintas embajadas de la República Federal Alemana.\n  Este hecho, motivó enormes manifestaciones en Alexanderplatz que llevaron a que, el 9 de noviembre de 1989 el gobierno de la \n  RDA afirmara que el paso hacia el oeste estaba permitido.");
            JOptionPane.showMessageDialog(null," Al día siguiente, se abrieron las primeras brechas en el muro y comenzó la cuenta atrás para el final de sus días.\n Una vez liberados, familias y amigos pudieron volver a verse después de 28 años de separación forzosa.Peroo... \n Donde puedes ver los restos? \n La parte más importante que se ha mantenido en pie se encuentra en la zona conocida como East Side Gallery.\n  Allí se pueden recorrer 1,3 kilómetros del muro \n decorado con impresionantes pinturas que reflejan multitud de acontecimientos relacionados con el muro.");
            vidas=4; //se reinicializa las vidas

        }

       //se  dibujan los ladrillos de colores de arriba       

       Graphics [] gl = new Graphics [30];

       //inicializamos todo

       int xp= 0;

       int yp= 30;

       int c=0; //este contador indica cuando hay que dibujar en la siguiente fila

       for (int x=0; x!=30; x++){

         gl[x]= panel.getGraphics(); //se inicializa el graficador 

         c++; //se suma uno al contador

         if (c==11){ //porque son 10 ladrillos por columna

         xp=0;

         yp=50; //hace que la proxima fila sea 20 pixeles mas abajo que la anterior

         }//fin del if c==11

         if (c==21){

         xp=0;

         yp=70; //hace que la proxima fila sea 20 pixeles mas abajo que la anterior

         }// fin del if c==21

         gl[x].setColor(colores[x]); //le asignamos los colores a cada uno de los ladrillos

         if (filas[x]==true){ //si es true se pintan los ladrillos sino se borra el espacio

            gl[x].fillRect(xp,yp,48,15);

            gl[x].setColor(Color.white);

            gl[x].drawRect(xp,yp,48,15);

         }//fin del if

         else{

             g.clearRect(xp,yp, 48, 15);

             }//fin del else

         xp+=50; //hacemos que se corra 50 px para la derecha para que pueda seguir agregando por columna

        

        }//fin del for

      

    }//fin del dibujar()

    

        public void mover(){

        if (inicio==false){

        }

        else{

        //inicializamos los ejes de la pelota

        px += 5*incX;

        py += 5*incY;

        }

        if (py>this.getHeight()){ //si es mas bajo que la barra

            vidas--;//le restamos una vida

            px= 260;//inicializamos el eje x de la pelotita

            tx=220;//inicializamos el eje x de la barra

            py = this.getHeight()-60; //inicializamos el eje y de la pelotita

            inicio=false; //le asignamos a inicio el false

        }

    

         //para que rebote en las paredes y el piso

               if ((px<0)||(px>this.getWidth()-20)){

            incX *= -1; //se multiplica por -1 al eje x hace que cambie totalmente el rumbo de la pelota

            }

         if (py<20){

            incY *= -1; //se multiplica por -1 al eje y hace que cambie totalmente el rumbo de la pelota

             }



         //para que rebote en la barra

        

         if ((py==ty)&&(tx<px)&&(px<tx+80)){

            incY *=-1;

            //para los rebotes en las esquinas de la barra

            if ((px<tx+20)&&(incX>0)){

                incX *=-1.5;

            }

            if ((px>tx+60)&&(incX<0)){

                incX*=-1.5;

            }

       

        }     

       //verifica donde pasa la pelota y si pega en un ladrillo

       //lo hace dasaparecer y cambia el rumbo(o se rebota))

       if ((py<74) && (py>56)){

          if (px<48){

              if (filas[20]==true){

                  filas[20]=false;

                  incY*=-1;

                  score+=10;;

              }

              }else if ((px<98)&&(px>48)){

              if (filas[21]==true){

                  filas[21]=false;

                  incY*=-1;

                  score+=10;

              }

              }else if  ((px<148)&&(px>98)){

              if (filas[22]==true){

                  filas[22]=false;

                  incY*=-1;

                  score+=10;;

              }

              }else if ((px<198)&&(px>148)){

              if (filas[23]==true){

                  filas[23]=false;

                  incY*=-1;

                  score+=10;;

              }

              }else if ((px<248)&&(px>198)){

              if (filas[24]==true){

                  filas[24]=false;

                  incY*=-1;

                  score+=10;

              }

              }else  if ((px<298)&&(px>248)){

              if (filas[25]==true){

                  filas[25]=false;

                  incY*=-1;

                  score+=10;;

              }

              }else if ((px<348)&&(px>298)){

              if (filas[26]==true){

                  filas[26]=false;

                  incY*=-1;

                  score+=10;;

                  

              }

              }else if ((px<398)&&(px>348)){

              if (filas[27]==true){

                  filas[27]=false;

                  incY*=-1;

                  score+=10;;

              }

              }else if ((px<448)&&(px>398)){

              if (filas[28]==true){

                  filas[28]=false;

                  incY*=-1;

                  score+=10;;

              }

              }else if (filas[29]==true){

                    filas[29]=false;

                    incY*=-1;

                    score+=10;;

                     }

          

       

       }

         if ((py<58) && (py>40)){

          if (px<48){

              if (filas[10]==true){

                  filas[10]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<98)&&(px>48)){

              if (filas[11]==true){

                  filas[11]=false;

                  incY*=-1;  

                  score+=10;;

              }

          }

          if ((px<148)&&(px>98)){

              if (filas[12]==true){

                  filas[12]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<198)&&(px>148)){

              if (filas[13]==true){

                  filas[13]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<248)&&(px>198)){

              if (filas[14]==true){

                  filas[14]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<298)&&(px>248)){

              if (filas[15]==true){

                  filas[15]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<348)&&(px>298)){

              if (filas[16]==true){

                  filas[16]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<398)&&(px>348)){

              if (filas[17]==true){

                  filas[17]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<448)&&(px>398)){

              if (filas[18]==true){

                  filas[18]=false;

                  score+=10;;

              }

          }

          if ((px<598)&&(px>448)){

              if (filas[19]==true){

                  filas[19]=false;

                  incY*=-1;

                  score+=10;;

              }

       

          }

          }

          if ((py<43) && (py>24)){

          if (px<48){

              if (filas[0]==true){

                  filas[0]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<98)&&(px>48)){

              if (filas[1]==true){

                  filas[1]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<148)&&(px>98)){

              if (filas[2]==true){

                  filas[2]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<198)&&(px>148)){

              if (filas[3]==true){

                  filas[3]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<248)&&(px>198)){

              if (filas[4]==true){

                  filas[4]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<298)&&(px>248)){

              if (filas[5]==true){

                  filas[5]=false;

                  incY*=-1;

                  score+=10;

                  

              }

          }

          if ((px<348)&&(px>298)){

              if (filas[6]==true){

                  filas[6]=false;

                  incY*=-1;

                  score+=10;

              }

          }

          if ((px<398)&&(px>348)){

              if (filas[7]==true){

                  filas[7]=false;

                  incY*=-1;

                  score+=10;  

              }

          }

          if ((px<448)&&(px>398)){

              if (filas[8]==true){

                  filas[8]=false;

                  incY*=-1;

                  score+=10;

              }

          }

          if ((px<598)&&(px>448)){

              if (filas[9]==true){

                  filas[9]=false;

                  incY*=-1;

                  score+=10;

                  

              }

       

          }

      }

        //para que la barra no salga del frame(o se de la ventana)

        if (tx>this.getWidth()-80){

            tx=this.getWidth()-80;

        }

        

        ty = this.getHeight()-50; //el eje y por el que se mueve la barra 



    }

        

    public void run() {

    Color [] colores= new Color[30];//colores para los ladrillos

    for (int x=0; x!=30; x++){

        colores[x]=new Color (r.nextInt(256),r.nextInt(256),r.nextInt(256));

        //se asignan los colores

    }

    while ((true)&&(score!=300)){

        this.mover(); //rebote y tocar ladrillos   

        this.dibujar(colores); //dibuja todo 

        try{

            Thread.sleep(50);

        }

        catch (InterruptedException IE){}

    }//fin del while

    }

    

    public void mouseDragged(MouseEvent e) {

    }

    

    public void mouseMoved(MouseEvent e) {

        if (inicio==false){

            px=e.getX()+40;}//se inicializa la pelota para que este arriba de la barra

        tx= e.getX();// da coordenadas  del eje x de la barra o sea que si se mueve el mouse para la  derecha la barra va para la derecha

 

    }

    

    public void windowActivated(WindowEvent e) {

    }

    

    public void windowClosed(WindowEvent e) {

    }

    

    public void windowClosing(WindowEvent e) {

        System.exit(0); //cierra la ventana cuando se da clic  en la X

    }

    

    public void windowDeactivated(WindowEvent e) {

    }

    

    public void windowDeiconified(WindowEvent e) {

    }

    

    public void windowIconified(WindowEvent e) {

    }

    

    public void windowOpened(WindowEvent e) {

    }

    

    public void mouseClicked(MouseEvent e) {

    if (vidas==4){

        vidas--;//si las vidas son 4 cuando hace un click se le elimina uno(lo de 4 solo es para mostar un mensaje)

    }

    if (vidas==0){

        vidas=4;//vuelve a empezar 

        score=0;//el puntaje tb se inicializa

        for (int x=0; x!=30; x++){

        filas[x]=true; // se inicializa las filas

        }

    }

    inicio=true; 

    }

    

    public void mouseEntered(MouseEvent e) {

    }

    

    public void mouseExited(MouseEvent e) {

    }

    

    public void mousePressed(MouseEvent e) {

    }

    

    public void mouseReleased(MouseEvent e) {

    }

    

}//fin de la clase
