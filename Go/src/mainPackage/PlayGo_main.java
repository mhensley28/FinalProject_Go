package mainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mainPackage.GoBoard.Player;

/*
 * Go_20190310-0312
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
		PlaceStoneCommand placeStoneCmd = GoBoard.getPlaceStoneCommand();
		GoBoard board = new GoBoard();
		
	    JFrame frame = new JFrame();
	    frame.setTitle("GO");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JPanel container = new JPanel();
	    
	    @SuppressWarnings("serial")
		JButton undoButton = new JButton(new AbstractAction("undo") {
	    	public void actionPerformed(ActionEvent e) {
	    		System.out.println("button pressed");
	    		placeStoneCmd.undo();
	    		board.undoCountInc();

	    	    container.setBackground(Color.GRAY);
	    	    container.setLayout(new BorderLayout());
	    	    frame.add(container);
	    	    container.setBorder(BorderFactory.createEmptyBorder(borderSizeTop, borderSizeLeft, borderSizeBottom, borderSizeRight));
	    	    container.add(board);
	    	    frame.pack();
	    	    frame.setResizable(false);
	    	    frame.setVisible(true);
	    	   	    	    
	    	}
	    	
	    });
	   
	    board.add(undoButton);
	    
	    container.setBackground(Color.GRAY);
	    container.setLayout(new BorderLayout());
	    frame.add(container);
	    container.setBorder(BorderFactory.createEmptyBorder(borderSizeTop, borderSizeLeft, borderSizeBottom, borderSizeRight));
	    container.add(board);

	    frame.pack();
	    frame.setResizable(false);
	    frame.setLocationByPlatform(true);
	    frame.setVisible(true);	    

	    
	}


}
















