import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Demonstrates the use of text fields.
 * @author: Java Foundations
 * 
 */

@SuppressWarnings("serial")
public class FahrenheitPanel extends JPanel
{
	private static final Color LIGHT_GREEN = new Color(206, 255, 199);
	
	private JLabel inputLabel, outputLabel, resultLabel;
	private JTextField fahrenheit;
	private JButton enterButton;

	/**
	 * Constructor: Sets up the main GUI components.
	 */
	public FahrenheitPanel()
	{
		inputLabel = new JLabel("Temperature in Fahrenheit:");
		outputLabel = new JLabel("Temperature in Celsius: ");
		resultLabel = new JLabel("-");
		enterButton = new JButton("Calculate");

		fahrenheit = new JTextField(5);
		
		// Add the same action listener to text field (for when we hit enter key)
		// and the enter button. They should have same effect.
		TempListener listener = new TempListener();
		fahrenheit.addActionListener(listener);
		enterButton.addActionListener(listener);

		// Add all components to the this panel.
		add(inputLabel);
		add(fahrenheit);
		add(outputLabel);
		add(resultLabel);
		add(enterButton);

		setBackground(LIGHT_GREEN);
		setPreferredSize(new Dimension(275, 80));
	}

	/**
	 * Represents an action listener for the temperature input field.
	 */
	private class TempListener implements ActionListener
	{
		/**
		 * Performs the conversion when the enter key is pressed in
		 * the text field.
		 */
		public void actionPerformed(ActionEvent event)
		{
			// Get the text from the text field
			String text = fahrenheit.getText();

			double fahrenheitTemp = Double.parseDouble(text);
			double celsiusTemp = (fahrenheitTemp - 32) * 5.0 / 9;
			String result = String.format("%6.2f", celsiusTemp);

			resultLabel.setText(result);
		}
	}
}
