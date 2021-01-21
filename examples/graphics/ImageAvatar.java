import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.ImageIcon;

/**
 * Demonstrates the use of image icons.
 * 
 * @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class ImageAvatar extends JPanel
{
	public void paintComponent(Graphics page)
	{
		page.setColor(Color.black);
		page.fillRect(0, 0, getWidth(), getHeight());

		// Draw the image on the page. Note that this does not
		// scale. You will need to change the values of the
		// width and height to make it scale.
		ImageIcon avatar = new ImageIcon("amitAvatar.png");
		//ImageIcon avatar = new ImageIcon("myAvatar.png");
		page.drawImage(avatar.getImage(), 50, 50, 200, 200, null);
	}

	/**
	 * Constructor: panel initialization
	 */
	public ImageAvatar()
	{
		setBackground(Color.white);
		setPreferredSize(new Dimension(300, 300));
	}

	/**
	 * Starting point for Shapes application.
	 * 
	 * @param args
	 *            unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Avatar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new ImageAvatar());
		frame.pack();
		frame.setVisible(true);
	}
}
