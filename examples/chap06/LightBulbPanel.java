import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Represents the image for the LightBulb program.
 * @author Java Foundations
 *
 */
@SuppressWarnings("serial")
public class LightBulbPanel extends JPanel
{
	private boolean on;
	private ImageIcon lightOn, lightOff;
	private JLabel imageLabel;

	/**
	 * Constructor: Sets up the images and the initial state.
	 */
	public LightBulbPanel()
	{
		lightOn = new ImageIcon("lightBulbOn.gif");
		lightOff = new ImageIcon("lightBulbOff.gif");

		setBackground(Color.black);

		on = true;
		imageLabel = new JLabel(lightOff);
		add(imageLabel);
	}

	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);

		if (on)
			imageLabel.setIcon(lightOn);
		else
			imageLabel.setIcon(lightOff);
	}

	
	/**
	 * Sets the status of the light bulb.
	 * @param lightBulbOn
	 */
	public void setOn(boolean lightBulbOn)
	{
		on = lightBulbOn;
	}
}
