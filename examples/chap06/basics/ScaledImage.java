package basics;

import java.awt.Dimension;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Demonstrate how to load an image and display in a JPanel. Also shows the use
 * of a scrollpane with an image.
 * @author amit
 *
 */
@SuppressWarnings("serial")
public class ScaledImage extends JFrame
{
	/**
	 * Create the main frame and add the image panel to it.
	 * @param args
	 */
	public static void main(String[] args)
	{
		if (args.length == 0) {
			System.err.println("Usage: java LoadImage <image filename>");
			System.exit(1);
		}

		final JFrame f = new JFrame("Load Image Demo");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		File imageFile = new File(args[0]);
		JPanel panel = new ScaledImagePanel(imageFile);
		f.setPreferredSize(new Dimension(200, 300));
		f.getContentPane().add(panel);
		f.pack();
		f.setVisible(true);
	}
}
