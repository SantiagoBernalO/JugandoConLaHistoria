package vista;

import javax.swing.JFrame;

public class Ventana extends JFrame{

    public Ventana() {
       setTitle("Jugando con la historia");
       setBounds(70, 20, 1200, 700);
       setLocationRelativeTo(null);
      
       add(new Menu());
       setFocusable(false);
        setResizable(false);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
