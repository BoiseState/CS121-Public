import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * Shows how to set up and read fields from a pop-up input form.
 * More JOptionPane examples are available in EvenOdd.java.
 * 
 * @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class JOptionPaneDemoPanel extends JPanel
{
	private JButton addUserButton;
	
	private JLabel nameLabel;
	private JLabel ageLabel;
	
	/**
	 * Initializes the main panel.
	 */
	public JOptionPaneDemoPanel()
	{
		// A trick to change font/color for all labels. 
		UIManager.put("Label.font", UIManager.getFont("Label.font").deriveFont(Font.BOLD, 16));
		UIManager.put("Label.foreground", Color.BLUE);
		
		setLayout(new BorderLayout());

		addUserButton = new JButton("Add User");
		addUserButton.addActionListener(new ButtonActionListener());
		
		nameLabel = new JLabel("(unknown)");
		ageLabel = new JLabel("(unknown)");
		
		JPanel formOutputPanel = new JPanel();
		
		formOutputPanel.add(new JLabel("Hi "));
		formOutputPanel.add(nameLabel);
		formOutputPanel.add(new JLabel(" I didn't know you were "));
		formOutputPanel.add(ageLabel);
		formOutputPanel.add(new JLabel(" years old."));
		
		add(formOutputPanel, BorderLayout.CENTER);
		add(addUserButton, BorderLayout.SOUTH);
	}
	
	/**
	 * Listens for events from the Add User button. When the button is clicked,
	 * a pop-up with a form is shown.
	 */
	private class ButtonActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			showForm();
		}
	}
	
	/**
	 * Pops up an input form using a JOptionPane. Reads the data from the form
	 * when the user clicks "OK". If the user clicks "CANCEL", nothing happens.
	 */
	private void showForm()
	{
		JPanel formInputPanel = new JPanel();
		formInputPanel.setLayout(new BoxLayout(formInputPanel, BoxLayout.Y_AXIS));
		
		JTextField nameField = new JTextField(20);
		JTextField ageField = new JTextField(5);
		
		formInputPanel.add(new JLabel("Name: "));
		formInputPanel.add(nameField);
		formInputPanel.add(new JLabel("Age: "));
		formInputPanel.add(ageField);
		
		int result = JOptionPane.showConfirmDialog(null, formInputPanel, "Add User",
    			JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		// If they click okay, then we will process the form data. The validation here isn't
		// very good. We could make sure they didn't enter an empty name. We could keep asking
		// them for valid input.
		if (result == JOptionPane.OK_OPTION)
		{
			String name = nameField.getText();
			int age = 0;
			try
			{
				age = Integer.parseInt(ageField.getText());
				if(age < 0) {
					JOptionPane.showMessageDialog(null, "You can't be a negative age. Silly...");
					
				}
			}
			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Your age needs to be a number. Silly...");
			}
			nameLabel.setText(name);
			ageLabel.setText(Integer.toString(age));
		}
	}
}
