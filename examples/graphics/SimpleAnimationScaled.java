import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Animates a green square moving across the screen.
 * @author amit, mvail, marissa
 */
@SuppressWarnings("serial")
public class SimpleAnimationScaled extends JPanel
{
	//Note: This area is where you declare constants and variables that
	//	need to keep their values between calls	to paintComponent().
	//	Any other variables should be declared locally, in the
	//	method where they are used.

	//constant to regulate the frequency of Timer events
	// Note: 100ms is 10 frames per second - you should not need
	// a faster refresh rate than this
	private final int DELAY = 100; //milliseconds
	//anchor coordinate for drawing / animating
	private int xOffset = -50;
	//pixels added to x each time paintComponent() is called
	private int stepSize = 10;

	/* This method draws on the panel's Graphics context.
	 * This is where the majority of your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics page)
	{
		//account for changes to window size
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height

		//Fill the canvas with the background color
		page.setColor(getBackground());
		page.fillRect(0, 0, width, height);

		//Calculate the new position
		xOffset = (xOffset + stepSize) % width;

		//Draw scaled square
		page.setColor(Color.DARK_GRAY);
		int squareWidth = Math.min(width, height)/5; // square is 1/5th of the screen width or height.
		int squareX = xOffset; // square edge is always following x offset
		int squareY = height/2 - squareWidth/2; // square is in the middle of the y axis
		page.fillRect(squareX, squareY, squareWidth, squareWidth);

		//Draw scaled circle on top of square
		page.setColor(Color.RED);
		int circleDiameter = squareWidth/2; // circle is half as wide as square
		int circleX = squareX + circleDiameter/2; // to center it, we need to offset square's x by the radius of the circle
		int circleY = squareY - circleDiameter; // we need to move it above the square.
		page.fillOval(circleX, circleY, circleDiameter, circleDiameter);
		
		Toolkit.getDefaultToolkit().sync();
	}

	/**
	 * Constructor for the display panel initializes
	 * necessary variables. Only called once, when the
	 * program first begins.
	 * This method also sets up a Timer that will call
	 * paint() with frequency specified by the DELAY
	 * constant.
	 */
	public SimpleAnimationScaled()
	{
		setBackground(Color.white);
		//Do not initialize larger than 800x600
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/////////////////////////////////////////////
	// DO NOT MODIFY main() or startAnimation()
	/////////////////////////////////////////////

	/**
	 * Starting point for the TrafficAnimation program
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("Simple Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new SimpleAnimationScaled());
		frame.pack();
		frame.setVisible(true);
	}

   /**
    * Create an animation thread that runs periodically
	* DO NOT MODIFY this method!
	*/
    private void startAnimation()
    {
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                repaint();
            }
        };
        new Timer(DELAY, taskPerformer).start();
    }
}
