import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Lesson 11: Activity - for Loops
 * 
 * @author CS121 Instructors
 * @version [semester] 
 * @author [your name]  
 */
@SuppressWarnings("serial")
public class CheckerBoard extends JPanel
{
	private static final int NUM_ROWS = 8;
	private static final int NUM_COLS = 8;

	/**
	 * Sets the initial dimensions of the panel. 
	 */
	public CheckerBoard()
	{
		setPreferredSize(new Dimension(500, 500));
	}

	/**
	 *  Draws the checker board.
	 *  @param page Graphics context
	 */
	public void paintComponent(Graphics page)
	{
		int x = 0, y = 0;

		int width = getWidth();
		int height = getHeight();

		int boxWidth = width/NUM_ROWS;
		int boxHeight = height/NUM_COLS;

		// TODO: Your code here.	
	}

	/**
	 * Creates the main frame of the program.
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Checker Board");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CheckerBoard panel = new CheckerBoard();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
