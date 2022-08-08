import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

/**
 * Demonstrates creating and iterating ArrayLists using for and 
 * for-each loops.
 * 
 * @author CS121 instructors
 */
@SuppressWarnings("serial")
public class Rainbow extends JPanel
{
	private static final Random rand = new Random();
	
	/**
	 * Draws the picture in the panel.
	 * @param page Our graphics canvas.
	 */
	public void paintComponent (Graphics canvas)
	{
		int n = 10;
		int ovalWidth = getWidth()/n;
		
		/* Instantiate an empty list of colors */
		ArrayList<Color> rainbow = new ArrayList<Color>();
		
		/* Use a for loop to add n random colors */
		for(int i = 0; i < n; i++) {
			Color color = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
			rainbow.add(color);
		}
		
		/* Print each color using for loop (if we want to print index) */
		for(int i = 0; i < rainbow.size(); i++)
		{
			Color c = rainbow.get(i);
			System.out.println("Color " + i + ": " + c);
		}
		
		/* Print each color using for-each loop (no index) */
		for(Color c : rainbow)
		{
			System.out.println("Color: " + c);
		}
		
		/* Use for loop to draw dot (need i for x offset) */
		for(int i = 0; i < rainbow.size(); i++)
		{
			Color c = rainbow.get(i);
			canvas.setColor(c);
			canvas.fillOval(i*ovalWidth, 0, ovalWidth, ovalWidth);
		}
		
		/* Use for-each loop to find color with max green value */
		Color max = Color.BLACK; // smallest possible green value
		for(Color c : rainbow) {
			if(c.getGreen() > max.getGreen()) {
				max = c;
			}
		}
		canvas.setColor(max);
		canvas.fillOval(getWidth()/2 - ovalWidth, ovalWidth, ovalWidth*2, ovalWidth*2);
		System.out.println("Max Green Valule: " + max.getGreen());
	}


	/**
	 * Constructor (panel initialization)
	 */
	public Rainbow()
	{
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(400, 300));
	}


	/**
	 * Sets up a JFrame and the BlankCanvas panel.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Rainbow");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Rainbow());
		frame.pack();
		frame.setVisible(true);
	}
}
