package testPackage2;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlayGo {

	public static void main(String[] args) {
	    new PlayGo().init();
	}
	
	private void init() {
		int borderSize = 25;
	    JFrame f = new JFrame();
	    f.setTitle("GO");
	
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

