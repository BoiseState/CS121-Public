package converter3;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This version of the Converter class presents a more elaborate GUI for
 * interacting with the MetricConverter class.
 * 
 * @author Java, Java, Java
 * @author Modified by Amit Jain.
 */

@SuppressWarnings("serial")
public class Converter extends JPanel
{
	private final int NBUTTONS = 12;

	private JLabel prompt = new JLabel("Distance in miles: ");
	private JTextField input = new JTextField(6);
	private JTextArea display = new JTextArea(10, 20);
	private JButton convert = new JButton("Convert!");
	private JPanel keypadPanel = new JPanel();
	private Controller controller;

	private JButton[] keyPad; // An array of buttons
	// An array of button labels
	private String[] labels = 	{ "1", "2", "3", "4", "5", "6", "7", "8", "9", "C", "0", "." };
	private JScrollPane scroller;
	
	private Font myFont;

	/**
	 * Converter() constructor sets the layout and adds components to the
	 * top-level JFrame. Note that components are added to the ContentPane
	 * rather to the JFrame itself.
	 */
	public Converter()
	{
		myFont = new Font("Serif", Font.PLAIN, 16);
		setLayout(new BorderLayout());	

		controller = new Controller();
		initKeyPad();
		initMainPanel();
		
		convert.addActionListener(controller);
		input.addActionListener(controller);
	}

	

	/**
	 * initKeyPad() creates an array of JButtons and organizes them into a
	 * graphical key pad panel. Note that you must distinguish the JButton
	 * array, an internal memory structure, from the key pad panel, a graphical
	 * object that appears in the user interface.
	 */
	private void initKeyPad()
	{
		keypadPanel.setLayout(new GridLayout(4, 3, 1, 1));
		keyPad = new JButton[NBUTTONS]; // Create the array itself
		
		for (int k = 0; k < keyPad.length; k++) { // For each button
			keyPad[k] = new JButton(labels[k]); // Create a labeled button
			keyPad[k].addActionListener(controller); // and add a listener
			keypadPanel.add(keyPad[k]); // add button to the panel
		} 
	}
	
	/**
	 * Sets up all the panels
	 */
	private void initMainPanel()
	{
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
		prompt.setFont(myFont);
		input.setFont(myFont);
		inputPanel.add(prompt);
		inputPanel.add(input);
		add(inputPanel, BorderLayout.NORTH);

		JPanel controlPanel = new JPanel(new BorderLayout(0, 0));
		controlPanel.add(keypadPanel, BorderLayout.CENTER);
		controlPanel.add(convert, BorderLayout.SOUTH);
		add(controlPanel, BorderLayout.EAST);

		display.setFont(myFont);
		// display.setLineWrap(true);
		display.setEditable(false);
		scroller = new JScrollPane(display);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scroller, BorderLayout.CENTER);
	}
	
	/**
	 * Controller listens for various events and takes appropriate action.
	 *
	 */
	private class Controller implements ActionListener 
	{
		/**
		 * actionPerformed() handles all action events for the program. It must
		 * distinguish whether the user clicked on which button on the keypad or
		 * on the "Convert" or "Input" button.
		 * 
		 * @param e
		 *            the ActionEvent which prompted this method call
		 */
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == convert || e.getSource() == input) {
				try {
					double miles = Double.parseDouble(input.getText());
					double km = MetricConverter.milesToKm(miles);
					NumberFormat formatter = NumberFormat.getInstance();
					formatter.setMaximumFractionDigits(2);
					display.append(miles + " miles equals "
							+ formatter.format(km) + " kilometers\n");
				} catch (NumberFormatException error) {
					display.append("You have entered an invalid input: "
							+ input.getText() + "\n");
				}
				input.setText("");
			} else { // A keypad button was pressed
				JButton b = (JButton) e.getSource();
				if (b.getText().equals("C"))
					input.setText("");
				else
					input.setText(input.getText() + b.getText());
			}
		}
	}

	/**
	 * main() creates an instance of this (Converter) class and sets the size
	 * and visibility of its JFrame.
	 */
	public static void main(String args[])
	{
		JFrame f = new JFrame("Converter");
		Converter mainPanel = new Converter();
		f.getContentPane().add(mainPanel);
		f.setSize(500, 300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
