import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author amit
 *
 */
public class PushCounterPanel extends JPanel {
	
	PushButton incButton, decButton;
	JLabel label;
	
	public PushCounterPanel() {
		label = new JLabel("Pushes: 0");
		
		incButton = new PushButton("increment", label);
		decButton = new PushButton("decrement", label);
		
		add(incButton);
		add(decButton);
		add(label);
		
	}

}
