import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/**
 * 
 * Represents the primary panel for the Coordinates program.
 * 
 * @author Java Foundations
 */
@SuppressWarnings("serial")
public class CoordinatesPanel extends JPanel {
	private final int SIZE = 10; // diameter of dot

	private int x = 50, y = 50; // coordinates of mouse press
	private Color lightGreen = new Color(206, 255, 199);
	private Font myFont = new Font("Serif", Font.BOLD, 24);
	
	/**
	 * Constructor: Sets up this panel to listen for mouse events.
	 */
	public CoordinatesPanel()
	{
		addMouseListener(new CoordinatesListener());

		setBackground(Color.black);
		setPreferredSize(new Dimension(600, 400));
	}

	// -----------------------------------------------------------------
	// Draws all of the dots stored in the list.
	// -----------------------------------------------------------------
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);

		page.setColor(lightGreen);
		page.fillOval(x, y, SIZE, SIZE);
		page.setFont(myFont);
		page.drawString("Coordinates: (" + x + ", " + y + ")", 10, 30);
	}

	/**
	 * Represents the listener for mouse events.
	 */
	private class CoordinatesListener implements MouseListener {
		// --------------------------------------------------------------
		// Adds the current point to the list of points and redraws
		// the panel whenever the mouse button is pressed.
		// --------------------------------------------------------------
		public void mousePressed(MouseEvent event)
		{
			x = event.getX();
			y = event.getY();
			repaint();
		}

		// --------------------------------------------------------------
		// Provide empty definitions for unused event methods.
		// --------------------------------------------------------------
		public void mouseClicked(MouseEvent event) { }

		public void mouseReleased(MouseEvent event) { }

		public void mouseEntered(MouseEvent event) { }

		public void mouseExited(MouseEvent event) { }
	}
}
