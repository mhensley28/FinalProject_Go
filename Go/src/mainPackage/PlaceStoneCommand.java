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
	Stone newStone;
	Stone[][] stones = new Stone[boardSize][boardSize];
	//StoneMatrix stoneMatrix = new StoneMatrix();
	//StoneMatrix stoneMatrix = GoBoard.getStoneMatrix();
    StoneMatrixMomento stoneMatrixMomento = GoBoard.getStoneMatrixMomento();
	StoneMatrix currStoneMatrix = stoneMatrixMomento.getCurrStoneMatrix();
	StoneArray blackStoneArray = GoBoard.getBlackStoneArray();
	StoneArray whiteStoneArray = GoBoard.getWhiteStoneArray();
	int testRow;

	public PlaceStoneCommand(int row, int col, Player player) {
		this.row = row;
		this.col = col;
		this.player = player;
		this.newStone = new Stone(row, col, player);
	}
	
	public void execute() {
		System.out.println("execute");
		int stoneNum;
		if(player == Player.BLACK) {
			stoneNum = blackStoneArray.getNumberOfStones();
			blackStoneArray.removeStone(stoneNum);
		}else {
			stoneNum = whiteStoneArray.getNumberOfStones();
			whiteStoneArray.removeStone(stoneNum);
		}
			//place stone in array
			//currStoneMatrix.addStone(newStone);
		
            stoneMatrixMomento.push(newStone);
            
	}
	
	public void undo() {
		// Remove stone from board array (Iterator Pattern)
		stoneMatrixMomento.pull();
	}
	
	public boolean isLegal() {
		//Stone currentStone = currStoneMatrix.getCurrentStone(row, col);
		Stone currentStone = stoneMatrixMomento.getCurrentStone(row, col);
		if(currentStone.getPlayer() == Player.NULL)
			return true;
		else
			return false;
		
	}
	
	public Stone getNewStone() {
		return newStone;
	}
	
	public Stone[][] getStones() {
		return stones;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}