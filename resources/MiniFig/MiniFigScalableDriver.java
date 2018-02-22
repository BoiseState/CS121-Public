import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

/**
 * A starting point for creating a new graphical program
 * @author CS121 instructors
 */
@SuppressWarnings("serial")
public class MiniFigScalableDriver extends JPanel
{
	public final int INITIAL_WIDTH = 800;
	public final int INITIAL_HEIGHT = 600;
	/**
	 * Draws the picture in the panel. This is where all of your
	 * code will go.
	 * @param page Our graphics canvas.
	 */
	public void paintComponent (Graphics page)
	{
		/* Store the height and width of the panel at the time
		 * the paintComponent() method is called.
		 */
		int currentHeight = getHeight();
		int currentWidth = getWidth();
		
		/* This is the anchor point for the MiniFig (x,y) -> (mid,top) */
		int mid = currentWidth / 2;
		int top = 50;
		
		/* This is the scaler that is used to calculate the dimensions (height / width) 
		 * of each of the MiniFig components. It uses the Math.min() function to select
		 * the smaller of currentWidth/INITIAL_WIDTH and currentHeight/INITIAL_HEIGHT.
		 * This way all the components are scaled to fit within the smaller of the two 
		 * panel dimensions.
		 */
		double scaleFactor = Math.min(currentWidth/(double)INITIAL_WIDTH,currentHeight/(double)INITIAL_HEIGHT );

		/* Create a new MiniFig object */
		MiniFig bob = new MiniFig(page,scaleFactor,mid,top);
		
		/* Create a new Color object and update the MiniFig's color */
		Color turtleGreen = new Color (63, 163, 44);
		bob.setTorsoColor(turtleGreen);
		

		
		/* Draw a box around MiniFig to test height and width */
		page.drawRect(mid - bob.getWidth()/2, top, bob.getWidth(), bob.getHeight());
		
		/* Draw the MiniFig */
		bob.draw();
		
		/* Draw some grass for the MiniFig to stand on */
		int figBaseYOffset = bob.getBaseMidPoint().y;
		Color grassGreen = new Color (60,80,38);
		page.setColor(grassGreen);
		page.fillRect(0, figBaseYOffset, getWidth(), getHeight() - figBaseYOffset );
		
		
		

	}


	/**
	 * Constructor (panel initialization)
	 */
	public MiniFigScalableDriver()
	{
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT));
	}


	/**
	 * Sets up a JFrame and the MiniFigDriver panel.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("MiniFigDriver");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MiniFigScalableDriver());
		frame.pack();
		frame.setVisible(true);
	}
}
