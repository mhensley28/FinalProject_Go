package mainPackage;

import mainPackage.GoBoard.Player;

public class Stone {

	Player player;
	int row;
	int col;
	
	public Stone(int row, int col, Player player) {
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
