package testPackage2;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class NextMoveClick extends JPanel {
	
	int boardSize;
	int borderSize;
	int gridSize;
	
	int x;

	public NextMoveClick(int BoardSize, int GridSize, int BorderSize) {
		
		this.boardSize = BoardSize;
		this.gridSize = GridSize;
		this.borderSize = BorderSize;
		this.addMouseListener(new MouseAdapter() {
			
	        @SuppressWarnings("null")
			public void mouseReleased(MouseEvent e) {
	            // Converts to float for float division and then rounds to
	            // provide nearest intersection.
	        	int[] move = null;
	            move[0] = Math.round((float) (e.getY() - borderSize) / gridSize);
	            move[1] = Math.round((float) (e.getX() - borderSize) / gridSize);
	            x = move[0];
	        }
		});
	}
	
	public static final void MOUSE_RELEASED() {
		
	}
	
	public int getX() {
		return x;
	}
}
