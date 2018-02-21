import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Centers a string of text in the window
 * @author Java, Java, Java, 2E, converted to GUI by mvail
 */
@SuppressWarnings("serial")
public class CenterText extends JPanel
{
	/**
	 * displays a text string centered in the window.
	 */
	public void paintComponent(Graphics canvas)
	{
		super.paintComponent(canvas); // clears the background
		setBackground(Color.orange);

		// Get the frame's size
		int width = getWidth();
		int height = getHeight();

		String str = "Hello World!";

		canvas.setFont(new Font("Serif", Font.BOLD, 36));

		// Get Font's metrics to allows us to figure out it's size
		FontMetrics metrics = canvas.getFontMetrics();

		// Use metrics to calculate center point coordinates for the string
		int x = (width - metrics.stringWidth(str)) / 2;
		int y = (height + metrics.getHeight()) / 2;

		canvas.setColor(Color.black);
		canvas.drawString(str, x, y);
	}


	/**
	 * Constructor (panel initialization)
	 */
	public CenterText()
	{
		setPreferredSize(new Dimension(500, 500));
	}

	/**
	 * Starting point for CenterText application.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("CenterText");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new CenterText());
		frame.pack();
		frame.setVisible(true);
	}
}
