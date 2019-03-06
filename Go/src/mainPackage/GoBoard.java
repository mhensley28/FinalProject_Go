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
	int leftBorderSize = 4*(125/100)*gridSize;
	int rightBorderSize = 4*(125/100)*gridSize;
	
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
    
    static StoneArray blackStoneArray = new StoneArray();
    static StoneArray whiteStoneArray = new StoneArray();
    
    public static StoneMatrix getStoneMatrix() {
    	return stoneMatrix;
    }
    
    public static StoneArray getBlackStoneArray() {
    	return blackStoneArray;
    }
    
    public static StoneArray getWhiteStoneArray() {
    	return whiteStoneArray;
    }
	
	public GoBoard() {
	    //this.setBackground(Color.ORANGE);
	    this.setBackground(Color.WHITE);
	    
	    //Initialize stoneMatrix
	    for (int row = 0; row < boardSize; row++) {
	        for (int col = 0; col < boardSize; col++) {
	    	    Stone nullStone = new Stone(row, col, Player.NULL);
	    	    stoneMatrix.addStone(nullStone);

	        }
	    }
	    
	    player = Player.BLACK;
	    
		this.addMouseListener(new MouseAdapter() {
	    	
	        @Override
	        public void mouseReleased(MouseEvent e) {
	            // Converts to float for float division and then rounds to
	            // provide nearest intersection.
	        	int x = Math.round((float) (e.getX()));
	        	int y = Math.round((float) (e.getY()));
	            int row = Math.round((float) (e.getY() - 2*borderSize) / gridSize);
	            int col = Math.round((float) (e.getX() - leftBorderSize) / gridSize);
	            System.out.println("(x,y) : (" + x + "," + y + ")"); 
	            System.out.println("(c,r) : (" + col + "," + row + ")");
	
	            // Check wherever it's valid
	            if (row >= boardSize || col >= boardSize || row < 0 || col < 0) {
	                return; 
	            }

	            PlaceStoneCommand placeStone = new PlaceStoneCommand(row, col, player);
	            if(placeStone.isLegal()) {
	            	placeStone.execute();
	            	//System.out.println("Black stones off board: " + blackStoneArray.getNumberOfStones());
	            	//System.out.println("White stones off board: " + whiteStoneArray.getNumberOfStones());
	            	
		            if(player == Player.BLACK)
		            	player = Player.WHITE;
		            else
		            	player = Player.BLACK;
	            }
	            repaint();
	        }	
		});
	}
        
	@Override
	protected void paintComponent(Graphics g) {
	    VerticalLines verticalLines = new VerticalLines();
	    HorizontalLines horizontalLines = new HorizontalLines();
	    
	    super.paintComponent(g);
	    
	    Graphics2D g1 = (Graphics2D) g;
	    g1.setColor(Color.ORANGE);
	    g1.fillRect(leftBorderSize - gridSize, borderSize, (boardSize+1)*gridSize, (boardSize+1)*gridSize);
	
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    
	    g2.setColor(Color.BLACK);	   
	    
	    //draw vertical lines
	    verticalLines.drawLines(g2);
	    //draw horizontal lines
	    horizontalLines.drawLines(g2);

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
	                g2.fillOval(col * gridSize + leftBorderSize - gridSize / 2, row * gridSize + 2*borderSize - gridSize / 2, gridSize, gridSize);
	            }
	        }
	    }
	    
	    Graphics2D g3 = (Graphics2D) g;
	    g3.setColor(Color.BLACK);
	    g3.drawString("Hello", 375, 300);
	    
	}
	
	//Set size of graphics space
	@Override
	public Dimension getPreferredSize() {
	    //return new Dimension(tiles*gridSize*2 + borderSize/2, tiles*gridSize + borderSize*4);
	    return new Dimension(leftBorderSize + tiles*gridSize + rightBorderSize, tiles*gridSize + borderSize*4);
	}
	
}


