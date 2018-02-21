import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Represents the panel in the LayoutDemo program that demonstrates the flow
 * layout manager.
 * 
 * @author Java Foundations
 */
@SuppressWarnings("serial")
public class FlowPanel extends JPanel {
	/**
	 * Sets up this panel with some buttons to show how flow layout affects
	 * their position.
	 */
	public FlowPanel()
	{
		setLayout(new FlowLayout());

		JButton b1 = new JButton("BUTTON 1");
		JButton b2 = new JButton("BUTTON 2");
		JButton b3 = new JButton("BUTTON 3");
		JButton b4 = new JButton("BUTTON 4");
		JButton b5 = new JButton("BUTTON 5");

		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
	}
}
