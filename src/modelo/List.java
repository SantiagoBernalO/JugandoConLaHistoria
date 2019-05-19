package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class List extends JFrame{
    //score of the playersscore of the players
    JList list;
    JScrollPane scrool;
    JLabel tit;
    static DefaultListModel dl;
    FileReader fw;
    BufferedReader br;
    
    public List()
    {
        this.setLayout(null);
        this.setBounds(50, 100, 185, 190);
        this.setLocationRelativeTo(null);
        dl = new DefaultListModel();
        tit = new JLabel("Puntaje / Nombre");
        tit.setLocation(30, 0);
        tit.setSize(250, 20);
        list = new JList(dl);
        scrool = new JScrollPane(list);       
        scrool.setBounds(20, 20, 125, 85);
        this.add(tit);
        this.add(scrool);
        this.setVisible(true);
    }
    
}

