package mainPackage;

import java.util.Iterator;

public class StoneArray implements IStoneArray{

	StoneUnplayed[] stonesUnplayed;
	int numberOfStones = 0;
	static int boardSize = GoBoard.getBoardSize();
	static int stoneMatrixSize = boardSize*boardSize;
	static final int MAX_ITEMS = stoneMatrixSize;
	
	public StoneArray() {
		stonesUnplayed = new StoneUnplayed[stoneMatrixSize];
		
		for(int i=0; i<stoneMatrixSize; i++) {
			addStone(i);
		}
	}
	
	public void addStone(int stoneNum) {
		StoneUnplayed stoneUnplayed = new StoneUnplayed(stoneNum);
		if(numberOfStones >= MAX_ITEMS) {
			System.err.println("Sorry, board is empty!  Can't take black stone off board.");
		} else {
			stonesUnplayed[numberOfStones] = stoneUnplayed;
			numberOfStones += 1;
		}
	}
	
	public void removeStone(int stoneNum) {
		if(numberOfStones > 0) {
			stonesUnplayed[numberOfStones-1] = null;
			numberOfStones -= 1;
		}else {
			System.err.print("Board is full! No more stones to play.");
		}
			
	}
	
	public int getNumberOfStones() {
		return numberOfStones;
	}
	
	public Iterator<StoneUnplayed> createIterator() {
		return new StoneArrayIterator(stonesUnplayed);
	}
	
}
