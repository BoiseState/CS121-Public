import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Demonstrates the use of conditionals and loops to guide drawing.
 *
 * @author Lewis/Loftus/amit
 *
 */
public class Bullseye extends JPanel
{
	private final int NUM_RINGS = 12, RING_WIDTH = 25;
	private final int MAX_WIDTH = (NUM_RINGS + 1) * (RING_WIDTH  * 2);

	/**
	 * Sets up the bullseye panel.
	 */
	public Bullseye()
	{
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(MAX_WIDTH, MAX_WIDTH));
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		page.setColor(Color.lightGray);

		int x = 0, y = 0, diameter = MAX_WIDTH;

		for (int count = 0; count < NUM_RINGS; count++) {
			if (page.getColor() == Color.black) // alternate colors
				page.setColor(Color.lightGray);
			else
				page.setColor(Color.black);

			page.fillOval(x, y, diameter, diameter);

			diameter -= (2 * RING_WIDTH);
			x += RING_WIDTH;
			y += RING_WIDTH;
		}

		// Draw the red bullseye in the center
		page.setColor(Color.red);
		page.fillOval(x, y, diameter, diameter);
	}

	/**
	 * Creates the main frame of the program.
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Bullseye");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Bullseye panel = new Bullseye();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
