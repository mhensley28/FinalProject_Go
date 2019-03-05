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

import mainPackage.GoBoard.Player;


@SuppressWarnings("serial")
public class GoBoard extends JPanel {
	
	static int boardSize = 9;
	int tiles = boardSize-1;
	int gridSize = 40;
	int borderSize = (125/100)*gridSize;
	
	public enum Player {BLACK, WHITE, NULL}
	
	public static int getBoardSize() {
		return boardSize;
	}
	
	public Player player;
	
	StoneArray blackStones = new StoneArray();
	StoneArray whiteStones = new StoneArray();

	ArrayList<IStoneArray> stoneArray = new ArrayList<IStoneArray>();
	
	Stone[][] stones = new Stone[boardSize][boardSize];
	
    static StoneMatrix stoneMatrix = new StoneMatrix();
    
    public static StoneMatrix getStoneMatrix() {
    	return stoneMatrix;
    }
	
	public GoBoard() {
	    this.setBackground(Color.ORANGE);	
	    
	    //Initialize stoneMatrix
	    for (int row = 0; row < boardSize; row++) {
	        for (int col = 0; col < boardSize; col++) {
	    	    Stone nullStone = new Stone(row, col, Player.NULL);
	    	    stoneMatrix.addStone(nullStone);

	        }
	    }
	    System.out.println("Initializing stoneMatrix...");
	    
	    player = Player.BLACK;
	    
		this.addMouseListener(new MouseAdapter() {
	    	
	        @Override
	        public void mouseReleased(MouseEvent e) {
	            // Converts to float for float division and then rounds to
	            // provide nearest intersection.
	            int row = Math.round((float) (e.getY() - borderSize) / gridSize);
	            int col = Math.round((float) (e.getX() - borderSize) / gridSize);
	            //System.out.println(row + "\t" + col);
	
	            // Check wherever it's valid
	            if (row >= boardSize || col >= boardSize || row < 0 || col < 0) {
	                return; 
	            }
	 
	            //System.out.println("Line 76 Player - " + player);
	            PlaceStoneCommand placeStone = new PlaceStoneCommand(row, col, player);
	            if(placeStone.isLegal())
	            	placeStone.execute();
	            	
	            	
	            if(player == Player.BLACK)
	            	player = Player.WHITE;
	            else
	            	player = Player.BLACK;
	            
	            /*
	             * Next, display stones. 
	             */
	            repaint();
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

	    Player currentPlayer;
	    Stone currentStone;
	    for (int row = 0; row < boardSize; row++) {
	        for (int col = 0; col < boardSize; col++) {
	    	    currentStone = stoneMatrix.getCurrentStone(row, col);
	    	    currentPlayer = currentStone.getPlayer();
	            //System.out.println("In FOR loop");
	            if (currentPlayer != Player.NULL) {
	                if (currentPlayer == Player.BLACK) {
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


