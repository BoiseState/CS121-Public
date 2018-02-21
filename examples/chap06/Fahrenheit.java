import javax.swing.JFrame;

/**
 * Demonstrates the use of text fields.
 * @author: Java Foundations
 */
public class Fahrenheit
{
	/**
	 * Creates and displays the temperature converter GUI.
	 * @param args
	 */
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("Fahrenheit");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		FahrenheitPanel panel = new FahrenheitPanel();

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
