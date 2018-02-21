import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Represents the primary panel for the Rebound program.
 * 
 * @author Java Foundations
 */
@SuppressWarnings("serial")
public class ReboundPanel extends JPanel
{
	private final int WIDTH = 300, HEIGHT = 100;
	private final int DELAY = 20, IMAGE_SIZE = 35;

	private ImageIcon image;
	private Timer timer;
	private int x, y, moveX, moveY;

	/**
	 * Sets up the panel, including the timer for the animation.
	 */
	public ReboundPanel()
	{
		timer = new Timer(DELAY, new ReboundListener());
		image = new ImageIcon("happyFace.gif");

		x = 0;
		y = 40;
		moveX = moveY = 3;

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		timer.start();
	}

	/**
	 *  Draws the image in the current location.
	 */
	public void paintComponent(Graphics page)
	{
		//super.paintComponent(page);
		image.paintIcon(this, page, x, y);
		
		//Makes the animation smoother
		Toolkit.getDefaultToolkit().sync();
	}

	/**
	 * Represents the action listener for the timer.
	 *
	 */
	private class ReboundListener implements ActionListener
	{
		/**
		 * Updates the position of the image and possibly the direction
		 * of movement whenever the timer fires an action event.
		 */
		public void actionPerformed(ActionEvent event)
		{
			x += moveX;
			y += moveY;

			if (x <= 0 || x >= WIDTH - IMAGE_SIZE)
				moveX = moveX * -1;

			if (y <= 0 || y >= HEIGHT - IMAGE_SIZE)
				moveY = moveY * -1;

			repaint();
		}
	}
}
