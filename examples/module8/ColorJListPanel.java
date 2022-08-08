import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

/**
 * Demonstrates basic setup and use of a JList.
 * @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class ColorJListPanel extends JPanel
{
	private Color[] colors = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE };

	private JList<Color> colorList;
	private JLabel colorLabel;

	/**
	 * Initializes the main GUI panel.
	 */
	public ColorJListPanel()
	{
		setLayout(new GridLayout(2, 1));
		// Create an empty list and set the font and action listener.
		colorList = new JList<Color>(colors);
		colorList.addListSelectionListener(new ColorListListener());

		// Create the scroll pane and add the list to it.
		JScrollPane scrollPane = new JScrollPane(colorList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		colorLabel = new JLabel();
		colorLabel.setOpaque(true); // Make sure the background isn't set to transparent
		colorLabel.setBackground(Color.BLACK);

		// Add the scroll pane to this panel.
		this.add(scrollPane);
		this.add(colorLabel);
	}

	/**
	 * Handles events from the JList of Strings.
	 * Updates the status message when a name is selected in the JList.
	 */
	private class ColorListListener implements ListSelectionListener
	{
		@Override
		public void valueChanged(ListSelectionEvent event)
		{
			Color color = colorList.getSelectedValue();
			if(color == null) { // Nothing selected.
				colorLabel.setBackground(Color.BLACK);
			} else {
				colorLabel.setBackground(color);
			}
		}
	}
}
