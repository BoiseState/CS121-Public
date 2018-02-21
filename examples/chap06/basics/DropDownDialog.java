package basics;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 Shows how to create a drop down dialog box.
 @author Amit Jain
*/

@SuppressWarnings("serial")
public class DropDownDialog extends JFrame implements ActionListener
{
	private String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
		                           "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	private JButton button = new JButton("Show Months");
	private JTextArea display = new JTextArea(4,20);


	public DropDownDialog()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		display.setEditable(false);
		c.add(display, BorderLayout.CENTER);
		button.addActionListener(this);
		c.add(button, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent event)
	{
		Object source = event.getSource();

		if (source == button)
		{
			showMonthDialog();
		}
	}

	private void showMonthDialog()
	{
		String monthInput = (String) JOptionPane.showInputDialog(null, 
													"Select Month", 
													"Month Selector", 
													JOptionPane.QUESTION_MESSAGE, 
													null, 
													monthNames, monthNames[0]);
		display.append("You selected " + monthInput + "\n");
	}
	

	public static void main (String[] args)
	{
		DropDownDialog frame = new DropDownDialog();
		frame.setSize(200,200);
		frame.setVisible(true);
	}
	
}

