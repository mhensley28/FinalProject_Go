package mainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PlayGo_main {

	public static void main(String[] args) {
		/*
		 * Initialize board graphics
		 */
		int gridSize = 40;
		int borderSizeTop = (125/100)*gridSize;
		int borderSizeBottom = (150/100)*gridSize;
		int borderSizeLeft = 4*gridSize;
		int borderSizeRight = 4*gridSize;
		
	    JFrame f = new JFrame();
	    f.setTitle("GO");
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JPanel container = new JPanel();
	    //JTextField blackBagNum = new JTextField();
	    
	    //blackBagNum.setPreferredSize(new Dimension(200, 200));
	    
	    //Container textField = f.getContentPane();
	   
	    container.setBackground(Color.GRAY);
	    container.setLayout(new BorderLayout());
	    f.add(container);
	    container.setBorder(BorderFactory.createEmptyBorder(borderSizeTop, borderSizeLeft, borderSizeBottom, borderSizeRight));
	    
	    //container.add(blackBagNum);
	    //textField.add(blackBagNum);;
	
	    GoBoard board = new GoBoard();
	    container.add(board);

	    f.pack();
	    f.setResizable(false);
	    f.setLocationByPlatform(true);
	    f.setVisible(true);	    
	    
	    
	}
	

}














