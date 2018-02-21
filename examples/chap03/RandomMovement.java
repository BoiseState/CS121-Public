import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * In-class activity to demo trig functions.
 *
 * @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class RandomMovement extends JPanel
{
	private final int delay = 1000; //milliseconds
	private Random rand = new Random();
	private ImageIcon icon = new ImageIcon ("unicorn-kitty.jpg");

	/**
	 * Display the square at a new location.
	 * @param g Graphics context
	 */
	public void paintComponent(Graphics g)
	{
		int width = getWidth();
		int height = getHeight();

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);

		// Calculate random x, y coordinates
		int kittyX = rand.nextInt(width - icon.getIconWidth());
		int kittyY = rand.nextInt(height - icon.getIconHeight());

		// Draw image
		g.drawImage(icon.getImage(), kittyX, kittyY, null);

		// Make the animation smoother
		Toolkit.getDefaultToolkit().sync();
	}

	/**
	 * sets up a JFrame and the RandomMovement panel
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Random Movement!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new RandomMovement());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Set initial location for square and start the animation
	 */
	public RandomMovement()
	{
		setBackground(Color.white);
		setPreferredSize(new Dimension(400,400));
		startAnimation();
	}


	/**
	 * Create an animation thread that runs periodically
	 */
	private void startAnimation()
	{
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				repaint();
			}
		};
		new Timer(delay, taskPerformer).start();
	}
}
