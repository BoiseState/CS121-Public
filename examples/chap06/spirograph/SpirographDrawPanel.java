package spirograph;

import java.awt.*;
import javax.swing.*;

/**
 * JPanel that paints a Spirograph with given circle radii.
 * 
 * @author mvail
 */
@SuppressWarnings("serial")
public class SpirographDrawPanel extends JPanel
{
	private Circle[] circles = new Circle[0];
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g)
	{
		setBackground(Color.black);
		
		super.paint(g);
	
		for (Circle c : circles) {
			c.draw(g);
		}
	}

	/**
	 * @param circles an array of Circles to draw
	 */
	public void drawCircles(Circle[] circles)
	{
		this.circles = circles;
		repaint();
	}
	
	/**
	 * @return mid Point of this panel
	 */
	public Point getMidPoint() {
		return new Point(this.getWidth()/2, this.getHeight()/2);
	}
}
