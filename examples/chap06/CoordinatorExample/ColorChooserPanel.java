package CoordinatorExample;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/** Example GUI demonstrating coordination of components between panels.
 * This panel creates a grid of color buttons.
 * The listener that will respond to these buttons' ActionEvents is passed in to the panel constructor.
 * @author mvail
 */
@SuppressWarnings("serial")
public class ColorChooserPanel extends JPanel {
	private Color[] colors = {Color.black, Color.blue, Color.cyan, 
			Color.green, Color.magenta, Color.orange, 
			Color.white, Color.red, Color.yellow};
	
	/** Create a grid of color buttons and register them all to use the given listener.
	 * @param buttonListener the listener for all buttons
	 */
	public ColorChooserPanel(ActionListener buttonListener) {
		this.setLayout(new GridLayout(3, 3));
		this.setPreferredSize(new Dimension(200,200));
		
		for (int i = 0; i < colors.length; i++) {
			JButton button = new JButton();
			button.setBackground(colors[i]);
			button.addActionListener(buttonListener);
			this.add(button);
		}
	}
}
