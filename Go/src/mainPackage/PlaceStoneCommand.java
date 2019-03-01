package mainPackage;

import mainPackage.GoBoard.State;

public class PlaceStoneCommand implements Command{

	public int row;
	public int col;
	State player;
	int boardSize = GoBoard.getBoardSize();
	int boardMatrixSize = boardSize*boardSize;

	public PlaceStoneCommand(int row, int col, State state) {
		this.row = row;
		this.col = col;
		this.player = state;
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
