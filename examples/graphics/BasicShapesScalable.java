import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Demonstrates basic drawing methods from Graphics class
 * 
 * @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class BasicShapesScalable extends JPanel
{
	public void paintComponent(Graphics page)
	{
		// Get the dimensions of the page.
		int pageWidth = getWidth();
		int pageHeight = getHeight();

		// Calculate square offset and size
		int squareXOffset = pageWidth / 10;
		int squareYOffset = pageHeight / 4;
		int squareSide = pageWidth / 10;

		// Calculate rectangle offset and size
		int rectXOffset = squareXOffset + squareSide / 4;
		int rectYOffset = squareYOffset + (3 * squareSide / 4);
		int rectWidth = squareSide * 5;
		int rectHeight = 2 * squareSide / 3;

		// Calculate circle offset and size
		int ovalXOffset = squareXOffset + (2 * squareSide / 3);
		int ovalYOffset = squareYOffset + (squareSide / 3);
		int ovalWidth = squareSide / 2;

		// Calculate line x and y coordinates
		int lineX1 = squareXOffset - squareSide / 4;
		int lineX2 = squareXOffset + squareSide + squareSide / 4;
		int lineY1 = squareYOffset + squareSide / 4;
		int lineY2 = squareYOffset + squareSide + (2 * squareSide / 3);

		// Calculate phrase offsets
		int phraseX = squareXOffset + squareSide + squareSide / 2;
		int phraseY = squareYOffset + squareSide / 2;

		// Calculate author offsets
		int authorX = phraseX + squareSide / 2;
		int authorY = phraseY + squareSide / 2 + rectHeight / 3;

		// Draw everything using calculated values
		page.drawRect(squareXOffset, squareYOffset, squareSide, squareSide); // square
		page.drawRect(rectXOffset, rectYOffset, rectWidth, rectHeight); // rectangle
		page.drawOval(ovalXOffset, ovalYOffset, ovalWidth, ovalWidth); // circle
		page.drawLine(lineX1, lineY1, lineX2, lineY2); // line

		page.drawString("I read poetry to save time.", phraseX, phraseY);
		page.drawString("--Marilyn Monroe", authorX, authorY);
	}

	/**
	 * Constructor (panel initialization)
	 */
	public BasicShapesScalable()
	{
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(450, 175));
	}

	/**
	 * sets up a JFrame and the BasicShapes panel
	 * 
	 * @param args
	 *            unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("BasicShapesScalable");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new BasicShapesScalable());
		frame.pack();
		frame.setVisible(true);
	}
}
