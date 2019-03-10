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
	static int gridSize = 40;
	static int borderSize = (125/100)*gridSize;
	static int leftBorderSize = 4*(125/100)*gridSize;
	static int rightBorderSize = 4*(125/100)*gridSize;
	
	static int moves = 0;
	
	int undoCount = 0;
	
	public enum Player {BLACK, WHITE, NULL}
	
	public static Player player;
	
	StoneArray blackStones = new StoneArray();
	StoneArray whiteStones = new StoneArray();

	ArrayList<IStoneArray> stoneArray = new ArrayList<IStoneArray>();
	
	Stone[][] stones = new Stone[boardSize][boardSize];
	
	static StoneMatrixMomento stoneMatrixMomento = new StoneMatrixMomento();
    static StoneMatrix stoneMatrix = new StoneMatrix();
    
    static StoneArray blackStoneArray = new StoneArray();
    static StoneArray whiteStoneArray = new StoneArray();
    static PlaceStoneCommand placeStoneCmd = new PlaceStoneCommand(-1, -1, Player.NULL);
	
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
	    
	    //Black moves first
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
	            
	            // Check if click is on board
	            if (row >= boardSize || col >= boardSize || row < 0 || col < 0) {
	                return; 
	            }

	            placeStoneCmd = new PlaceStoneCommand(row, col, player);
	            if(placeStoneCmd.isLegal()) {	            	
	            	System.out.println("undoCountMod: " + undoCount%2);
	            	if(undoCount % 2 == 1 && undoCount != 0) {
			            if(player == Player.BLACK)
			            	player = Player.WHITE;
			            else
			            	player = Player.BLACK;
			            placeStoneCmd = new PlaceStoneCommand(row, col, player);
	            	}
	            	
	            	if(player == Player.BLACK)
	            		System.out.println("player: BLACK");
	            	else
	            		System.out.println("player: WHITE");
	            	
	            	placeStoneCmd.execute();            


		            if(player == Player.BLACK)
		            	player = Player.WHITE;
		            else
		            	player = Player.BLACK;
	         	            	
	            	undoCount = 0;
	            }
	                  
	            repaint();
	        }	
		});

	}
	
        
	@Override
	protected void paintComponent(Graphics g) {
		//System.out.println("paintComp\n");
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
	    String player;
	    for (int row = 0; row < boardSize; row++) {
	        for (int col = 0; col < boardSize; col++) {
	        	currentStone = stoneMatrixMomento.getCurrentStone(row, col);
	    	    currentPlayer = currentStone.getPlayer();
	            player = "  +";
	            //System.out.println(player);
	            if (currentPlayer != Player.NULL) {
	                if (currentPlayer == Player.BLACK) {
	                	player = "BLACK";
	                    g2.setColor(Color.BLACK);
	                } else {
	                	player = "WHITE";
	                    g2.setColor(Color.WHITE);
	                }
	                g2.fillOval(col * gridSize + leftBorderSize - gridSize / 2, row * gridSize + 2*borderSize - gridSize / 2, gridSize, gridSize);
	            }
	        }
	    }
	       
	    int blackStonesUnplayed = blackStoneArray.getNumberOfStones();
	    int whiteStonesUnplayed = whiteStoneArray.getNumberOfStones();
	    Graphics2D g3 = (Graphics2D) g;
	    g3.setColor(Color.BLACK);
	    String StrBlackStonesUnplayed = Integer.toString(blackStonesUnplayed);
	    String StrWhiteStonesUnplayed = Integer.toString(whiteStonesUnplayed);
	    
	    int blackStrX = 540;
	    int blackStrY = 350;
	    g3.drawString("Black Stones", blackStrX, blackStrY);
	    g3.drawString("Unused", blackStrX+15, blackStrY+12);
	    g3.drawString(StrBlackStonesUnplayed, blackStrX+32, blackStrY+30);
	    
	    int whiteStrX = 15;
	    int whiteStrY = blackStrY;
	    g3.drawString("White Stones", whiteStrX, whiteStrY);
	    g3.drawString("Unused", whiteStrX+15, whiteStrY+12);
	    g3.drawString(StrWhiteStonesUnplayed, whiteStrX+32, whiteStrY+30);
        	    
	}
	
	//Set size of graphics space
	@Override
	public Dimension getPreferredSize() {
	    //return new Dimension(tiles*gridSize*2 + borderSize/2, tiles*gridSize + borderSize*4);
	    return new Dimension(leftBorderSize + tiles*gridSize + rightBorderSize, tiles*gridSize + borderSize*4);
	}
	
	public static int getborderSize() {
		return borderSize;
	}
	
	public static int getGridSize() {
		return gridSize;
	}
	
	public static int getBoardSize() {
		return boardSize;
	}
	
	public static int getLeftBoardSize() {
		return leftBorderSize;
	}
	
	public static int getRightBoardSize() {
		return rightBorderSize;
	}
	
    public static PlaceStoneCommand getPlaceStoneCommand() {
    	return placeStoneCmd;
    }
    
    public static StoneMatrixMomento getStoneMatrixMomento() {
    	return stoneMatrixMomento;
    }
    
    public static StoneMatrix getStoneMatrix() {
    	return stoneMatrix;
    }
    
    public static StoneArray getBlackStoneArray() {
    	return blackStoneArray;
    }
    
    public static StoneArray getWhiteStoneArray() {
    	return whiteStoneArray;
    }
    
    public static int getMoves() {
    	return moves;
    }
    
    public static void addMove() {
    	moves += 1;
    }
    
    public static void subMove() {
    	moves -= 1;
    }
    
    public static Player getPlayer() {
    	return player;
    }
    
    public void undoCountInc() {
    	undoCount++;
    }
}


