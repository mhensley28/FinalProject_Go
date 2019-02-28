package testPackage2;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Draw extends JFrame{
	
    public static void main(String[] args){
    	new Draw();
    	
    }

	public Draw() {
		this.setSize(1200,900);
		this.setTitle("Go");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new DrawStuff(), BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	private class DrawStuff extends JComponent{
		
		int boardStart;
		int boardDim;
		int boardSize;
		int gridSize;
		int lineVertX1;
		int lineVertX2;
		int lineVertY1;
		int lineVertY2;
		int lineHorizX1;
		int lineHorizX2;
		int lineHorizY1;
		int lineHorizY2;
		int arrayIndex;
		
		public void paint(Graphics g) {
			boardStart = 50;
			boardDim = 741;
			boardSize = 9;
			gridSize = boardDim/boardSize;
			
			
			Graphics2D grid = (Graphics2D)g;
			grid.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			Shape rectangle = new Rectangle2D.Float(boardStart, boardStart, boardDim, boardDim);
			grid.draw(rectangle);
			ArrayList<Shape> lines = new ArrayList<>();
			arrayIndex = 0;
			for(int i=0; i<boardSize-1; i++) {
				lineVertX1 = boardStart + (i+1)*gridSize;
				lineVertY1 = boardStart;
				lineVertX2 = lineVertX1;
				lineVertY2 = boardStart + boardDim;
				lines.add(new Line2D.Float(lineVertX1, lineVertY1, lineVertX2, lineVertY2));
				grid.draw(lines.get(arrayIndex));
				arrayIndex += 1;
				
				lineHorizX1 = lineVertY1;
				lineHorizY1 = lineVertX1;
				lineHorizX2 = lineVertY2;
				lineHorizY2 = lineVertX2;
				lines.add(new Line2D.Float(lineHorizX1, lineHorizY1, lineHorizX2, lineHorizY2));
				grid.draw(lines.get(arrayIndex));
				arrayIndex += 1;
			}
			//Shape testLine = new Line2D.Float(100, 200, 400, 200);
			

			//grid.draw(lines.get(14));
			//grid.draw(lines.get(15));
		}
	}
	
}

