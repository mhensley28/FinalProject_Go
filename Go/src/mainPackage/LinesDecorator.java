package mainPackage;

import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class LinesDecorator extends JPanel{
	
	public abstract void drawLines(Graphics g);

}
