package mainPackage;

import java.util.Iterator;

import mainPackage.GoBoard.Player;


public class StoneArray implements IStoneArray{

	Stone[] stones;
	int numberOfItems = 0;
	static int boardSize = GoBoard.getBoardSize();
	static int stoneMatrixSize = boardSize*boardSize;
	static final int MAX_ITEMS = stoneMatrixSize;
	
	public StoneArray() {
		stones = new Stone[stoneMatrixSize];
	}
	
	public void addItem(int row, int col, Player player) {
		Stone stone = new Stone(row, col, player);
		int matrixElement = (col+1)*boardSize + row;
		if (numberOfItems >= MAX_ITEMS || stones[matrixElement] != null) {
			System.err.println("Game over");
		} else {
			stones[numberOfItems] = stone;
			numberOfItems = numberOfItems + 1;
		}
	}
	
	public Iterator<Stone> createIterator() {
		return new StoneArrayIterator(stones);
		//return new AlternatingDinerMenuIterator(menuItems);
	}
	
}
