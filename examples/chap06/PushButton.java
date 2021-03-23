import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * 
 */

/**
 * @author amit
 *
 */
public class PushButton extends JButton {
	
	private static int count;
	private JLabel pushLabel;
	
	public PushButton(String label, JLabel pushLabel) 
	{
		setText(label);
		count = 0;
		this.pushLabel = pushLabel;
		addActionListener(new ButtonListener());
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}

	
	private class ButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			PushButton button = (PushButton) e.getSource();
			
			if (button.getText().equals("increment")) {
				count++;
			} else if (button.getText().equals("decrement")) {
				count--;
			}
			pushLabel.setText("Pushes: " + count);
		}
	}
}
