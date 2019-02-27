package mainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import testPackage.GameBoard.State;

	public class DrawStones {
		
		int boardSize;
		int gridSize;
		int borderSize;
		
		public DrawStones(int BoardSize, int GridSize, int BorderSize) {
			this.boardSize = BoardSize;
			this.gridSize = GridSize;
			this.borderSize = BorderSize;
		}
		
		public void paintComponent(Graphics g) {
		    //super.paintComponent(g);
			
		    Graphics2D g2 = (Graphics2D) g;
		    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		    
			// Iterate over intersections
		    for (int row = 0; row < boardSize; row++) {
		        for (int col = 0; col < boardSize; col++) {
		            State state = grid.getState(row, col);
		            if (state != null) {
		                if (state == State.BLACK) {
		                    g2.setColor(Color.BLACK);
		                } else {
		                    g2.setColor(Color.WHITE);
		                }
		                g2.fillOval(col * gridSize + borderSize - gridSize / 2,
		                        row * gridSize + borderSize - gridSize / 2,
		                        gridSize, gridSize);
		            }
		        }
		    }
	}
}
