package vista;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener{
    private  Image background;
    protected JButton juego;
    public Menu() {
        this.background = new ImageIcon(this.getClass().getResource("/imagenes/fondoStart.jpg")).getImage();
        setLayout(null);
        //setBounds(70, 20, 1200, 700);  
        juego = new JButton();
       // ImageIcon iniciar = new ImageIcon("/vista/botonIniciar.jpg"); 
        
        juego.setBounds(520, 500, 150,80); 
        ImageIcon iniciar = new ImageIcon(this.getClass().getResource("/imagenes/botonIniciar.jpg"));
        Image pr = iniciar.getImage(); 
        //pr = pr.getScaledInstance(100, 100, 100);
        iniciar = new ImageIcon(pr); 
        juego.setIcon(iniciar);
        add(juego);
        juego.addActionListener(this);
        setVisible(true);
        setFocusable(false);
    }
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.drawImage(background,  0, 0, getWidth(), getHeight(), this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(juego)){
            JFrame ventana = (JFrame) (getParent().getParent().getParent().getParent());
            ventana.remove(this);
            ventana.add(new Imagen());
            
            ventana.validate();
            ventana.repaint();
        }
    }
   
}
