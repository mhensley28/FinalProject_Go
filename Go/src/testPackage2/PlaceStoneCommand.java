package testPackage2;

import java.awt.Color;
import java.awt.Graphics;

import testPackage.GameBoard.State;

public class PlaceStoneCommand implements Command {

	public PlaceStoneCommand(Stone stone) {
		
	}
	
	public void execute() {
		Graphics g;
		DrawStones.paintComponent(g);
	}
	
	public void undo() {
		
	}
}
