package mainPackage;

import mainPackage.GoBoard.Player;

public class Stones {

	Player player;
	int row;
	int col;
	
	public Stones(int row, int col, Player player) {
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
	
	public Player getPlayer() {
		return player;
	}
}
