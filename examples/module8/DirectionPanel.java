import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Represents the primary display panel for the Direction program.
 * 
 * @author Java Foundations
 */
@SuppressWarnings("serial")
public class DirectionPanel extends JPanel
{
	private final int WIDTH = 300, HEIGHT = 200;
	private final int JUMP = 10; // increment for image movement

	private ImageIcon up, down, right, left, currentImage;
	private int x, y;

	/**
	 * Sets up this panel and loads the images.
	 */
	public DirectionPanel()
	{
		addKeyListener(new DirectionListener());

		x = WIDTH / 2;
		y = HEIGHT / 2;

		up = new ImageIcon("arrowUp.gif");
		down = new ImageIcon("arrowDown.gif");
		left = new ImageIcon("arrowLeft.gif");
		right = new ImageIcon("arrowRight.gif");

		currentImage = right;

		setBackground(Color.black);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
	}

	/**
	 * Draws the image in the current location.
	 */
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		currentImage.paintIcon(this, page, x, y);
	}

	/**
	 * Represents the listener for keyboard activity.
	 */
	private class DirectionListener implements KeyListener
	{
		/**
		 *  Responds to the user pressing arrow keys by adjusting the
		 *  image and image location accordingly.
		 */
		public void keyPressed(KeyEvent event)
		{
			// All key codes are listed in KeyEvent class.
			switch (event.getKeyCode()) {
			case KeyEvent.VK_UP:
				currentImage = up;
				y -= JUMP;
				if (y < -currentImage.getIconHeight()) 
					y = HEIGHT;
				break;
			case KeyEvent.VK_DOWN:
				currentImage = down;
				y += JUMP;
				break;
			case KeyEvent.VK_LEFT:
				currentImage = left;
				x -= JUMP;
				break;
			case KeyEvent.VK_RIGHT:
				currentImage = right;
				x += JUMP;
				break;
			}

			repaint();
		}

		// --------------------------------------------------------------
		// Provide empty definitions for unused event methods.
		// --------------------------------------------------------------
		public void keyTyped(KeyEvent event) {  }

		public void keyReleased(KeyEvent event) {  }
	}
}
