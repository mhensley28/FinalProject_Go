package mainPackage;

import mainPackage.GoBoard.Player;

public class StoneMatrixMomento implements Momento{
	
	int boardSize = GoBoard.getBoardSize();
	int matrixElements = boardSize*boardSize;
	//Stone newStone = 
	Stone[][] stones = new Stone[boardSize][boardSize];
	//StoneMatrix currStoneMatrix = new StoneMatrix();
	//StoneMatrix tempStoneMatrix = new StoneMatrix();
	StoneMatrix[] stoneMatrixArr = new StoneMatrix[matrixElements];
	PlaceStoneCommand placeStoneCmd = GoBoard.getPlaceStoneCommand();
	Player player = GoBoard.getPlayer();
	int moves = GoBoard.getMoves();
	int testRow;
	
	public StoneMatrixMomento() {
	    //Initialize stoneMatrixArr
	    //System.out.println("Initializing stoneMatrixMomento");
		for(int moves=0; moves<stoneMatrixArr.length; moves++) {
	    	//stoneMatrixArr[moves] = currStoneMatrix;
			stoneMatrixArr[moves] = new StoneMatrix();
	    	for (int row = 0; row < boardSize; row++) {
		        for (int col = 0; col < boardSize; col++) {
		    	    Stone nullStone = new Stone(row, col, Player.NULL);
		    	    stoneMatrixArr[moves].addStone(nullStone);

		        }
	    	}
	    }
	}
	
	public void push(Stone newStone) {		
		GoBoard.addMove();
		moves = GoBoard.getMoves();
		
		for (int row = 0; row < boardSize; row++) {
			for (int col = 0; col < boardSize; col++) {
	        	stoneMatrixArr[moves].addStone(stoneMatrixArr[moves-1].getCurrentStone(row, col));
	        }
    	}
		stoneMatrixArr[moves].addStone(newStone);
		
		//System.out.println("moves: " + moves);

	}
	
	public void pull() {
		//stoneMatrixArr[moves] = null;
		GoBoard.subMove();
		moves = GoBoard.getMoves();

		//System.out.println("moves: " + moves);

		//System.out.println("Pull");

	}
	
	public StoneMatrix getCurrStoneMatrix() {
		return stoneMatrixArr[moves];
	}
	
	public Stone getCurrentStone(int row, int col) {
		//System.out.println("getCurrentStone-Moves: " + moves);
		return stoneMatrixArr[moves].getCurrentStone(row, col);
		//return stones[row][col];
	}
	
	public StoneMatrix getExactStnMat(int m) {
		return stoneMatrixArr[m];
	}


}
