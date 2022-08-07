import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * SimplePic.java demonstrates using an anchor point and ratios
 * to create a picture that can be resized without losing cohesion
 * 
 * @author BSU CS 121 Instructors
 */

@SuppressWarnings("serial")
public class SimplePic extends JPanel
{
	// This is where you declare constants and variables that need to keep their
	// values between calls	to paintComponent(). Any other variables should be
	// declared locally, in the method where they are used.

	/**
	 * The anchor coordinate for drawing. All of the drawing's 
	 * coordinates are based on this anchor point
	 */
	private int xAnchor = 0, yAnchor = 0;

	
	//This defines a new color using RGB values (red, green, blue)
	private final Color BACKGROUND_COLOR = new Color(100,200,100);

	// This method draws on the panel's Graphics context.
	public void paintComponent(Graphics g)
	{
		// Get the current width and height of the window.
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height

				
		// Fill the graphics page with the background color.
		// Notice that "g" is the name of the Graphics object given as a parameter to this method
		// setColor and fillRect are methods defined in the Graphics class that are called 
		// using the dot operator.
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, width, height);

		//The anchor point is about in the middle of the frame (I think it
		//  looks better if it's shifted over so the body of the dog is 
		//  is in centered in the frame)
		//Notice that all the dimensions of the picture components
		//  are based on the height and width of the frame.  This 
		//  allows the picture to scale with as the frame is resized
		//Basing the parts of the dog picture on the anchor points and
		//  ratios makes sure the pieces stay touching as it resizes.
		int bodyWidth = (int)(width*.25);
		int bodyHeight = (int)(height*.25);
		int tailWidth = (int)(width*.10);
		int tailHeight = (int)(height*.10);
		int headWidth = (int)(bodyWidth*.5);
		int headHeight = headWidth;
		int legWidth = (int)(tailWidth*.5);
		int legHeight = (int)(bodyHeight*.75);
		xAnchor = (width/2)-(int)((.5*bodyWidth));
		yAnchor = height/2;
		
		
		// This draws a (very) simple dog based on the anchor point.
		g.setColor(Color.orange);
		/*the parameters are: (x coord of the top left corner,
							y coord of the top left corner,
							width of the rectangle, 
		  					height of the rectangle)
		 To change the color of one of the body components, you would
		 	call g.setColor(Color.<the new color>) and then call g.fillRectangle()
		 */
		g.fillRect(xAnchor, yAnchor, bodyWidth, bodyHeight);
		g.fillRect(xAnchor-tailWidth, yAnchor, tailWidth, tailHeight);
		g.fillRect(xAnchor + (int)(.8*bodyWidth), yAnchor - (int)(.5 * headHeight), headWidth, headHeight);
		g.fillRect(xAnchor, yAnchor+bodyHeight, legWidth, legHeight); // back legs
		g.fillRect(xAnchor + (bodyWidth-legWidth), yAnchor + bodyHeight, legWidth, legHeight); // front legs
	}

	/**
	 * Starting point for this program. 
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("Very, Very Simple Dog");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new SimplePic());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Constructor for the display panel initializes necessary variables.
	 * Only called once, when the program first begins. 
	 */
	public SimplePic()
	{
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

	}

}
