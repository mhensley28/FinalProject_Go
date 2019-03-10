package mainPackage;

import mainPackage.GoBoard.Player;

public class StoneMatrixMomento implements Momento{
	
	int boardSize = GoBoard.getBoardSize();
	int matrixElements = boardSize*boardSize;
	Stone[][] stones = new Stone[boardSize][boardSize];
	StoneMatrix[] stoneMatrixArr = new StoneMatrix[matrixElements];
	PlaceStoneCommand placeStoneCmd = GoBoard.getPlaceStoneCommand();
	Player player = GoBoard.getPlayer();
	int moves = GoBoard.getMoves();
	int testRow;
	
	public StoneMatrixMomento() {
	    //Initialize stoneMatrixArr
		for(int moves=0; moves<stoneMatrixArr.length; moves++) {
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

	}
	
	public void pull() {
		GoBoard.subMove();
		moves = GoBoard.getMoves();

	}
	
	public StoneMatrix getCurrStoneMatrix() {
		return stoneMatrixArr[moves];
	}
	
	public Stone getCurrentStone(int row, int col) {
		return stoneMatrixArr[moves].getCurrentStone(row, col);

	}
	
	public StoneMatrix getExactStnMat(int m) {
		return stoneMatrixArr[m];
	}


}
