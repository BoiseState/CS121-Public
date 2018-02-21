import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Demonstrates the use of check boxes.
 * 
 * @author Java Foundations
 */
@SuppressWarnings("serial")
public class StyleOptionsPanel extends JPanel
{
	private JLabel saying;
	private JCheckBox bold, italic;

	/**
	 * Sets up a panel with a label and some check boxes that 
	 * control the style of the label's font.
	 */
	public StyleOptionsPanel()
	{
		saying = new JLabel("Say it with style!");
		saying.setFont(new Font("Helvetica", Font.PLAIN, 36));

		Color lightRed = new Color(255, 94, 89);
		bold = new JCheckBox("Bold");
		bold.setBackground(lightRed);
		italic = new JCheckBox("Italic");
		italic.setBackground(lightRed);

		StyleListener listener = new StyleListener();
		bold.addItemListener(listener);
		italic.addItemListener(listener);

		add(saying);
		add(bold);
		add(italic);

		Color lightGreen = new Color(206, 255, 199);
	    setBackground(lightGreen);
		setPreferredSize(new Dimension(350, 100));
	}

	
	/**
	 * Represents the listener for both check boxes.
	 */
	private class StyleListener implements ItemListener {
		// --------------------------------------------------------------
		// Updates the style of the label font style.
		// --------------------------------------------------------------
		public void itemStateChanged(ItemEvent event)
		{
			int style = Font.PLAIN;

			if (bold.isSelected()) {
				style = Font.BOLD;
			}

			if (italic.isSelected()) {
				style += Font.ITALIC;
			}

			saying.setFont(new Font("Helvetica", style, 36));
		}
	}
}
