import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Revised version of Fahrenheit example to demonstrate use of sub-panels
 * to organize controls within a GUI.
 * @author Java Foundations - original code
 * @author mvail - comments and refactoring to use sub-panels for better organization
 */
@SuppressWarnings("serial")
public class FahrenheitPanel_Improved extends JPanel
{
	private JLabel inputLabel, outputLabel, resultLabel;
	private JTextField fahrenheit;
	private JButton enterButton;

	/**
	 * Constructor: Sets up the main GUI components.
	 */
	public FahrenheitPanel_Improved()
	{
		/*
		 * When assembling GUIs, it is a good idea to create and configure
		 * elements before adding them to containers.
		 * In this section, all of the controls are created and configured,
		 * but none of them will appear until they are added to this panel
		 * or to a sub-panel that is added to this panel.
		 */
		inputLabel = new JLabel("Temperature in Fahrenheit:");
		outputLabel = new JLabel("Temperature in Celsius: ");
		resultLabel = new JLabel("-");
		enterButton = new JButton("Calculate");
		fahrenheit = new JTextField(5);
		fahrenheit.setToolTipText("Enter Fahrenheit temperature as a floating point value.");
		TempListener listener = new TempListener(); //going to reuse one listener because
		fahrenheit.addActionListener(listener); //result of hitting Enter in text field should
		enterButton.addActionListener(listener);//be exactly the same as for clicking the button

		/*
		 * I want to organize the layout of all controls so input is always
		 * at the top, the calculate button is always in the middle, and the
		 * output is always on the bottom. I don't want resizing the window
		 * to affect that organization, so I am setting this panel (the
		 * FahrenheitPanel) to a vertically-oriented BoxLayout.
		 * I will then create sub-panels to hold the components I want in
		 * each area.
		 */
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		/* 
		 * Declare 3 sub-panels. Just so we can see where each
		 * panel is in the final GUI, make the middle panel
		 * a different color.
		 */
		JPanel top = new JPanel();
		JPanel middle = new JPanel();
		JPanel bottom = new JPanel();
		middle.setBackground(new Color(206, 255, 199));
		
		//Add input controls to the top panel.
		top.add(inputLabel);
		top.add(fahrenheit);
		
		//Add the button to the middle panel.
		middle.add(enterButton);
		
		//Add output controls to the bottom panel.
		bottom.add(outputLabel);
		bottom.add(resultLabel);
		
		/*
		 * Add the 3 sub-panels (containing their controls) to this panel.
		 * NOW that all sub-panels (containing their controls) have been
		 * added to this panel, controls will actually appear on the GUI.
		 */
		this.add(top);
		this.add(middle);
		this.add(bottom);
		
		/*
		 * Final panel/component organization:
		 * 
		 * this (vertical BoxLayout)
		 *  |_top (default FlowLayout)
		 *     |_inputLabel
		 *     |_fahrenheit
		 *  |_middle (default FlowLayout)
		 *     |_enterButton
		 *  |_bottom (default FlowLayout
		 *     |_outputLabel
		 *     |_resultLabel
		 */
		
		/*
		 * You can specify a preferred size for this panel, but if you
		 * don't, it will "shrink-wrap" the components inside.
		 * It is generally best to specify as little as possible
		 * and let the GUI figure out how to display itself.
		 * With GUIs, "If it ain't broke, don't force it."
		 */
//		this.setPreferredSize(new Dimension(275, 100));
	}

	/**
	 * Represents an action listener for the temperature input field.
	 */
	private class TempListener implements ActionListener
	{
		// Performs the conversion when the enter key is pressed in
		// the text field.
		public void actionPerformed(ActionEvent event)
		{
			double fahrenheitTemp, celsiusTemp;

			String text = fahrenheit.getText();

			fahrenheitTemp = Double.parseDouble(text);
			celsiusTemp = (fahrenheitTemp - 32) * 5.0 / 9;
			String result = String.format("%6.2f", celsiusTemp);

			resultLabel.setText(result);
		}
	}
}
