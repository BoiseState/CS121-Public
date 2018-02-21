package basics;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 Shows how to create a text area with a vertical scrollbar and watch
 for selected text by listening on a button

 @author Amit Jain
*/

@SuppressWarnings("serial")
public class TextAreaAndButtons extends JFrame implements ActionListener
{
	private JTextArea display = new JTextArea(10,20); //recommended size in (rows, columns)
	private JButton button = new JButton("View");
	private JPanel panel = new JPanel();

	public TextAreaAndButtons()
	{
		setTitle("TextAreaAndButtons");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		display.setEditable(false);
		JScrollPane scroller = new JScrollPane(display, 
								JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
								JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.setLayout(new BorderLayout());
		panel.add(scroller, BorderLayout.CENTER);
		button.addActionListener(this);
		panel.add(button, BorderLayout.SOUTH);


		Container c = getContentPane();
		// The scrollpane now contains the the text area  via the display
		//  variable. So now we only need to add the scroll pane to the
		//  content pane.
		c.add(panel);
	}

	public void addMessages()
	{
		for (int i=0; i<5; i++)
			display.append("This is message #"+i+"\n");
	}


	public void actionPerformed(ActionEvent event)
	{
		Object source = event.getSource();
		if (source == button)
		{
			// check and print what was selected
			String temp = display.getSelectedText();
			display.append("You selected: "+temp+"\n");
		}
	}


	public static void main (String[] args)
	{
		TextAreaAndButtons frame1 = new TextAreaAndButtons();
		frame1.setSize(400,300);
		frame1.setVisible(true);
		frame1.addMessages();
	}

}//TextAreaAndButtons
