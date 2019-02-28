package mainPackage;

import mainPackage.GoBoard.State;

public class MoveCommand implements Command{

	public int row;
	public int col;
	State player;

	public MoveCommand(int row, int col, State state) {
		this.row = row;
		this.col = col;
		this.player = state;
	}
	
	public void execute() {
		// Insert stone into board array (Iterator Pattern)
		
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
