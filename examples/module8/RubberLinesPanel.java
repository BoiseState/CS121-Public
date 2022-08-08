import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

/**
 * Represents the primary drawing panel for the RubberLines program
 * 
 * @author Java Foundations
 *
 */
@SuppressWarnings("serial")
public class RubberLinesPanel extends JPanel 
{
	private Point point1 = null, point2 = null;

	/**
	 * Constructor: Sets up this panel to listen for mouse events.
	 */
	public RubberLinesPanel()
	{
		LineListener listener = new LineListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);

		setBackground(Color.black);
		setPreferredSize(new Dimension(400, 200));
	}

	// -----------------------------------------------------------------
	// Draws the current line from the initial mouse-pressed point to
	// the current position of the mouse.
	// -----------------------------------------------------------------
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);

		page.setColor(Color.yellow);
		if (point1 != null && point2 != null) {
			page.drawLine(point1.x, point1.y, point2.x, point2.y);
		}
	}

	
	/**
	 * Represents the listener for all mouse events.
	 *
	 */
	private class LineListener implements MouseListener, MouseMotionListener {
		/**
		 * Captures the initial position at which the mouse button is
		 * pressed.
		 */
		public void mousePressed(MouseEvent event)
		{
			point1 = event.getPoint();
		}

		/**
		 *   Gets the current position of the mouse as it is dragged and
		 *   redraws the line to create the rubberband effect.
		 */
		public void mouseDragged(MouseEvent event)
		{
			point2 = event.getPoint();
			repaint();
		}

		// --------------------------------------------------------------
		// Provide empty definitions for unused event methods.
		// --------------------------------------------------------------
		public void mouseClicked(MouseEvent event)
		{
		}

		public void mouseReleased(MouseEvent event)
		{
		}

		public void mouseEntered(MouseEvent event)
		{
		}

		public void mouseExited(MouseEvent event)
		{
		}

		public void mouseMoved(MouseEvent event)
		{
		}
	}
}
