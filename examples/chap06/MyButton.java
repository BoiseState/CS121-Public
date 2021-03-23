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
public class MyButton extends JButton implements ActionListener {
	
	private static int count;
	private JLabel pushLabel;
	
	public MyButton(String label, JLabel pushLabel) {
		super(label);
		count = 0;
		this.pushLabel = pushLabel;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyButton button = (MyButton) e.getSource();
		if (button.getText().equals("increment")) {
			count++;
		} else if (button.getText().equals("decrement")) {
			count--;
		}
		pushLabel.setText("Pushes: " + count);
	}

}
