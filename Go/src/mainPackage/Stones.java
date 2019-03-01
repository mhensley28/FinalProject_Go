package mainPackage;

import mainPackage.GoBoard.State;

public class Stones {

	State player;
	int row;
	int col;
	
	public Stones(int row, int col, State player) {
		this.player = player;
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public State getState() {
		return player;
	}
}
