import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *   A simple animation.
 *   @author amit, mvail
 */
@SuppressWarnings("serial")
public class SimpleAnimation extends JPanel
{
	private int x;
	private int stepSize = 10;
	private final int delay = 33; //milliseconds

	/**
	 * Display the square at a new location.
	 *
	 * @param g Graphics context
	 * @return none
	 */
	public void paintComponent(Graphics g)
	{
		int width = getWidth();
		int height = getHeight();

		// Erase the old square
		g.setColor(getBackground());
		g.fillRect(0, 0, width, height);

		// Move to new position
		x = (x + stepSize) % width;

		// Set square width and calculate y offset
		int squareSide = 50;
		int y = height / 2 - squareSide / 2;

		// Draw new square
		g.setColor(Color.green);
		g.fillRect(x, y, squareSide, squareSide);

		//Makes the animation smoother
		Toolkit.getDefaultToolkit().sync();
	}

	/**
	 * Set initial location for square and start the animation.
	 * This method is only called once when the app starts up.
	 *
	 * @param none
	 * @return void
	 */
	public SimpleAnimation()
	{
		x = 0;
		setBackground(Color.black);
		setPreferredSize(new Dimension(300, 200));
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically
	 */
	private void startAnimation()
	{
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				repaint();
			}
		};
		new Timer(delay, taskPerformer).start();
	}

    /**
     * sets up a JFrame and the SimpleAnimation panel
     * @param args unused
     */
    public static void main(String[] args) {
            JFrame frame = new JFrame("Simple Animation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new SimpleAnimation());
            frame.pack();
            frame.setVisible(true);
    }
}
