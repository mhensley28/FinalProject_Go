package mainPackage;

public class StoneMatrix {

	int row;
	int col;
	int boardSize = GoBoard.getBoardSize();
	int matrixElements;
	Stone[][] stones = new Stone[boardSize][boardSize];
	
	public StoneMatrix() {

	}
	
	public void addStone(Stone stone) {
		this.row = stone.getRow();
		this.col = stone.getCol();
		stones[row][col] = stone;
	}
	
	public Stone getCurrentStone(int row, int col) {
		return stones[row][col];
	}
	
	public Stone[][] getStones(){
		return stones;
	}
}