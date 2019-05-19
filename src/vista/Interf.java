package vista;

import modelo.Juegocompletar;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Interf extends JFrame implements ActionListener {

    String respuesta;

    private JButton b1;
    protected JTextArea txpregunta;
    protected JTextField txrespuesta, txcompletar;
    private JLabel imagen;
    private ImageIcon imagen2, iconojop;

    public Interf() {

        setBounds(330, 65, 700, 500);
        imagen2 = new ImageIcon(this.getClass().getResource("/imagenes/EU.jpg"));
        iconojop = new ImageIcon(this.getClass().getResource("/imagenes/world.png"));
        imagen = new JLabel(imagen2);
        b1 = new JButton("ENVIAR");
        txpregunta = new JTextArea();
        txcompletar = new JTextField();//preg.pregunta
        txrespuesta = new JTextField("Ingrese aqui.");

        imagen.setBounds(-500, -500, 1500, 1200);
        b1.setBounds(300, 350, 90, 50);
        txcompletar.setBounds(195, 240, 300, 30);
        txpregunta.setBounds(20, 40, 645, 160);
        txrespuesta.setBounds(195, 290, 300, 30);

        txpregunta.setBackground(Color.lightGray);
        txpregunta.setEditable(false);
        txpregunta.setWrapStyleWord(true);
        txpregunta.setLineWrap(true);
        txpregunta.setFont(new Font(null, Font.BOLD, 20));

        txcompletar.setBackground(Color.LIGHT_GRAY);
        txcompletar.setHorizontalAlignment(JTextField.CENTER);
        txcompletar.setEditable(false);

        txrespuesta.setBackground(Color.LIGHT_GRAY);
        txrespuesta.setHorizontalAlignment(JTextField.CENTER);

        add(b1);
        add(txrespuesta);
        add(txcompletar);
        add(txpregunta);
        add(imagen);

        b1.addActionListener(this);

        setLayout(null);
        setVisible(true); 
        setResizable(false);

        Juegocompletar buscar = new Juegocompletar();

        java.util.Timer timer = new java.util.Timer();

        TimerTask tarea = new TimerTask() {

            @Override
            public void run() {

                txpregunta.setText(buscar.Recorrer(null));
                txcompletar.setText(buscar.Recorrerr(null));
                respuesta = buscar.Recorerrr(null);
                txrespuesta.setText("");
                txrespuesta.setBackground(Color.LIGHT_GRAY);

            }
        };
        timer.schedule(tarea, 0, 60000);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Juegocompletar j = new Juegocompletar();
        String a, b;
        a = "";
        b = "Ingrese aqui.";

        if (e.getSource().equals(b1)) {
            if (txrespuesta.getText().equalsIgnoreCase(respuesta)) {
                txrespuesta.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(null, j.Textoinfo(), "INFORMACION", JOptionPane.INFORMATION_MESSAGE, iconojop);
            } else {
                if ((txrespuesta.getText().equals("")) || (txrespuesta.getText().equals(b))) {
                    txrespuesta.setText(b);
                    txrespuesta.setBackground(Color.LIGHT_GRAY);
                } else {
                    txrespuesta.setBackground(Color.red);
                    System.out.println("no");
                }
            }
        }
    }
}
