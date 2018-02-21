import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Demonstrates how two buttons can be set up to use
 * the same ActionListener.
 * 
 * @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class TwoButtonsPanel extends JPanel
{
	private int counter;
	
	private JButton pushMeButton;
	private JButton dontPushMeButton;
	private JLabel pushCountLabel;
	
	/**
	 * Adds two buttons and a label to this panel and sets up
	 * the event handler (aka. action listener) for the buttons.
	 */
	public TwoButtonsPanel()
	{
		counter = 0;
		
		// Create one listener to share with both buttons.
		ButtonListener listener = new ButtonListener();
		
		pushMeButton = new JButton("Push Me!");
		pushMeButton.addActionListener(listener);
		
		dontPushMeButton = new JButton("Don't Push Me!");
		dontPushMeButton.addActionListener(listener);
		
		pushCountLabel = new JLabel("Pushes: " + counter);
		
		this.add(pushMeButton);
		this.add(dontPushMeButton);
		this.add(pushCountLabel);
	}

	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			// if we got here, a button was clicked.
			if(event.getSource() == pushMeButton) {
				counter++;
				pushCountLabel.setText("Pushes: " + counter);
			} else if (event.getSource() == dontPushMeButton) {
				System.exit(1);
			}
		}
	}
}
