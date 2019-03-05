package mainPackage;

import java.awt.Graphics;

import mainPackage.GoBoard.Player;

public class PlaceStoneCommand implements Command{
	
	Graphics g;
	public int row;
	public int col;
	Player player;
	int boardSize = GoBoard.getBoardSize();
	int boardMatrixSize = boardSize*boardSize;
	Stone[][] stones = new Stone[boardSize][boardSize];
	//StoneMatrix stoneMatrix = new StoneMatrix();
	StoneMatrix stoneMatrix = GoBoard.getStoneMatrix();

	public PlaceStoneCommand(int row, int col, Player player) {
		this.row = row;
		this.col = col;
		this.player = player;
	}
	
	public void execute() {
		Stone newStone = new Stone(row, col, player);
			//place stone in array
			stoneMatrix.addStone(newStone);
			//System.out.println("Placing stone - execute");
			//System.out.println(row + "\t" + col + "\t" + player);
	}
	
	public void undo() {
		// Remove stone from board array (Iterator Pattern)
		
	}
	
	public boolean isLegal() {
		Stone currentStone = stoneMatrix.getCurrentStone(row, col);
		if(currentStone.getPlayer() == Player.NULL)
			return true;
		else
			return false;
		
	}
	
	public Stone[][] getStones() {
		return stones;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}