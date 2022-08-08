import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Demonstrates mnemonics and tool tips.
 * @author Java Foundations
 *
 */
public class LightBulb
{
	/**
	 * Sets up a frame that displays a light bulb image that can be turned on and off.
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Light Bulb");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		LightBulbPanel bulb = new LightBulbPanel();
		LightBulbControls controls = new LightBulbControls(bulb);

		JPanel panel = new JPanel();
		panel.setBackground(Color.black);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(bulb);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(controls);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
