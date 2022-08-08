import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

/**
 * Demonstrates basic setup and use of a JList.
 * @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class JListDemoPanel extends JPanel
{
	private final String[] DEFAULT_NAMES = { "Jane Resnick", "Jim Smith", "Bruce Chow", "Countess Ada" };

	private ArrayList<String> classRoster;
	private JList<String> nameJList;

	private JLabel statusLine;
	private JButton addButton;

	/**
	 * Initializes the main GUI panel.
	 */
	public JListDemoPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initNameListPanel();
		initStatusPanel();
		initControlPanel();
	}

	/**
	 * Initializes the name list sub-panel and adds it to the main panel (this).
	 */
	private void initNameListPanel()
	{
		// Just a way to add default values to the ArrayList. We are using an ArrayList
		// because we expect the size of the list to change when users add/remove names.
		classRoster = new ArrayList<String>(Arrays.asList(DEFAULT_NAMES));

		// Create an empty list and set the font and action listener.
		nameJList = new JList<String>();
		nameJList.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		nameJList.addListSelectionListener(new NameListListener());

		// Synchronize the data with the data in the ArrayList.
		syncNameList(); // (this method is implemented below)

		// Create the scroll pane and add the list to it.
		JScrollPane scrollPane = new JScrollPane(nameJList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Add the scroll pane to this panel.
		this.add(scrollPane);
	}

	/**
	 * Initializes the status sub-panel and adds it to the main panel (this).
	 */
	private void initStatusPanel()
	{
		JPanel statusPanel = new JPanel();
		statusLine = new JLabel("(none)");

		statusPanel.add(new JLabel("Selected Name: "));
		statusPanel.add(statusLine);

		// Add the status panel to the main panel.
		this.add(statusPanel);
	}

	/**
	 * Initializes the control sub-panel and adds it to the main panel (this).
	 */
	private void initControlPanel()
	{
		JPanel controlPanel = new JPanel();
		addButton = new JButton("Add Name");
		addButton.addActionListener(new ButtonListener());

		controlPanel.add(addButton);

		// Add the status panel to the main panel.
		this.add(controlPanel);
	}

	/**
	 * Synchronizes the data JList ("view") with the data in the ArrayList ("model").
	 */
	private void syncNameList()
	{
		String[] nameArray = getNameArray();

		// Update the JList with the new array data.
		nameJList.setListData(nameArray);
	}

	/**
	 * Converts the ArrayList to an array so we can add it to the JList.
	 */
	private String[] getNameArray()
	{
		// Copy the contents from the ArrayList to an array.
		String[] nameArray = new String[classRoster.size()];
		for(int i = 0; i < nameArray.length; i++){
			nameArray[i] = classRoster.get(i);
		}
		return nameArray;
	}

	/**
	 * Adds the given name to the ArrayList of names and updates the GUI JList
	 * with the new list of names.
	 * @param name The name to add.
	 */
	private void addName(String name)
	{
		classRoster.add(name);
		syncNameList(); // Make sure we are keeping the GUI list in sync
	}

	/**
	 * Handles events from the JList of Strings.
	 * Updates the status message when a name is selected in the JList.
	 */
	private class NameListListener implements ListSelectionListener
	{
		@Override
		public void valueChanged(ListSelectionEvent event)
		{
			int index = nameJList.getSelectedIndex();
			if(index < 0) { // Nothing selected.
				statusLine.setText("(none)");
			} else {
				String name = nameJList.getSelectedValue();
				statusLine.setText("(" + index + ") " + name);
			}
		}
	}

	/**
	 * Prompts the user for a name when the add user button is pressed. Adds the
	 * given name to the list of names.
	 */
	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == addButton) {
				String input = JOptionPane.showInputDialog("Enter an name: ");
				addName(input);
			}
		}
	}
}
