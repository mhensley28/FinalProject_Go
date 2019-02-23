package mainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GoBoard {
	
	private int boardSize;
	private int  gridSize;
	private Image image;
	private ImageIcon imageIcon;
	private JLabel jLabel;
	private JFrame jFrame;
	
	public void goBoard() {
        boardSize  = getInt( "n X n checker board for what value of n? [2 - 10]?" );
        gridSize = getInt( "How many pixels per square? [1 - 100]?" );
        int imageSize = boardSize * gridSize;       
        image = new BufferedImage( imageSize, imageSize, BufferedImage.TYPE_INT_ARGB );
        imageIcon = new ImageIcon( image );
        jLabel = new JLabel( imageIcon );
        jFrame = new JFrame( "Go Board" );
        jFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Container container = jFrame.getContentPane();
        container.setLayout( new BorderLayout() );
        container.add( jLabel, BorderLayout.CENTER );
        jFrame.pack();
	}
	
	private int getInt( String question )
    {
        String intString = JOptionPane.showInputDialog( question );
        return Integer.parseInt( intString );
    }
        
    /**
     * Paint the checker board onto the Image.
     */
    public void paint() {
        Graphics graphics = image.getGraphics();
        
        // paint a red  board
        graphics.setColor( Color.red );
        graphics.fillRect( 0, 0, boardSize * gridSize, boardSize * gridSize);
        
        // paint the black squares
        graphics.setColor( Color.black );
        for ( int row = 0; row < boardSize; row++ )
        {
            for ( int col = row % 2; col < boardSize; col += 2 )
            {
                graphics.fillRect( row * gridSize, col * gridSize, gridSize, gridSize );
            }
        }
    }
    
    public void view() { jFrame.setVisible( true ); }
}
