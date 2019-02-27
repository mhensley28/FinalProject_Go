package testPackage2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class GoBoard extends JPanel {
	
	int boardSize = 9;
	int tiles = boardSize-1;
	int gridSize = 40;
	int borderSize = (125/100)*gridSize;
	
	public GoBoard() {
	    this.setBackground(Color.ORANGE);	
	}
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
	    g2.setColor(Color.BLACK);
	    // Draw rows.
	    for (int i = 0; i < boardSize; i++) {
	        g2.drawLine(borderSize, i * gridSize + borderSize, gridSize * tiles + borderSize, i * gridSize + borderSize);
	    }
	    // Draw columns.
	    for (int i = 0; i < boardSize; i++) {
	        g2.drawLine(i * gridSize + borderSize, borderSize, i * gridSize
	                + borderSize, gridSize * tiles + borderSize);
	    }
	}
	
	@Override
	public Dimension getPreferredSize() {
	    return new Dimension(tiles * gridSize + borderSize * 2,
	    		tiles * gridSize + borderSize * 2);
	}
	
}



