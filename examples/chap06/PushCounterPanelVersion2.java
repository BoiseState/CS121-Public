import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Demonstrates a graphical user interface and an event listener.
 * 
 * @author Java Foundations
 */
@SuppressWarnings("serial")
public class PushCounterPanelVersion2 extends JPanel {
	private static final Color LIGHT_GREEN = new Color(206, 255, 199);

	private MyButton incrementButton;
	private MyButton decrementButton;
	private JLabel pushCountLabel = new JLabel("Pushes: 0");;

	/**
	 * Constructor: Sets up the GUI panel
	 */
	public PushCounterPanelVersion2() {
		// TODO: Set background color and add border to panel.
		// this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder("Push Counter Panel"));
		this.setBackground(LIGHT_GREEN);

		// initialize the panels
		createButtonPanel();
		createLabelPanel();
	}

	private void createLabelPanel() {
		// Create a sub-panel for label.
		JPanel labelPanel = new JPanel();
		labelPanel.setBackground(Color.YELLOW);
		labelPanel.setBorder(BorderFactory.createTitledBorder("Label Panel"));
		labelPanel.setPreferredSize(new Dimension(200, 50));

		// Add label to sub-panel.
		labelPanel.add(pushCountLabel);

		// Add label to sub-panel.
		add(labelPanel, BorderLayout.SOUTH);
	}

	private void createButtonPanel() {
		// Create sub-panel for buttons.
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setBackground(Color.lightGray);
		buttonPanel.setBorder(BorderFactory.createTitledBorder("Button Panel"));

		// Create and add increment button to sub-panel
		incrementButton = new MyButton("increment", pushCountLabel);
		incrementButton.addActionListener(incrementButton);
		buttonPanel.add(incrementButton);

		// Create and add decrement button to sub-panel
		decrementButton = new MyButton("decrement", pushCountLabel);
		decrementButton.addActionListener(decrementButton);
		buttonPanel.add(decrementButton);

		// Add button sub-panel to this PushCounterPanel
		add(buttonPanel, BorderLayout.CENTER);
	}
}
