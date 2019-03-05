package mainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class PlayGo_main {

	public static void main(String[] args) {
		/*
		 * Initialize board graphics
		 */
		int gridSize = 40;
		int borderSize = (125/100)*gridSize;
	    JFrame f = new JFrame();
	    f.setTitle("GO");
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JPanel container = new JPanel();
	   
	    container.setBackground(Color.GRAY);
	    container.setLayout(new BorderLayout());
	    f.add(container);
	    container.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize*6));
	
	    GoBoard board = new GoBoard();
	    container.add(board);

	    f.pack();
	    f.setResizable(false);
	    f.setLocationByPlatform(true);
	    f.setVisible(true);	    
	    
	}
}














