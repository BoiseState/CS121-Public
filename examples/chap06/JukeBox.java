import javax.swing.JFrame;



/**
 * Demonstrates the use of a combo box.
 * @author Lewis/Loftus/amit
 *
 */
public class JukeBox
{
	/**
	 * Creates and displays the controls for a juke box.
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Java Juke Box");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JukeBoxControls controlPanel = new JukeBoxControls();

		frame.getContentPane().add(controlPanel);
		frame.pack();
		frame.setVisible(true);
	}
}
