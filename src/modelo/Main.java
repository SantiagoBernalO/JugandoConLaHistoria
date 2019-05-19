package modelo;

import modelo.List;
import modelo.Index;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Main {
    //controller
     static List l;
     static FileReader fw;
     static BufferedReader br;
    
    public static void main(String[] args) {
        
        Index i= new Index();        
        l = new List();
        l.setVisible(false);  
        
        
        try
        {
            
            fw = new FileReader("src/imagenes/file.txt");
            br = new BufferedReader(fw);
            String line;
            while((line=br.readLine())!=null)               
                List.dl.addElement(line);

        }
        catch(FileNotFoundException e)
        {
           JOptionPane.showMessageDialog(null,"No se pudo abrir el archivo");
        }
        catch(Exception ex)
        {
           JOptionPane.showMessageDialog(null,"Error");
        } 
    } 
}
