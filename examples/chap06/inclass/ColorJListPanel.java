package inclass;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

/**
 * Demonstrates basic setup and use of a JList.
 * 
 * @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class ColorJListPanel extends JPanel
{
	// Model: Underlying data of GUI
	private CrayonBox colors;

	// View: Components visible to user
	private JList<Color> colorList;
	private JPanel colorDisplayPanel;
	private JButton downButton;

	/**
	 * Initializes the main GUI panel.
	 */
	public ColorJListPanel()
	{
		setLayout(new GridLayout(3, 1));

		colors = new CrayonBox(10);
	
		colorList = new JList<Color>();
		colorList.setListData(colors.getColorArray());
		colorList.addListSelectionListener(new ColorListListener());

		JScrollPane scrollPane = new JScrollPane(colorList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		colorDisplayPanel = new JPanel();

		JPanel buttonPanel = new JPanel();
		ButtonListener listener = new ButtonListener();
		
		downButton = new JButton("V");
		downButton.addActionListener(listener);
		
		buttonPanel.add(downButton);

		add(scrollPane);
		add(buttonPanel);
		add(colorDisplayPanel);

		colorList.setSelectedIndex(0);
	}

	/**
	 * Represents a listener for button push (action) events.
	 */
	private class ButtonListener implements ActionListener
	{
		/**
		 * Updates the counter and label when the button is pushed.
		 */
		public void actionPerformed(ActionEvent event)
		{
			int index = colorList.getSelectedIndex();
			
			if(index == colors.getNumColors() - 1)
			{
				index = 0;
			}
			else
			{
				index += 1;
			}
			colorList.setSelectedIndex(index);
		}
	}

	/**
	 * Handles events from the JList of Colors. Changes to background
	 * to the selected color.
	 */
	private class ColorListListener implements ListSelectionListener
	{
		@Override
		public void valueChanged(ListSelectionEvent event)
		{
			Color color = colorList.getSelectedValue();
			colorDisplayPanel.setBackground(color);
		}
	}
}
