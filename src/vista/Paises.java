package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javafx.scene.media.AudioClip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Paises extends JFrame implements ActionListener {
    
    private AudioClip sound; 
    private JPanel color;
    private JLabel princi,fondo,im1,cata,im2,anda,im3,mad,im4,vas,im5,gali,im6,estre;
    private JButton entrar;
    private ImageIcon imf,impr,imbpr,im01,im02,im03,im04,im05,im06,homer,iconojop;

    public Paises() {
        setBounds(0, 0, 1100, 710);

        
        iconojop = new ImageIcon(this.getClass().getResource("/imagenes/world.png"));
        imf = new ImageIcon(this.getClass().getResource("/imagenes/espana.gif"));
        impr = new ImageIcon(this.getClass().getResource("/imagenes/principal.jpg"));
        imbpr = new ImageIcon(this.getClass().getResource("/imagenes/botonp.jpg"));
        im01 = new ImageIcon(this.getClass().getResource("/imagenes/catalua.gif"));
        im02 = new ImageIcon(this.getClass().getResource("/imagenes/Andalousie.gif"));
        im03 = new ImageIcon(this.getClass().getResource("/imagenes/Madrid.gif"));
        im04 = new ImageIcon(this.getClass().getResource("/imagenes/Vasco.gif"));
        im05 = new ImageIcon(this.getClass().getResource("/imagenes/Galicia.gif"));
        im06 = new ImageIcon(this.getClass().getResource("/imagenes/Estremadura.gif"));
        
        im1 = new JLabel(im01);im2 = new JLabel(im02);im3 = new JLabel(im03);im4 = new JLabel(im04);im5 = new JLabel(im05);im6 = new JLabel(im06);
        cata = new JLabel("Cataluña");anda = new JLabel("Andalusia");mad = new JLabel("Madrid");vas = new JLabel("Pais\nVasco");gali = new JLabel("Galicia");estre = new JLabel("Estremadura");
        fondo = new JLabel(imf);princi = new JLabel(impr);
        entrar = new JButton(imbpr);
        color = new JPanel();

        color.setBackground(Color.red);
        color.setBounds(0, 0, 1100, 710);
        im1.setBounds(960, 10, 110, 100);im2.setBounds(960, 120, 110, 100);im3.setBounds(960, 230, 110, 100);
        im4.setBounds(960, 340, 110, 100);im5.setBounds(960, 450, 110, 100);im6.setBounds(960, 560, 110, 100);
        fondo.setBounds(-100, -220, 1040, 1250);
        princi.setBounds(0, 0, 1100, 710);
        entrar.setBounds(169, 169, 359, 371);

        
        im1.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(((im1.getX() + e.getX() + im1.getWidth())>0)&&((im1.getY() + e.getY() + im1.getHeight())>0)&&((im1.getX() + e.getX() - im1.getWidth())<975)&&((im1.getY() + e.getY() - im1.getHeight())<570)){
                    im1.setLocation((im1.getX() + e.getX() - im1.getWidth() / 2), im1.getY() + e.getY() - im1.getHeight() / 2);
                    System.out.println(("en x: "+(im1.getX() + e.getX() - im1.getWidth() / 2))+"en y: "+ (im1.getY() + e.getY() - im1.getHeight() / 2));
                    if (((im1.getX() > 770) && (im1.getX() < 830)) && ((im1.getY() > 100) && (im1.getY() < 150))) {
                        JOptionPane.showMessageDialog(null, "Buen trabajo con Cataluña!\ncontinua así...");
                    }   
                }
            }
        });
        im2.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(((im2.getX() + e.getX() + im2.getWidth())>0)&&((im2.getY() + e.getY() + im2.getHeight())>0)&&((im2.getX() + e.getX() - im2.getWidth())<975)&&((im2.getY() + e.getY() - im2.getHeight())<570)){
                  im2.setLocation(im2.getX() + e.getX() - im2.getWidth() / 2, im2.getY() + e.getY() - im2.getHeight() / 2);
                if (((im2.getX() > 310) && (im2.getX() < 390)) && ((im2.getY() > 555) && (im2.getY() < 570))) {
                    JOptionPane.showMessageDialog(null, "Buen trabajo con Andalícia!\ncontinua así...");
                }  
                }
            }
        });
        im3.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(((im3.getX() + e.getX() + im3.getWidth())>0)&&((im3.getY() + e.getY() + im3.getHeight())>0)&&((im3.getX() + e.getX() - im3.getWidth())<975)&&((im3.getY() + e.getY() - im3.getHeight())<570)){
                    im3.setLocation(im3.getX() + e.getX() - im3.getWidth() / 2, im3.getY() + e.getY() - im3.getHeight() / 2);
                System.out.println(im3.getX()+"   "+im3.getY());
                if (((im3.getX() > 340) && (im3.getX() < 375)) && ((im3.getY() > 270) && (im3.getY() < 280))) {
                    JOptionPane.showMessageDialog(null, "Buen trabajo con Madrid!\ncontinua así...");
                }
                }
            }

        });
        im4.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(((im4.getX() + e.getX() + im4.getWidth())>0)&&((im4.getY() + e.getY() + im4.getHeight())>0)&&((im4.getX() + e.getX() - im4.getWidth())<975)&&((im4.getY() + e.getY() - im4.getHeight())<570)){
                    im4.setLocation(im4.getX() + e.getX() - im4.getWidth() / 2, im4.getY() + e.getY() - im4.getHeight() / 2);
                if (((im4.getX() > 455) && (im4.getX() < 555)) && ((im4.getY() > 1) && (im4.getY() < 70))) {
                    JOptionPane.showMessageDialog(null, "Buen trabajo con Pais Vasco!\ncontinua así...");
                }
                }
            }
        });
        im5.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(((im5.getX() + e.getX() + im5.getWidth())>0)&&((im5.getY() + e.getY() + im5.getHeight())>0)&&((im5.getX() + e.getX() - im5.getWidth())<975)&&((im5.getY() + e.getY() - im5.getHeight())<570)){
                    im5.setLocation(im5.getX() + e.getX() - im5.getWidth() / 2, im5.getY() + e.getY() - im5.getHeight() / 2);
                if (((im5.getX() > 1) && (im5.getX() < 75)) && ((im5.getY() > 1) && (im5.getY() < 70))) {
                    JOptionPane.showMessageDialog(null, "Buen trabajo con Galicia!\ncontinua así...");
                }
                }
            }
        });
        im6.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(((im6.getX() + e.getX() + im6.getWidth())>0)&&((im6.getY() + e.getY() + im6.getHeight())>0)&&((im6.getX() + e.getX() - im6.getWidth())<975)&&((im6.getY() + e.getY() - im6.getHeight())<570)){
                    im6.setLocation(im6.getX() + e.getX() - im6.getWidth() / 2, im6.getY() + e.getY() - im6.getHeight() / 2);
                if (((im6.getX() > 120) && (im6.getX() < 250)) && ((im6.getY() > 350) && (im6.getY() < 444))) {
                    JOptionPane.showMessageDialog(null, "Buen trabajo con Estremadura!\ncontinua así...");
                }
                }
            }
        });entrar.addActionListener(this);
        
        add(princi);add(im1);add(im2);add(im3);add(im4);add(im5);add(im6);
        add(fondo);add(entrar);add(color);
        
        setLayout(null);
        setVisible(true); 
        setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {if(e.getSource().equals(entrar)){princi.setVisible(false);entrar.setVisible(false);}}
}
