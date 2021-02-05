import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Lesson 6: Random and Math
 *
 * Animates a unit circle using Math class.
 *
 * Math methods used: 
 *   min(), sin(), cos(), toRadians(), abs()
 * Math constants used: 
 *   PI
 */
@SuppressWarnings("serial")
public class UnitCircle extends JPanel
{
	/** 1000ms is one second. This frequency and the clock
	 * technique used in this program will NOT result in an
	 * accurate clock but the point is only to demonstrate 
	 * the Math class methods in action.
	 */
	private final int DELAY = 1000; //milliseconds

	/** The current degree in seconds */
	private int degrees = 0;
	
	/** Seconds per minute or revolution of the clock face */
	private int DEGREES_PER_REVOLUTION = 360;

	/** Degrees per second */
	private final int DEGREES_PER_SECOND = 360/60; //6 degrees per second

//	/** Radians per second
//	 * Uses the Math.PI constant that is pi to maximum
//	 * double precision.
//	 */
//	private final double RADIANS_PER_SECOND = Math.PI*2/60;

	/* Info text labels */
	private final String LABEL_X = "X: ";
	private final String LABEL_Y = "Y: ";
	private final String LABEL_RADIANS = "Radians: ";
	private final String LABEL_DEGREES = "Degrees: ";
	
	/* This method draws on the panel's Graphics canvas.
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		//Get the current width and height of the window.
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height
		//Get window's center point coordinates.
		int centerX = width/2;
		int centerY = height/2;

		//Radius of the unit circle will be a third of the
		//minimum of the current width and height to allow
		//room for informational text above and below.
		//This will also be the length of the "clock hand."
		//Uses Math.min() to return the smaller of two values.
		int radius = Math.min(width, height)/3;
		
		//Convert the current angle in degrees to a radian
		//angle that can be used by the Math trig methods.
		//Uses the Math.toRadians() method to convert from
		//degrees to radians.
		double radians = Math.toRadians(degrees);
		
		//Calculate the end point coordinates for the "clock hand"
		//using Math.cos() and Math.sin() trig methods.
		//Note that the Math trig methods expect angles in radians.
		double unitX = Math.cos(radians);
		double unitY = Math.sin(radians);
		int handX = centerX + (int)(unitX * radius);
		int handY = centerY - (int)(unitY * radius);
		
		//Fill the Graphics canvas with the background color.
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);

		//For fun, let's draw the x and y offsets from center.
		g.setColor(Color.GRAY);
		g.drawLine(centerX, centerY, handX, centerY);
		g.drawLine(handX, centerY, handX, handY);

		//Draw the unit circle with "clock hand."
		g.setColor(Color.WHITE);
		g.drawOval(centerX-radius, centerY-radius, radius*2, radius*2);
		g.drawLine(centerX, centerY, handX, handY);
		
		//Info text
		int fontSize = radius/6;
		g.setFont(new Font("Serif", Font.BOLD, fontSize));
		//Font's metrics allow us to figure out size of text
		FontMetrics metrics = g.getFontMetrics();
		//Math.PI is pi to full double precision
		String strAngle = String.format("%s %.2f (%.2f*\u03C0), %s %d", 
				LABEL_RADIANS, radians, radians/Math.PI, LABEL_DEGREES, degrees);
		String strXY = String.format("%s %.2f, %s %.2f", 
				LABEL_X, Math.abs(unitX), LABEL_Y, Math.abs(unitY));
		int angleTextX = (width - metrics.stringWidth(strAngle)) / 2;
		int angleTextY = metrics.getHeight();
		int xyTextX = (width - metrics.stringWidth(strXY)) / 2;
		int xyTextY = height - (metrics.getHeight() / 2);
		g.setColor(Color.WHITE);
		g.drawString(strAngle, angleTextX, angleTextY);
		g.drawString(strXY, xyTextX, xyTextY);
		
		//Increment elapsed seconds for next time.
		degrees = (degrees + DEGREES_PER_SECOND) % DEGREES_PER_REVOLUTION;		
		
		//This makes the drawing smoother.
		Toolkit.getDefaultToolkit().sync();
	}


	/** Start the program
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("Math Trig Functions Demo");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new UnitCircle());
		frame.pack();
		frame.setVisible(true);
	}

	/** Constructor for the display panel initializes necessary variables.
	 * This method also sets up a Timer that will call paint() with the 
	 * frequency specified by the DELAY constant.
	 */
	public UnitCircle()
	{
		setPreferredSize(new Dimension(800, 600));
		this.setDoubleBuffered(true);
		startAnimation();
	}

	/** Create an animation thread that runs periodically. */
	private void startAnimation()
	{
		ActionListener timerListener = new TimerListener();
		Timer timer = new Timer(DELAY, timerListener);
		timer.start();
	}

	/** Repaints the graphics panel every time the timer fires. */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}
