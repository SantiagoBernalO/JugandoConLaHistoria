package modelo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class Board2 extends JFrame{
    
     int contp=0, pul=0, random[], posi[][];
     JPanel panel, panelbtn;
     JLabel tab[][], tab1[][];     
     int clic11, clic12, clic21, clic22;     
     Icon imgs[], fnd;
     JLabel nom;      
     static JLabel time;
     Thread tm;
     JButton rem, btnlista;
     Board2 t2;
     File fw;
     BufferedWriter wr;    
     
     static DefaultListModel dl;
     
     public Board2()
     {        
       dl = new DefaultListModel();  
       
       this.setLayout(null);
       this.setBounds(180, 5, 1000, 650); 
   
       
       panel = new JPanel();
       panel.setLayout(null);
       panel.setBounds(75,20,559,559);
       panel.setBackground(Color.blue);
       
       panelbtn = new JPanel();
       panelbtn.setLayout(null);
       panelbtn.setBounds(735,54,150,80);
       panelbtn.setBackground(Color.blue);
       
       nom = new JLabel("sfsdf");
       nom.setBounds(735, 150, 100, 30);
       nom.setText(Index.nom);
       this.add(nom);
       random = new int[16];
       posi = new int[4][4];       
      
       
       rem = new JButton("Juego Nuevo");
       rem.setBounds(10, 5, 130, 30); 
       rem.setBackground(Color.cyan);
       
       btnlista = new JButton("Puntajes Altos");
       btnlista.setBounds(10, 40, 130, 30);    
       btnlista.setBackground(Color.cyan);
       
       time = new JLabel("Tiempo");
       tab = new JLabel[4][4];
       tab1 = new JLabel[4][4];
       imgs = new Icon[16];   
       fnd = new ImageIcon(getClass().getResource("/imagenes/f.jpg"));
       lab();
       
       
       
       tm = new Thread(new Hilo1());
       for (int i=0; i<4; i++)
       {
           for (int j=0; j<4; j++)
           {
              tab[i][j].setBounds(j*135+17, i*135+17, 125, 125);
              tab1[i][j].setBounds(j*135+17, i*135+17, 125, 125);
           }
       }      
       time.setBounds(800, 0, 70, 70);
       
      
       
       
       for (int i=0; i<4; i++)
       {
           for (int j=0; j<4; j++)
           {      
             panel.add(tab1[i][j]);
           }
       }
       
       for (int i=0; i<4; i++)
       {
           for (int j=0; j<4; j++)
           {      
             panel.add(tab[i][j]);
           }
       }     
       
       
       
       
       rem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {  
               
               st();                
               reini();
               t2.nom.setText(JOptionPane.showInputDialog("Nombre")); 
                
           }
        });  
       
       
       
       btnlista.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {        
                Main.l.setVisible(true);
                listaord();
            }
        });       
       
       
       
       this.add(time);             
       this.add(panel);
       panelbtn.add(rem);
       //panelbtn.add(btnlista);
       this.add(panelbtn);
       play();
     }
     
     private void lab()
     {
         for (int i=0; i<4; i++)
       {
          for (int j=0; j<4; j++)
          {            
            tab[i][j] = new JLabel();      
            tab1[i][j] = new JLabel();                       
          }
       }
     }
     
     public void win()
     {
       int score=5270,ti;
       String p, t, t1, t2;
      if(!tab1[0][0].isVisible() && !tab1[0][1].isVisible() && !tab1[0][2].isVisible() && !tab1[0][3].isVisible() && !tab1[1][0].isVisible() && !tab1[1][1].isVisible() && !tab1[1][2].isVisible() && !tab1[1][3].isVisible() && !tab1[2][0].isVisible() && !tab1[2][1].isVisible() && !tab1[2][2].isVisible() && !tab1[2][3].isVisible() && !tab1[3][0].isVisible() && !tab1[3][1].isVisible() && !tab1[3][2].isVisible() && !tab1[3][3].isVisible() )
      {       
          p= time.getText();
          if(p.length()==4)
          {
           t1 = p.substring(0,1);
           t2 = p.substring(2);
          }
          else
          {
              t1 = p.substring(0,2);
              t2 = p.substring(3);
          }
          
          t= t1+t2;
          ti = Integer.parseInt(t);
          score = (score-(pul*17))-((ti*7)/4);   
          JOptionPane.showMessageDialog(this,"Felicitaciones! Lo has logrado.");
          JOptionPane.showMessageDialog(this,"La Segunda Guerra Mundial fue un conflicto militar global que se desarrolló entre 1939 y 1945.\n"+" En este se vieron implicadas la mayor parte de las naciones del mundo.");
          JOptionPane.showMessageDialog(this,"Fue la mayor contienda bélica de la historia, con mas de cien millones de militares movilizados\n y un estado de guerra total en que los grandes contendientes destinaron toda su capacidad economica,\n militar y cientifica al servicio del esfuerzo belico, borrando la distincion entre recursos civiles y militares.\n Marcada por hechos de enorme repercusion que incluyeron la muerte masiva de civiles,\n el Holocausto, los bombardeos intensivos sobre ciudades y el uso, por única vez, de armas nucleares en un conflicto militar,\n la Segunda Guerra Mundial fue el más mortífero en la historia con un resultado de entre 50 y 70 millones de víctimas, el 2,5% de la población mundial.");
          JOptionPane.showMessageDialog(this,"intentos : "+pul);
          JOptionPane.showMessageDialog(this,"tiempo : "+ti+"  Segundos");
          JOptionPane.showMessageDialog(this,"puntaje : "+ score+"  Puntos");           
          
          List.dl.addElement(score+"   "+nom.getText());
          try
          {
              fw = new File("src/imagenes/file.txt");              
              wr = new BufferedWriter(new FileWriter(fw,true));
              wr.write("\n"+score+"   "+nom.getText());
              wr.close();        
          }
          catch(IOException e)
          {
              e.printStackTrace();
          }
          listaord();
      }      
    }
     
     public void listaord()
     {
         int elem = List.dl.size();
          if (elem == 2)
          {
              int aux;
              String cad1 =List.dl.getElementAt(0).toString();
              String subcad1 =cad1.substring(0, 4);
              int num1 =Integer.parseInt(subcad1);
              
              String auxnom;
              
              String cad2 =List.dl.getElementAt(1).toString();
              String subcad2 =cad2.substring(0, 4);
              int num2 =Integer.parseInt(subcad2);
              
              if (num1<num2)
              {                  
                  aux =num2;
                  auxnom=cad2;
                  List.dl.setElementAt(auxnom, 0);
                  List.dl.setElementAt(cad1, 1);
              }
          }
          if(elem>2)
          {
              String c="", c1="";
              for (int i=2; i<=elem; i++)
              {
                for (int j=0; j<(elem-1); j++)
                {
                    String cad1 =List.dl.getElementAt(j).toString();
                    String subcad1 =cad1.substring(0, 4);  
                    subcad1 =subcad1.replaceAll(" ", "");
                    int num1 =Integer.parseInt(subcad1);
                    
                    String cad2 =List.dl.getElementAt(j+1).toString();                   
                    String subcad2 =cad2.substring(0, 4);
                    subcad2 =subcad2.replaceAll(" ", "");
                    int num2 =Integer.parseInt(subcad2);
                   
                    if(num1<num2)
                    {                        
                        String auxnom =cad2;
                        List.dl.setElementAt(auxnom, j);
                        List.dl.setElementAt(cad1, j+1);
                    }
                }
              }
          }
     }
     
     public void random()
     {
        int s=0;
        while (s<16)
        {
           
          int num = (int)(Math.random()*(17-1)+1);
          int cont = 0;
          
        
          for (int pos=0;pos<16;pos++)
          {
              if (random[pos] != num)
              {
                  cont=cont+1;
                 
              }
            
          }
          
          
              if (cont == 16)
              {
                  random[s]=num;
                  s++;
                 
              }
              
          
      }
     }
     
     public void imagen()
     {
       int h=0;
       for (int i=0; i<16; i++)
       {
           if (random[h]>8)
               random[h]=random[h]-8;
          imgs[i]=new ImageIcon(getClass().getResource("/imagenes/s"+random[h]+".jpg")); 
          
          h++;
       }       
       
       int pos =0;
       for(int i=0; i<4; i++)
       {
           for(int j=0; j<4; j++)
           {
               posi[i][j]=(random[pos]);               
               pos++;
           }
           
       }
       
       int cont=1;
       for (int i=0; i<4; i++)
       {
          for (int j=0; j<4; j++)
          {         
            tab[i][j].setIcon(imgs[cont-1]);    
            tab1[i][j].setIcon(fnd);                      
            cont++;
            if(cont>16)
                cont=1;
          }
       }   
     }
     
     
     public void eventos()
     {
       
         tab1[0][0].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic11=0;
                clic12=0;
                tab1[clic11][clic12].setVisible(false);                
                contp++;
                
                
                    
                 panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                    if(contp==2)
                    {
                         pul++;   
                         if(posi[clic11][clic12] == posi[clic21][clic22])
                         {
                           tab1[clic11][clic12].setVisible(false);
                           tab1[clic21][clic22].setVisible(false);       
                           contp=0;
                           win();
                         }
                        else
                        {
                           tab1[clic21][clic22].setVisible(true);
                           tab1[clic11][clic12].setVisible(true);  
                           contp=0;
                        }                
                     }                 
                    else
                    {
                      clic11=0;
                      clic12=0;
                    }
                
               }
               });                   
                   
            }        
            
        });
       
      
      
            tab1[0][1].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=0;
                clic22=1;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
                
               panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;                    
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                    
                    }
                    contp=0;
                    
                }
                else
                {
                    clic11=0;
                    clic12=1;
                }
                
            }
        });
                }        
            
        });
            
            
             tab1[0][2].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=0;
                clic22=2;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                    
                    }
                    contp=0;
                }
                else
                {
                    clic11=0;
                    clic12=2;
                }
                
            }
        });
              }        
            
        });
             
             tab1[0][3].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=0;
                clic22=3;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                    
                    }
                    contp=0;
                }
                else
                {
                    clic11=0;
                    clic12=3;
                }
                
            }
        });
              }        
            
        });
          
             
             tab1[1][0].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=1;
                clic22=0;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                  
                    }
                    contp=0;
                }
                else
                {
                    clic11=1;
                    clic12=0;
                }
               
            }
        });
             }        
            
        });
             
             
             tab1[1][1].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=1;
                clic22=1;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                   
                    }
                    contp=0;
                }
                else
                {
                    clic11=1;
                    clic12=1;
                }
                
            }
        });
}        
            
        });
      
      tab1[1][2].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=1;
                clic22=2;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
                panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                  
                    }
                    contp=0;
                }
                else
                {
                    clic11=1;
                    clic12=2;
                }
              
            }
        });
}        
            
        });
      
       tab1[1][3].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=1;
                clic22=3;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                  
                    }
                    contp=0;
                }
                else
                {
                    clic11=1;
                    clic12=3;
                }
               
            }
        });
}        
            
        });
       
       tab1[2][0].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=2;
                clic22=0;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                  
                    }
                    contp=0;
                }
                else
                {
                    clic11=2;
                    clic12=0;
                }
               
            }
        });
}        
            
        });
       
       tab1[2][1].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=2;
                clic22=1;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                   
                    }
                    contp=0;
                }
                else
                {
                    clic11=2;
                    clic12=1;
                }
              
            }
        });
}        
            
        });
       
       tab1[2][2].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=2;
                clic22=2;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                  
                    }
                    contp=0;
                }
                else
                {
                    clic11=2;
                    clic12=2;
                }
              
            }
        });
}        
            
        });
       
       tab1[2][3].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=2;
                clic22=3;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
                panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                  
                    }
                    contp=0;
                }
                else
                {
                    clic11=2;
                    clic12=3;
                }
               
            }
        });
}        
            
        });
       
       tab1[3][0].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=3;
                clic22=0;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
                panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                   
                    }
                    contp=0;
                }
                else
                {
                    clic11=3;
                    clic12=0;
                }
               
            }
        });
}        
            
        });
       
       tab1[3][1].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=3;
                clic22=1;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                       win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                    
                    }
                    
                }
                else
                {
                    clic11=3;
                    clic12=1;
                }
              
            }
        });
}        
            
        });
       
       tab1[3][2].addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=3;
                clic22=2;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
                panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                  
                    }
                    contp=0;
                }
                else
                {
                    clic11=3;
                    clic12=2;
                }
               
            }
        });
}        
            
        });
       
       tab1[3][3].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=3;
                clic22=3;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
             panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                   
                    }
                    contp=0;
                }
                else
                {
                    clic11=3;
                    clic12=3;
                }
               
            }
        });
}        
            
        });
       
     }
     
     public void play()
     {       
       random();
       imagen();
       eventos();
       
       tm.start();
     }
     
     public void st()
     {   
         tm.suspend();
         tm=null;
     }
     
     public void reini()
     {        
         setVisible(false);
         dispose();
         tm=null;    
         
         
         t2 = new Board2();
         t2.setVisible(true);
     }
     
      
     
     public void image2()
     {
       int h=0;
       for (int i=0; i<16; i++)
       {
           if (random[h]>8)
               random[h]=random[h]-8;
           imgs[i]=null;
          h++;
       }       
       
       int pos =0;
       for(int i=0; i<4; i++)
       {
           for(int j=0; j<4; j++)
           {
               posi[i][j]=0;              
               pos++;
           }
           
       }
       
       int cont=1;
       for (int i=0; i<4; i++)
       {
          for (int j=0; j<4; j++)
          {         
            tab[i][j].setIcon(null);    
            tab1[i][j].setIcon(null);                      
            cont++;
            if(cont>16)
                cont=1;
          }
       }   
     }
     public void events2()
     {        
        
        for (int i=0; i<4; i++)
        {
            for (int j=0; j<4; j++)
            {
                tab[i][j].removeMouseListener(null);
                tab1[i][j].removeMouseListener(null);
                tab[i][j].removeAll();
                tab1[i][j].removeAll();
                contp=0;
                tab1[i][j].repaint();
            }
        }
        panel.removeMouseMotionListener(null);
        panel.removeMouseListener(null);
     }
     public void random2()
     {
          random = new int[16];
     } 
}
