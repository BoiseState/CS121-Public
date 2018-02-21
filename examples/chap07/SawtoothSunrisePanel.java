

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * Animate a <b>sunrise</b> at a lake in the Sawtooth Range.
 * 
 * @author amit
 */

@SuppressWarnings("serial")
public class SawtoothSunrisePanel extends JPanel
{
	private final int NFRAMES = 25;
	private int index = 0;
	private final int delay = 500; //milliseconds
	// Declare an array of Image objects
	private BufferedImage[] sunrise = new BufferedImage[NFRAMES];

	/**
	 * Constructor loads the images from jpg files.
	 */
	public SawtoothSunrisePanel()
	{
		System.out.println("Loading images. Please wait..."); 
		String filename = "";
		for (int i = 0; i < NFRAMES; i++) {
			filename = String.format("images/%02d.jpg", i);
			try {
				System.out.println("Reading image "+filename);
				sunrise[i] = ImageIO.read(new File(filename));
			} catch (IOException e) {
				System.err.println(filename+ " : " + e);
			}
			setPreferredSize(new Dimension(sunrise[0].getWidth(null), sunrise[0].getHeight(null)));
			
		}
		System.out.println("Done loading images");
		startAnimation();
	} 

	
	/**
	 * The paint() method is called automatically after init(). It uses the
	 * applet's Graphics object to display the images.
	 * 
	 * @param Graphics
	 *            g provides a reference to the applet's Graphics object
	 */
	public void paintComponent(Graphics g)
	{
		if (index < NFRAMES-1) index++;
		g.drawImage(sunrise[index], 0, 0, null);
	}
	
	
	/**
	 * Create an animation thread that runs once per second
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
