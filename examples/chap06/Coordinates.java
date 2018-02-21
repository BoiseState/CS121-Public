import javax.swing.JFrame;

/**
 * Demonstrates mouse events.
 * 
 * @author Java Foundations
 *
 */
public class Coordinates {
	/**
	 * Creates and displays the application frame.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Coordinates");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new CoordinatesPanel());

		frame.pack();
		frame.setVisible(true);
	}
}
