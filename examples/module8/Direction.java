import javax.swing.JFrame;

/**
 * Demonstrates key events.
 * 
 * @author amit
 *
 */
public class Direction {
	/**
	 * Creates and displays the application frame.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Direction");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new DirectionPanel());

		frame.pack();
		frame.setVisible(true);
	}
}
