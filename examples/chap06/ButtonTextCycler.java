import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Demonstrate changing the text of a button in response to an event.
 * @author mvail
 */
@SuppressWarnings("serial")
public class ButtonTextCycler extends JPanel implements ActionListener {
	private JButton button;
	private final String[] buttonText = {"Hi", "Stop that!", "Go away!", "Ow!", "Come on!", "Oof!",
		"Don't!", "Meanie!", "Hey!", "Really?"};
	private int textIndex;
	
	/**
	 * main panel constructor
	 */
	private ButtonTextCycler() {
		textIndex = 0;
		
		button = new JButton(buttonText[textIndex]);
		button.addActionListener(this);
		
		this.add(button);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		textIndex = (textIndex + 1) % buttonText.length;
		button.setText(buttonText[textIndex]);
	}

	/**
	 * @param args unused
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Button Text Cycler");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new ButtonTextCycler());
		frame.pack();
		frame.setVisible(true);
	}
}
