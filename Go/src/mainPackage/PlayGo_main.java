package mainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Go_20190305-2107
 */

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
	    
	    @SuppressWarnings("serial")
		JButton undoButton = new JButton(new AbstractAction("undo") {
	    	public void actionPerformed(ActionEvent e) {
	    		System.out.println("button pressed");
	    	}
	    });
	    
	    undoButton.setBounds(173, 100, 95, 30);
	    //undoButton.setSize(95, 30);
	    f.add(undoButton);
	    undoButton.setVisible(true);
	   
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














