package testPackage;

import testPackage.GameBoard.State;


public class Stone_Test {

	public Chain chain;
	public State state;
	public int liberties;
	// Row and col are need to remove (set to null) this Stone from Grid
	public int row;
	public int col;
	
	public Stone_Test(int row, int col, State state) {
	    chain = null;
	    this.state = state;
	    liberties = 4;
	    this.row = row;
	    this.col = col;
	}
}
