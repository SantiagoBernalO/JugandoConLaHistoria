/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Camilo Preciado
 */
public class Interface extends JFrame implements ActionListener{
    int fallos=9;
    int op=1;
    String palabraSeleccionada;
    String respuesta="";
    String[] palabra;
    
    
    //funciones para pistas
    JLabel titulopistas;
    JTextArea pistas;
    JButton anterior;
    JButton siguiente;
    
    //palabra
    JLabel palabrasel;
    
    //muñeco
    JLabel poste1, poste2, poste3,poste4,poste5,poste6,poste7,poste8;
    JLabel varilla1,varilla2,varilla3,varilla4,varilla5,varilla6,varilla7,varilla8,varilla9,varilla10;
    JLabel cabeza;
    JLabel cuerpo1,cuerpo2;
    JLabel brazoi,brazod;
    JLabel piernai,piernad;
    
    //letra usuario
    JLabel titulou;
    JLabel estadot;
    JTextField letrau;
    JTextField estado;
    JButton enviar;
    
    public Interface(){
    this.getContentPane().setBackground(Color.orange);
    setBounds(450, 80, 460, 500);
    setLayout(null);
    setResizable(false);
    
    //Pistas
    titulopistas=new JLabel("Pistas Palabras");
    titulopistas.setBounds(170, 20, 100, 20);
    
    pistas=new JTextArea();
    pistas.setBackground(Color.orange);
    Font aux=pistas.getFont(); 
    pistas.setFont(new Font(aux.getFontName(), aux.getStyle(), 15));
    pistas.setBounds(40, 40, 400, 45);
    
    anterior = new JButton("Anterior");
    anterior.setBounds(30, 100, 100, 20);
    anterior.addActionListener(this);
    
    siguiente = new JButton("Siguiente");
    siguiente.setBounds(310, 100, 100, 20);
    siguiente.addActionListener(this);
    
    //palabra elegida
    palabrasel =new JLabel("");
    palabrasel.setBounds(160, 155, 200, 40);
    Font auxFont=palabrasel.getFont(); 
    palabrasel.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
    
    //Muñeco de ahorcado
    poste1=new JLabel("");
    poste1.setBounds(170, 270, 20, 30);
    
    poste2=new JLabel("");
    poste2.setBounds(170, 259, 20, 30);
    
    poste3=new JLabel("");
    poste3.setBounds(170, 248, 20, 30);
    
    poste4=new JLabel("");
    poste4.setBounds(170, 237, 20, 30);
    
    poste5=new JLabel("");
    poste5.setBounds(170, 226, 20, 30);
    
    poste6=new JLabel("");
    poste6.setBounds(170, 215, 20, 30);
    
    poste7=new JLabel("");
    poste7.setBounds(170, 204, 20, 30);
    
    varilla1=new JLabel("");
    varilla1.setBounds(171, 194, 20, 30);
    
    varilla2=new JLabel("");
    varilla2.setBounds(178, 194, 20, 30);
    
    varilla3=new JLabel("");
    varilla3.setBounds(185, 194, 20, 30);
    
    varilla4=new JLabel("");
    varilla4.setBounds(192, 194, 20, 30);
   
    varilla5=new JLabel("");
    varilla5.setBounds(199, 194, 20, 30);
    
    varilla6=new JLabel("");
    varilla6.setBounds(206, 194, 20, 30);
    
    varilla7=new JLabel("");
    varilla7.setBounds(213, 194, 20, 30);
  
    varilla8=new JLabel("");
    varilla8.setBounds(220, 194, 20, 30);
    
    varilla9=new JLabel("");
    varilla9.setBounds(227, 194, 20, 30);
    
    varilla10=new JLabel("");
    varilla10.setBounds(234, 194, 20, 30);
    
    poste8=new JLabel("");
    poste8.setBounds(239, 204, 20, 30);
    
    cabeza=new JLabel("");
    cabeza.setBounds(236, 215, 20, 30);
    
    cuerpo1=new JLabel("");
    cuerpo1.setBounds(239, 224, 20, 30);
    
    cuerpo2=new JLabel("");
    cuerpo2.setBounds(239, 235, 20, 30);
    
    brazoi=new JLabel("");
    brazoi.setBounds(236, 227, 20, 30);
    
    brazod=new JLabel("");
    brazod.setBounds(242, 227, 20, 30);
    
    piernai=new JLabel("");
    piernai.setBounds(236, 245, 20, 30);
    
    piernad=new JLabel("");
    piernad.setBounds(242, 245, 20, 30);
    
    
    //letra usuario
    titulou= new JLabel("Digite la letra o espacio a enviar:");
    titulou.setBounds(90, 310, 200, 20);
    
    letrau =new JTextField("");
    letrau.setBounds(170, 340, 25, 20);
    
    estadot= new JLabel("Comprobacion letra");
    estadot.setBounds(290, 310, 150, 20);
    
    estado =new JTextField("");
    estado.setBounds(340, 340, 25, 20);
    
    enviar = new JButton("Enviar");
    enviar.setBounds(130, 370, 100, 20);
    enviar.addActionListener(this);
    
    add(titulopistas);
    add(pistas);
    add(anterior);
    add(siguiente);
    add(palabrasel);
    
    
    add(poste1);
    add(poste2);
    add(poste3);
    add(poste4);
    add(poste5);
    add(poste6);
    add(poste7);
    
    add(varilla1);
    add(varilla2);
    add(varilla3);
    add(varilla4);
    add(varilla5);
    add(varilla6);
    add(varilla7);
    add(varilla8);
    add(varilla9);
    add(varilla10);
    
    add(poste8);
    
    add(cabeza);
    add(cuerpo1);
    add(cuerpo2);
    add(brazoi);
    add(brazod);
    add(piernai);
    add(piernad);
    
    add(titulou);
    add(letrau);
    add(estadot);
    add(estado);
    add(enviar);
    
    setVisible(true);
    
    Seleccionarpalabra();
    pistas();
    }
    
    public void Seleccionarpalabra(){
    String[] palabras ={"cook","guerra negra","fiebre del oro","guerra del emu"};
    
    int seleccionarP = (int)(Math.random()*palabras.length);
    palabraSeleccionada = palabras[seleccionarP];
    System.out.println("La palabra seleccionada es: "+palabraSeleccionada);
    
    palabra= new String[palabraSeleccionada.length()];
        
        imprimirPalabra(palabra);
    }
    public void ahorcado(){ 
        boolean aux=true;
        while(aux){
            System.out.println("--------------------------------");
            System.out.println("Ingresa una letra:");
            String letrau=respuesta;
            String[] letras=palabraSeleccionada.split("");
            int cont=0;            
            if(letrau.equalsIgnoreCase("")){
                this.estado.setBackground(Color.white);
                break;
            }
            else{
            boolean letraC=false;
            for(String letraa:letras){
                if(letrau.equalsIgnoreCase(letraa)){
                    this.estado.setBackground(Color.green);
                    palabra[cont]=letrau;
                    letraC=true;
                }
                cont++;
            }
            if(letraC==true){
                System.out.println("La letra si esta en la palabra");
                
            }
            else{
                fallos--;
                this.estado.setBackground(Color.red);
                System.out.println("La letra no esta en la palabra");
                if(fallos==0){
                    piernad.setText("\\");
                    JOptionPane.showMessageDialog(null, "Has perdido te han ahorcado (x_x)\nLa palabra era: \n"+palabraSeleccionada, "Derrota", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/vista/calavera.png"));
                    this.dispose();
                    break;
                }
            }
            if(fallos==8){
            poste1.setText("|");
            poste2.setText("|");
            poste3.setText("|");
            poste4.setText("|");
            poste5.setText("|");
            poste6.setText("|");
            poste7.setText("|");
            }
            if(fallos==7){
            varilla1.setText("_");
            varilla2.setText("_");
            varilla3.setText("_");
            varilla4.setText("_");
            varilla5.setText("_");
            varilla6.setText("_");
            varilla7.setText("_");
            varilla8.setText("_");
            varilla9.setText("_");
            varilla10.setText("_");
            }
            if(fallos==6){
            poste8.setText("|");
            }
            if(fallos==5){
            cabeza.setText("O");
            }
            if(fallos==4){
            cuerpo1.setText("|");
            cuerpo2.setText("|");
            }
            if(fallos==3){
            brazoi.setText("/");
            }
            if(fallos==2){
            brazod.setText("\\");
            }
            if(fallos==1){
            piernai.setText("/");
            }
            
            imprimirPalabra(palabra);
            cont=0;
            letraC=false;
            if(gano(palabra)){
                JOptionPane.showMessageDialog(null, "Has completado la palabra");
                this.dispose();
                break;
            }
            aux=false;
        }
        }
        
    }
     
        public void imprimirPalabra(String[]palabra){
            String aux="";
            this.palabrasel.setText("");
        for(String letra : palabra){
            if(letra!=null){
                    System.out.print(letra);
                    this.palabrasel.setText(this.palabrasel.getText()+letra);
            }
            else{
                this.palabrasel.setText(this.palabrasel.getText()+"-");
            }
        }
    }
    
    public boolean gano(String[]palabra){
        boolean gano= true;
        for(String letra : palabra){
            if(letra==null){
                gano=false;
                break;
            }       
        }
        return gano;
    } 
    
    
    public void pistas(){
    String pista1="";
    String pista2="";
    if(palabraSeleccionada.equalsIgnoreCase("guerra negra")){
        pista1=("Conflicto generado entre paises y un color muy oscuro");
        pista2=("El color se ve normalmente en la noche");
    }
    if(palabraSeleccionada.equalsIgnoreCase("cook")){
        pista1=("Nombre de la persona que descubrio Australia");
        pista2=("Su nombre suena como cocinar en ingles");
    }
    if(palabraSeleccionada.equalsIgnoreCase("fiebre del oro")){
        pista1=("Metal de color dorado y un sintoma cuando alguien esta \nenfermo");
        pista2=("El sintoma es cuando una persona esta muy caliente de \ntemperatura");
    }
    if(palabraSeleccionada.equalsIgnoreCase("guerra del emu")){
        pista1=("Conflicto generado entre paises y el nombre de una ave");
        pista2=("El nombre de la ave suena muy parecido a emo");    
    }
    
    if(op==1){
    pistas.setText(pista1);
    }
    if(op==2){
    pistas.setText(pista2);
    }
    
    }
    
    @Override
       public void actionPerformed(ActionEvent e) {
       String texto;
       texto=e.getActionCommand();
       if(texto.equalsIgnoreCase("Enviar")){
           respuesta=letrau.getText();
           letrau.setText("");
           ahorcado();
       }
       
       if(texto.equalsIgnoreCase("Siguiente")){
           if(op<2){
           op++;
           pistas.setText("");
           pistas();
           }
       }
       
       if(texto.equalsIgnoreCase("Anterior")){
           if(op>1){
           op--;
           pistas.setText("");
           pistas();
           }
       }
       }
}
