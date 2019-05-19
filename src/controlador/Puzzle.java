
package controlador;
import vista.BoardP;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Puzzle extends JFrame{
	public static Container contenedor;
	public static BoardP board;
	private BufferedImage img;
	
	public Puzzle(){
		this.setTitle("Puzzle Alemania");
		this.setSize(604, 625);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contenedor = this.getContentPane();
		
		
		try {
                    //Nota la imagen debe ser de 400x400
			img = ImageIO.read(new File("src/imagenes/hittler.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		board = new BoardP(3, img);
		contenedor.add(board);
		this.setVisible(true);
	}
}
