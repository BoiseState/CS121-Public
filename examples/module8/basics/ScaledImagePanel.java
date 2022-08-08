package basics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Demonstrate how to load an image, scale it to display in a JPanel. Also shows
 * the use of a scrollpane with an image.
 * 
 * @author amit
 * 
 */
@SuppressWarnings("serial")
public class ScaledImagePanel extends JPanel
{
	BufferedImage img;
	File imageFile;

	/**
	 * Read image from a file to display
	 * @param imageFile
	 */
	public ScaledImagePanel(File imageFile)
	{
		this.imageFile = imageFile;
		try {
			img = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.err.println(e);
		}

	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform at = AffineTransform.getScaleInstance(
								(double) getWidth()/img.getWidth(), 
								(double) getHeight()/img.getHeight());
		g2.drawImage(img, at, this);
	}

}
