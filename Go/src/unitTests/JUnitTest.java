package unitTests;

import org.junit.jupiter.api.Test;
import mainPackage.PlaceStoneCommand;
import mainPackage.Stone;
import mainPackage.GoBoard.Player;
import org.junit.jupiter.api.Assertions;

class JUnitTest {

	@Test
	void testPlaceStoneCommand() {
		System.out.println("\nTesting PlaceStoneCommand...");
		
		int row = 3;
		int col = 7;
		Player player = Player.BLACK;
		Player currentPlayer = Player.NULL;
		
		PlaceStoneCommand placeStoneCommand = new PlaceStoneCommand(row, col, player);
		boolean isLegal = placeStoneCommand.isLegal();

		Assertions.assertEquals(true, placeStoneCommand);

	}
	
	@Test
	void testStone() {
		System.out.println("\nTesting Stone...");
		
		Player player = Player.BLACK;
		int row = 3;
		int col = 7;
		
		Stone stone = new Stone(row, col, player);
		Player getPlayer = stone.getPlayer();
		int getRow = stone.getRow();
		int getCol = stone.getCol();
		
		Assertions.assertEquals(Player.BLACK, getPlayer);
		Assertions.assertEquals(3, getRow);
		Assertions.assertEquals(7, getCol);
		
	}
}
