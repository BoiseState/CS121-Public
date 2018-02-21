import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Represents the primary panel for the Dots program.
 * @author Lewis/Loftus/amit
 *
 */
@SuppressWarnings("serial")
public class DotsPanel extends JPanel
{
	private final Color LIGHT_GREEN = new Color(206, 255, 199);
	private final Font MY_FONT = new Font("Serif", Font.BOLD, 16);
	private final int DOT_RADIUS = 6;

	private ArrayList<Point> pointList;
	private Point lastPoint; // coordinates of mouse press

	/**
	 * Constructor: Sets up this panel to listen for mouse events.
	 */
	public DotsPanel()
	{
		pointList = new ArrayList<Point>();

		DotsListener listener = new DotsListener();
		addMouseListener(listener);

		setBackground(Color.black);
		setPreferredSize(new Dimension(600, 300));
	}

	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		
		page.setColor(LIGHT_GREEN);
		page.setFont(MY_FONT);
		
		// Draws all of the dots stored in the list.
		for (Point spot: pointList) {
			page.fillOval(spot.x - DOT_RADIUS, spot.y - DOT_RADIUS, DOT_RADIUS * 2, DOT_RADIUS * 2);
		}
		
		// Draw coordinate of last point.
		if(lastPoint != null) {
			page.drawString("Coordinates: (" + lastPoint.x + ", " + lastPoint.y + ")", 5, 30);
		}
		page.drawString("Count: " + pointList.size(), 5, 15);
	}
	
	


	/**
	 * Represents the listener for mouse events.
	 *
	 */
	private class DotsListener implements MouseListener
	{
		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
		 */
		public void mousePressed(MouseEvent event)
		{
			// Adds the current point to the list of points and redraws
			// the panel whenever the mouse button is pressed.
			lastPoint = event.getPoint();
			pointList.add(lastPoint);
			
			repaint();
		}

		// --------------------------------------------------------------
		// Provide empty definitions for unused event methods.
		// --------------------------------------------------------------
		public void mouseClicked(MouseEvent event)	{	}

		public void mouseReleased(MouseEvent event)	{	}

		public void mouseEntered(MouseEvent event)	{	}

		public void mouseExited(MouseEvent event)	{	}
	}
}
