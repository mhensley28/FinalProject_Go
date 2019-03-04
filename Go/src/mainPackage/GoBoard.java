package mainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class GoBoard extends JPanel {
	
	static int boardSize = 9;
	int tiles = boardSize-1;
	int gridSize = 40;
	int borderSize = (125/100)*gridSize;
	
	public enum Player {BLACK, WHITE}
	
	public static int getBoardSize() {
		return boardSize;
	}
	
	public Player player;
	
	StoneArray blackStones = new StoneArray();
	StoneArray whiteStones = new StoneArray();
	ArrayList<IStoneArray> stoneMatrix = new ArrayList<IStoneArray>();
	
	Stones x;
	
	public GoBoard() {
	    this.setBackground(Color.ORANGE);	
	
	    player = Player.BLACK;
	
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
	 
	            PlaceStoneCommand placeStone = new PlaceStoneCommand(row, col, player);
	            
	            if(placeStone.isLegal()) {
	            	//add stone (Command Pattern)
	            	placeStone.execute();
	            	stoneMatrix.add(blackStones);
	            	stoneMatrix.add(whiteStones);
	            }else {
	            	//display 'Illegal Move!' on screen
	            	return;
	            }
	            /*
	             * Next, display stones. 
	             */
	        }	
		});
	}
        
	@Override
	protected void paintComponent(Graphics g) {
	    VerticalLines verticalLines = new VerticalLines();
	    HorizontalLines horizontalLines = new HorizontalLines();
	    
	    super.paintComponent(g);
	
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
	    g2.setColor(Color.BLACK);	   
	    
	    //draw vertical lines
	    verticalLines.drawLines(g2);
	    //draw horizontal lines
	    horizontalLines.drawLines(g2);
	    
	    /*
	     * Moves.IsLegal(row, col)
	     */

	    
	    /*
	     * Moves.AddStone //command
	     */
	}
	
	@Override
	public Dimension getPreferredSize() {
	    return new Dimension(tiles * gridSize + borderSize * 2,
	    		tiles * gridSize + borderSize * 2);
	}
	
}



