import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;



/**
 * Represents the control panel for the LightBulb program.
 * @author Java Foundations (modified by amit)
 *
 */
@SuppressWarnings("serial")
public class LightBulbControls extends JPanel
{
	private LightBulbPanel bulb;
	private JButton onButton, offButton;

	/**
	 * Sets up the light bulb control panel.
	 * @param bulbPanel
	 */
	public LightBulbControls(LightBulbPanel bulbPanel)
	{
		bulb = bulbPanel;

		onButton = new JButton("On");
		onButton.setEnabled(false);
		onButton.setMnemonic(KeyEvent.VK_N); //Use Alt-n
		onButton.setToolTipText("Turn it on!");
		onButton.addActionListener(new OnListener());

		offButton = new JButton("Off");
		offButton.setEnabled(true);
		offButton.setMnemonic(KeyEvent.VK_F); // Use Alt-f
		offButton.setToolTipText("Turn it off!");
		offButton.addActionListener(new OffListener());

		setBackground(Color.black);
		add(onButton);
		add(offButton);
	}

	
	/**
	 * Represents the listener for the On butto
	 */
	private class OnListener implements ActionListener
	{
		// --------------------------------------------------------------
		// Turns the bulb on and repaints the bulb panel.
		// --------------------------------------------------------------
		public void actionPerformed(ActionEvent event)
		{
			bulb.setOn(true);
			onButton.setEnabled(false);
			offButton.setEnabled(true);
			bulb.repaint();
		}
	}

	
	/**
	 * Represents the listener for the Off button.
	 *
	 */
	private class OffListener implements ActionListener
	{
		// --------------------------------------------------------------
		// Turns the bulb off and repaints the bulb panel.
		// --------------------------------------------------------------
		public void actionPerformed(ActionEvent event)
		{
			bulb.setOn(false);
			onButton.setEnabled(true);
			offButton.setEnabled(false);
			bulb.repaint();
		}
	}
}
