package mainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

@SuppressWarnings("serial")
public class VerticalLines extends LinesDecorator{

	int boardSize = 9;
	int tiles = boardSize-1;
	int gridSize = 40;
	int borderSize = (125/100)*gridSize;
	
	public void drawLines(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
	    g2.setColor(Color.BLACK);
	    for (int i = 0; i < boardSize; i++) {
	        g2.drawLine(i * gridSize + borderSize, borderSize, i * gridSize + borderSize, gridSize * tiles + borderSize);
	    }
	}

}