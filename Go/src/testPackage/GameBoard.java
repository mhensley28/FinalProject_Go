package testPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameBoard extends JPanel {
	
	int boardSize = 9;
	int tiles = boardSize-1;
	int gridSize = 40;
	int borderSize = (125/100)*gridSize;

	public enum State {BLACK, WHITE}
	
	private State player;
	private Grid grid;
	private Point lastMove;
	
	public GameBoard() {
	    this.setBackground(Color.ORANGE);
	    grid = new Grid(boardSize);
	    // Black always starts
	    player = State.BLACK;
	
	    this.addMouseListener(new MouseAdapter() {
	
	        @Override
	        public void mouseReleased(MouseEvent e) {
	            // Converts to float for float division and then rounds to
	            // provide nearest intersection.
	            int row = Math.round((float) (e.getY() - borderSize) / gridSize);
	            int col = Math.round((float) (e.getX() - borderSize) / gridSize);

	            // Check wherever it's valid
	            if (row >= boardSize || col >= boardSize || row < 0 || col < 0) {
	                return;
	            }
	System.out.println("loop");
	            if (grid.isOccupied(row, col)) {
	                return;
	            }

	            grid.addStone(row, col, player);
	            lastMove = new Point(col, row);
	
	            // Switch current player
	            if (player == State.BLACK) {
	            	player = State.WHITE;
	            } else {
	            	player = State.BLACK;
	            }
	            repaint();
	        }
	    });
	}
	
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
	    g2.setColor(Color.BLACK);
	    // Draw rows.
	    for (int i = 0; i < boardSize; i++) {
	        g2.drawLine(borderSize, i * gridSize + borderSize, gridSize * tiles + borderSize, i * gridSize + borderSize);
	    }
	    // Draw columns.
	    for (int i = 0; i < boardSize; i++) {
	        g2.drawLine(i * gridSize + borderSize, borderSize, i * gridSize
	                + borderSize, gridSize * tiles + borderSize);
	    }
	   
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
	    // Highlight last move
	    if (lastMove != null) {
	        g2.setColor(Color.RED);
	        g2.drawOval(lastMove.x * gridSize + borderSize - gridSize / 2,
	                lastMove.y * gridSize + borderSize - gridSize / 2,
	                gridSize, gridSize);
	    }
	}
	
	@Override
	public Dimension getPreferredSize() {
	    return new Dimension(tiles * gridSize + borderSize * 2,
	    		tiles * gridSize + borderSize * 2);
	}

}