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

import testPackage.GameBoard.State;


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
	
	Stone[][] stones;
	
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
        PlaceStoneCommand placeStone = new PlaceStoneCommand(row, col, player);
	    stones = placeStone.getStones();
	    for (int row = 0; row < boardSize; row++) {
	        for (int col = 0; col < boardSize; col++) {
	        	
	            Player player = Stone.getPlayer();
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
	
	@Override
	public Dimension getPreferredSize() {
	    return new Dimension(tiles * gridSize + borderSize * 2,
	    		tiles * gridSize + borderSize * 2);
	}
	
}



