package orderapplication;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * This example application introduces some additional Swing components, including the
 * JCheckBox and JRadioButton classes. An ItemListener interface is implemented
 * to support check box and radio button actions. Also, the BorderFactory class
 * is used to create borders around various areas of the application main panel.
 * 
 * @author: Java, Java, Java
 * @author amit
 */

public class OrderApplication 
{
	/**
	 * Creates a JFrame and adds the main JPanel to the JFrame.
	 */
	public static void main(String args[])
	{
		JFrame frame = new JFrame("Direction");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new OrderApplicationPanel());
		frame.setPreferredSize(new Dimension(600, 400));
		frame.pack();
		frame.setVisible(true);
	}
}
