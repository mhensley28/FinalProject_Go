package mainPackage;

public class StoneMatrix {

	int row;
	int col;
	int boardSize = GoBoard.getBoardSize();
	Stone[][] stones = new Stone[boardSize][boardSize];
	
	public StoneMatrix() {
		this.stones = stones;
	}
	
	public void addStone(Stone stone) {
		this.row = stone.getRow();
		this.col = stone.getCol();
		stones[row][col] = stone;
		//System.out.println("stoneMatrix.addStone()");
		//System.out.println(row + "\t" + col);
	}
	
	public Stone getCurrentStone(int row, int col) {
		return stones[row][col];
	}
	
	public Stone[][] getStones(){
		return stones;
	}
}