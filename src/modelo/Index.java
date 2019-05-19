package modelo;

import modelo.Board2;
import javax.swing.JOptionPane;
public class Index {
    //Index for the name
    static String nom;
    public Index()
    {
        nom=JOptionPane.showInputDialog("Nombre");
        Board2 t = new Board2();        
        t.setVisible(true);
    }   
}
