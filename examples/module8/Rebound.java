import javax.swing.JFrame;

/**
 * Demonstrates an animation and the use of the Timer class.
 * 
 * @author Java Foundations
 *
 */
public class Rebound {
	/**
	 * Displays the main frame of the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Rebound");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new ReboundPanel());

		frame.pack();
		frame.setVisible(true);
	}
}
