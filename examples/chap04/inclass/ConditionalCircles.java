package inclass;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Color;

/**
 * Demonstrates how conditionals can be used to modify output
 * based on radius of circle.
 * 
 * @author CS121 instructors
 */
@SuppressWarnings("serial")
public class ConditionalCircles extends JPanel
{
	/* Timer delay */
	private final int DELAY = 1000; //milliseconds
	
	/* For generating random radius */
	private Random random = new Random();
	
	/**
	 * Draws the picture in the panel. This is where all of your
	 * code will go.
	 * @param page Our graphics canvas.
	 */
	public void paintComponent (Graphics page)
	{
		final int MAX_DIAMETER = Math.min(getWidth(), getHeight());
		
		int diameter = random.nextInt(MAX_DIAMETER) + 1; // 1 to MAX
		
		// if circle diameter is greater than 100, then set color to red
		if(diameter > 100)
		{
			page.setColor(Color.RED);
		}
		
		// draw the oval
		page.fillOval(0, 0, diameter, diameter);
	}


	/**
	 * Constructor (panel initialization)
	 */
	public ConditionalCircles()
	{
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(800, 600));
		startAnimation();
	}


	/**
	 * Sets up a JFrame and the BlankCanvas panel.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Conditional Circles");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new ConditionalCircles());
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
