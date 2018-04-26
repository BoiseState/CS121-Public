import javax.swing.JFrame;

/**
 * Represents a LiteBrite game board GUI. 
 *
 * @author CS121 Instructors
 */
public class LiteBrite
{
	/**
	 * Creates a JFrame and adds the main JPanel to the JFrame.
	 * @param args (unused)
	 */
	public static void main(String args[])
	{
		JFrame frame = new JFrame("Lite Brite");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new LiteBritePanel(20, 20));
		frame.pack();
		frame.setVisible(true);
	}
}
