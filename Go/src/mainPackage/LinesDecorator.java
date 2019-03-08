package mainPackage;

import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class LinesDecorator extends JPanel{
	
	public LinesDecorator() {
		
	}
	
	public abstract void drawLines(Graphics g);

}
