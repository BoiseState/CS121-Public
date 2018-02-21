import javax.swing.JFrame;

/**
 * Demonstrates the use of check boxes.
 * 
 * @author Java Foundations
 */
public class StyleOptions {
	/**
	 * Creates and displays the style options frame.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Style Options");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new StyleOptionsPanel());

		frame.pack();
		frame.setVisible(true);
	}
}
