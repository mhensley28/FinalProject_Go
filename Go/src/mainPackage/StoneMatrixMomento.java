package mainPackage;

public class StoneMatrixMomento implements Momento{
	
	int boardSize = GoBoard.getBoardSize();
	int matrixElements = boardSize*boardSize;
	Stone[][] stones = new Stone[boardSize][boardSize];
	StoneMatrix stoneMatrix;
	StoneMatrix[] stoneMatrixArr = new StoneMatrix[matrixElements];
	int moves = GoBoard.getMoves();
	
	public StoneMatrixMomento(StoneMatrix stoneMatrix) {
		this.stoneMatrix = stoneMatrix;
		
	}
	
	public void push() {
		stoneMatrixArr[moves] = stoneMatrix;
		GoBoard.addMove();
		System.out.println("moves: " + moves);
	}
	
	public void pull() {
		stoneMatrixArr[moves] = null;
		GoBoard.subMove();

	}
	
	public Stone getCurrentStone(int row, int col) {
		return stones[row][col];
	}

}
