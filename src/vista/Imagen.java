package vista;

import controlador.MuroBerlin;
import controlador.Puzzle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import modelo.Board2;
import modelo.Index;
import modelo.List;

public class Imagen extends JPanel implements ActionListener{
    
    protected JPanel hola;
    protected JButton img1, img2, img3, img4, img5, img6;
    private final Image background;
    private final int x, y;
    private final int bande = 30;
    private AudioClip song = java.applet.Applet.newAudioClip(getClass().getResource("/imagenes/sonido.wav"));
    
    public Imagen() {
        setLayout(null);
        background = new ImageIcon(this.getClass().getResource("/imagenes/fondomapa.jpg")).getImage();
        x = 70;
        y = 200;

        ImageIcon banderRoja = new ImageIcon(this.getClass().getResource("/imagenes/bEst.jpg")); 
        Image pr = banderRoja.getImage();

        ImageIcon banderRoja2 = new ImageIcon(this.getClass().getResource("/imagenes/bJap.jpg")); 
        Image pr2 = banderRoja2.getImage();

        ImageIcon banderRoja3 = new ImageIcon(this.getClass().getResource("/imagenes/bAle.jpg"));  
        Image pr3= banderRoja3.getImage();

        ImageIcon banderRoja4 = new ImageIcon(this.getClass().getResource("/imagenes/bAust.jpg")); 
        Image pr4 = banderRoja4.getImage();

        ImageIcon banderRoja5 = new ImageIcon(this.getClass().getResource("/imagenes/bPol.jpg")); 
        Image pr5 = banderRoja5.getImage();

        ImageIcon banderRoja6 = new ImageIcon(this.getClass().getResource("/imagenes/principal.jpg")); 
        Image pr6 = banderRoja6.getImage();

        //Botones
        img1 = new JButton();
        img1.setBounds(230,237, bande, bande);
        img1.setVisible(true);
        //img1.setContentAreaFilled(false); 
        img2 = new JButton();
        img2.setBounds(950, 250, bande, bande);
        img2.setVisible(true);
        //img2.setContentAreaFilled(false);
        img3 = new JButton();
        img3.setBounds(540,180, bande, bande);
        img3.setVisible(true);
        //img3.setContentAreaFilled(false);
        img4 = new JButton();
        img4.setBounds(980, 480, bande, bande);
        //img4.setContentAreaFilled(false);  
        img4.setVisible(true);
        img5 = new JButton();
        img5.setBounds(570, 180, bande, bande);
        //img5.setContentAreaFilled(false); 
        img5.setVisible(true);
        img6 = new JButton();
        img6.setBounds(510, 237, bande, bande);
        //img6.setContentAreaFilled(false); 
        img6.setVisible(true);

        pr = pr.getScaledInstance(bande, bande, 100);
        pr2 = pr2.getScaledInstance(bande, bande, 100);
        pr3 = pr3.getScaledInstance(bande, bande, 100);
        pr4 = pr4.getScaledInstance(bande, bande, 100);
        pr5 = pr5.getScaledInstance(bande, bande, 100);
        pr6 = pr6.getScaledInstance(bande, bande, 100);

        banderRoja = new ImageIcon(pr);
        banderRoja2 = new ImageIcon(pr2);
        banderRoja3 = new ImageIcon(pr3);
        banderRoja4 = new ImageIcon(pr4);
        banderRoja5 = new ImageIcon(pr5);
        banderRoja6 = new ImageIcon(pr6);

        img1.setIcon(banderRoja);
        img2.setIcon(banderRoja2);
        img3.setIcon(banderRoja3);
        img4.setIcon(banderRoja4);
        img5.setIcon(banderRoja5);
        img6.setIcon(banderRoja6);

     
        add(img1);
        add(img2);
        add(img3);
        add(img4);
      //  add(img5);
        add(img6);
        
        img1.addActionListener(this);
        img2.addActionListener(this);
        img3.addActionListener(this);
        img4.addActionListener(this);
   //     img5.addActionListener(this);
        img6.addActionListener(this);

        setVisible(true);
        song.play();
    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource().equals(img1)) {
            Interf jc = new Interf();
            jc.setVisible(true);     
        }
        if (e.getSource().equals(img2)) { 
            
            Board2 p= new Board2(); 
            p.setVisible(true); 
           
           
        }
        if (e.getSource().equals(img3)) {
           Puzzle p= new Puzzle(); 
           p.setVisible(true);
        }
        if (e.getSource().equals(img4)) {
           Interface i= new Interface(); 
           i.setVisible(true);
        }
        if (e.getSource().equals(img5)) { 
            MuroBerlin m= new MuroBerlin(); 
            m.setVisible(true);
          
        }
        if (e.getSource().equals(img6)) {
            Paises paises  = new Paises();
            paises.setVisible(true);
           
        }
    }

    

    @Override
    public void paint(Graphics g) {
        // super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(background, 0, 0, null);

    }
}
