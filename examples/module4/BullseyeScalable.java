import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * Demonstrates the use of conditionals and loops to draw a bullseye that is scalable and centered.
 *
 * @author amit
 * @author marissa (commentary, drawing circle relative to midX and midY)
 *
 */
@SuppressWarnings("serial")
public class BullseyeScalable extends JPanel
{
	private final int RING_WIDTH = 20;

	/**
	 * Sets up the Bullseye panel.
	 */
	public BullseyeScalable()
	{
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(600, 600));
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		//This makes the circles smoother
		Graphics2D page = (Graphics2D) g;
		page.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		int width = getWidth();
		int height = getHeight();

		// make sure the entire circle fits when scaled
		int radius = Math.min(width, height) / 2;

		// center the bullseye horizontally and vertically
		int midX = width / 2;
		int midY = height / 2;

		// determine the number of rings that will fit
		int numRings = (int) Math.ceil((double) radius / RING_WIDTH);

		page.setColor(Color.lightGray);

		// draw every ring (starting with the largest, outer ring)
		for (int count = 0; count < numRings - 1; count++)
		{
			if (page.getColor() == Color.black) {
				page.setColor(Color.lightGray);
			} else {
				page.setColor(Color.black);
			}

			page.fillOval(midX - radius, midY - radius, 2 * radius, 2 * radius);
			radius -= RING_WIDTH;
		}

		// Draw the red bullseye in the center
		page.setColor(Color.red);
		page.fillOval(midX - radius, midY - radius, 2 * radius, 2 * radius);
	}

	/**
	 * Creates the main frame of the program.
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("BullseyeScalable");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BullseyeScalable panel = new BullseyeScalable();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
