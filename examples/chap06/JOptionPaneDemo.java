import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("javadoc")
public class JOptionPaneDemo
{
	/**
	 * Creates a JFrame and adds the main JPanel to the JFrame.
	 * @param args (unused)
	 */
	public static void main(String args[])
	{
		JFrame frame = new JFrame("JOptionPane Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new JOptionPaneDemoPanel());
		frame.setPreferredSize(new Dimension(250, 150));
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
}
