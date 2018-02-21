package misc;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

/**
 * A mouse odometer.
 * @author amit
 *
 */
@SuppressWarnings("serial")
public class MouseOdometerPanel extends JPanel implements MouseMotionListener
{
	private int sum = 0;
	private int mouseX, mouseY;

	/**
	 * Constructor
	 */
	public MouseOdometerPanel()
	{
		addMouseMotionListener(this);
	}

	public void paintComponent(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		int fontSize = getHeight()/4;
		Font myFont = new Font("Monospaced", Font.BOLD, fontSize);
		setFont(myFont);
		String temp = sum + " ";

		FontMetrics metrics = g.getFontMetrics();
		int x = (getWidth() - metrics.stringWidth(temp))/2 + metrics.getMaxAdvance()/2;
		int y = (getHeight() - metrics.getHeight())/2 + metrics.getHeight() - metrics.getDescent() - metrics.getLeading();

		g.setColor(Color.black);
		g.drawString(temp, x, y);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	public void mouseDragged(MouseEvent event) { }

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	public void mouseMoved(MouseEvent event)
	{
		int newX = event.getX();
		int newY = event.getY();

		int deltaX = newX - mouseX;
		int deltaY = newY - mouseY;
		double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
		sum = (int) distance + sum;

		mouseX = newX;
		mouseY = newY;

		repaint();
	}
	
}
