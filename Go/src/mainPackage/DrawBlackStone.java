package mainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class DrawBlackStone extends JPanel{
	/*	
	public DrawBlackStone(Graphics g, int x, int y) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
	    //g2.setColor(Color.BLACK);
	}*/
	
	public void draw(Graphics g, int x, int y) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
	    g2.setColor(Color.BLACK);
	    g2.fillOval(x, y, 50, 50);
	}
	
}
