import javax.swing.JFrame;

/**
 * Demonstrates mouse events and rubberbanding.
 * 
 * @author Java Foundations
 *
 */
public class RubberLines {
	/**
	 * Creates and displays the application frame.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Rubber Lines");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new RubberLinesPanel());

		frame.pack();
		frame.setVisible(true);
	}
}
