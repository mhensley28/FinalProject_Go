package mainPackage;

import mainPackage.GoBoard.Player;

public class PlaceStoneCommand implements Command{

	public int row;
	public int col;
	Player player;
	int boardSize = GoBoard.getBoardSize();
	int boardMatrixSize = boardSize*boardSize;

	public PlaceStoneCommand(int row, int col, Player player) {
		this.row = row;
		this.col = col;
		this.player = player;
	}
	
	public void execute() {
		// Insert stone into board array (Iterator Pattern)
		for(int i=0; i<boardMatrixSize; i++) {
			if(player != null) {
				
			}else {
				
			}
		}
	}
	
	public void undo() {
		// Remove stone from board array (Iterator Pattern)
		
	}
	
	public boolean isLegal() {
		//if legal
		return true;
		//else
		//return false;
	}
}
