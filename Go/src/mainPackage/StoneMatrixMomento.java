package mainPackage;

import mainPackage.GoBoard.Player;

public class StoneMatrixMomento implements Momento{
	
	int boardSize = GoBoard.getBoardSize();
	int matrixElements = boardSize*boardSize;
	//Stone newStone = 
	Stone[][] stones = new Stone[boardSize][boardSize];
	StoneMatrix currStoneMatrix = new StoneMatrix();
	StoneMatrix[] stoneMatrixArr = new StoneMatrix[matrixElements];
	PlaceStoneCommand placeStoneCmd = GoBoard.getPlaceStoneCommand();
	int moves = GoBoard.getMoves();
	int testRow;
	
	public StoneMatrixMomento() {
	    //Initialize stoneMatrixArr
	    for(int moves=0; moves<81; moves++) {
	    	for (int row = 0; row < boardSize; row++) {
		        for (int col = 0; col < boardSize; col++) {
		    	    Stone nullStone = new Stone(row, col, Player.NULL);
		    	    stoneMatrixArr[moves] = currStoneMatrix;
		    	    stoneMatrixArr[moves].addStone(nullStone);
		    	    //System.out.println(stoneMatrixArr[moves].getCurrentStone(row, col).getPlayer());
		    	    
		    	    //currStoneMatrix.addStone(nullStone);
		    	    //stoneMatrixArr[moves].addStone(nullStone);
	
		        }
	    	}
	    }
	}
	
	public void push(Stone newStone) {
		GoBoard.addMove();
		moves = GoBoard.getMoves();
		stoneMatrixArr[moves-1] = stoneMatrixArr[moves];
		stoneMatrixArr[moves].addStone(newStone);
		System.out.println("moves: " + moves);
	}
	
	public void pull() {
		//stoneMatrixArr[moves] = null;
		GoBoard.subMove();
		moves = GoBoard.getMoves();
		System.out.println("moves: " + moves);
		//stoneMatrixArr[moves] = stoneMatrixArr[moves-1];

		System.out.println("Pull");

	}
	
	public StoneMatrix getCurrStoneMatrix() {
		return stoneMatrixArr[moves];
	}
	
	public Stone getCurrentStone(int row, int col) {
		//System.out.println("getCurrentStone-Moves: " + moves);
		return stoneMatrixArr[moves].getCurrentStone(row, col);
		//return stones[row][col];
	}


}
