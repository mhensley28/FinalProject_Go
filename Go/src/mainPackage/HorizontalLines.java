package mainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

@SuppressWarnings("serial")
public class HorizontalLines extends LinesDecorator{

	int boardSize = 9;
	int tiles = boardSize-1;
	int gridSize = 40;
	int borderSize = (125/100)*gridSize;
	int leftBorderSize = 4*borderSize;
	int rightBorderSize = 4*borderSize;
		
	public void drawLines(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
	    g2.setColor(Color.BLACK);
	    for (int i = 0; i < boardSize; i++) {
	        g2.drawLine(leftBorderSize, (i+1)*gridSize + borderSize, gridSize*tiles + rightBorderSize, (i+1)*gridSize + borderSize);
	    }
	}

}
