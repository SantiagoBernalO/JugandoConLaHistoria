package vista;

import vista.Cell;
import vista.BoardP;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import controlador.Puzzle;

public class Figure extends JButton implements ActionListener{
	
	private final int xSolPos, ySolPos;
	private int xPos, yPos;
	private int dimension;
	
	public Figure(int xSolPos, int ySolPos, ImageIcon subimage, int dimension){
		this.xSolPos = xSolPos;
		this.ySolPos = ySolPos;
		this.dimension = dimension;
		
		xPos = xSolPos;
		yPos = ySolPos;
		
		this.setIcon(subimage);
		this.setPreferredSize(new Dimension(subimage.getIconWidth(), subimage.getIconHeight()));
		this.addActionListener(this);
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getxSolPos() {
		return xSolPos;
	}

	public int getySolPos() {
		return ySolPos;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Move();
	}
	private void Move(){
		Cell[][] board = BoardP.board;
		try{
		if(board[xPos][yPos-1].getFigure() == null){ // arriba
			BoardP.board[xPos][yPos-1].setFigure(this);
			BoardP.board[xPos][yPos].setFigure(null);
			yPos --;
			Puzzle.board.Remover();
			ComprobarRespuesta();
			return;
			
		}
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
		try{
		if(board[xPos][yPos +1].getFigure() == null){ // abajo
			BoardP.board[xPos][yPos +1].setFigure(this);
			BoardP.board[xPos][yPos].setFigure(null);
			yPos ++;
			Puzzle.board.Remover();
			ComprobarRespuesta();
			return;
		}
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
		try{
		if(board[xPos + 1][yPos].getFigure() == null){ // derecha
			BoardP.board[xPos + 1][yPos].setFigure(this);
			BoardP.board[xPos][yPos].setFigure(null);
			xPos ++;
			Puzzle.board.Remover();
			ComprobarRespuesta();
			return;
		}
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
		try{
		if(board[xPos - 1][yPos].getFigure() == null){ // izquierda
			BoardP.board[xPos - 1][yPos].setFigure(this);
			BoardP.board[xPos][yPos].setFigure(null);
			xPos --;
			Puzzle.board.Remover();
			ComprobarRespuesta();
			return;
		}
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
		
		
	}
	private void ComprobarRespuesta(){
		Figure figura = null;
		
		for(int i = 0; i< dimension; i++){
			for(int j = 0; j< dimension; j++){
				
				figura = BoardP.board[i][j].getFigure();
				if(figura == null){
					continue;
				}
				if(figura.getxPos() != figura.getxSolPos() || 
				   figura.getyPos() != figura.getySolPos()){
					return;
				}	
			}
		}
		
		// completado
		JOptionPane.showMessageDialog(new JPanel(), "Felicitaciones acabas de completar la imagen de Adolf Hittler", "Rompecabezas Terminado", JOptionPane.INFORMATION_MESSAGE);
	        JOptionPane.showMessageDialog(null,"Adolf Hitler​ (Braunau am Inn, Austria-Hungría, 20 de abril de 1889-Berlín, Alemania,\n 30 de abril de 1945) fue un político, militar, pintor y escritor alemán, de origen austrohúngaro;\n canciller imperial desde 1933 y Führer —líder— de Alemania desde 1934 hasta su muerte.");
        }
}

