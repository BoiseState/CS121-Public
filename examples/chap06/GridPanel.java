import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Represents the panel in the LayoutDemo program that demonstrates the grid
 * layout manager.
 * 
 * @author Java Foundations
 * @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class GridPanel extends JPanel
{
	/**
	 * Sets up this panel with some buttons to show how grid layout affects
	 * their position, shape, and size.
	 */
	public GridPanel()
	{
		setLayout(new GridLayout(2, 3));		

		JButton[] buttons = new JButton[5];
		
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("BUTTON " + (i + 1));
			buttons[i].setFont(new Font("Arial", Font.BOLD, 24));
			add(buttons[i]);
		}
	}
}
