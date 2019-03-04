package mainPackage;

import java.util.Iterator;

import mainPackage.GoBoard.Player;


public class StoneArray implements IStoneArray{

	Stones[] stones;
	int numberOfItems = 0;
	static int boardSize = GoBoard.getBoardSize();
	static int stoneMatrixSize = boardSize*boardSize;
	static final int MAX_ITEMS = stoneMatrixSize;
	
	public StoneArray() {
		stones = new Stones[stoneMatrixSize];
	}
	
	public void addItem(int row, int col, Player player) {
		Stones stone = new Stones(row, col, player);
		int matrixElement = (col+1)*boardSize + row;
		if (numberOfItems >= MAX_ITEMS || stones[matrixElement] != null) {
			System.err.println("Game over");
		} else {
			stones[numberOfItems] = stone;
			numberOfItems = numberOfItems + 1;
		}
	}
	
	public Iterator<Stones> createIterator() {
		return new StoneArrayIterator(stones);
		//return new AlternatingDinerMenuIterator(menuItems);
	}
	
}
