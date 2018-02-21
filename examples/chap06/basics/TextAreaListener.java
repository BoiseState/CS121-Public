package basics;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 Illustrates how to listen for selection in the text area using MouseListener.

 @author amit
*/

@SuppressWarnings("serial")
public class TextAreaListener extends JFrame implements ActionListener
{
	private JTextArea display = new JTextArea(10,20); //recommended size in (rows, columns)
	private JButton button = new JButton("View");
	private JPanel panel = new JPanel();

	public TextAreaListener()
	{
		setTitle("TextAreaListener");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		display.setEditable(false);
		//display.addMouseListener(new myMouseAdapter());
		display.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) { checkSelection(); }
			public void mouseReleased(MouseEvent event) { checkSelection(); }
		});
		JScrollPane scroller = new JScrollPane(display, 
								JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
								JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		panel.setLayout(new BorderLayout());
		panel.add(scroller, "Center");
		button.addActionListener(this);
		panel.add(button, "South");


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
			checkSelection();
		}
	}

	private void checkSelection()
	{
		// check and print what was selected
		String temp = display.getSelectedText();
		if (temp != null)
			display.append("You selected: "+temp+"\n");
	}


	private class myMouseAdapter extends MouseAdapter
	{
		public void mouseClicked(MouseEvent event) { checkSelection(); }
		public void mouseReleased(MouseEvent event) { checkSelection(); }
	}

	public static void main (String[] args)
	{
		TextAreaListener frame1 = new TextAreaListener();
		frame1.setSize(400,300);
		frame1.setVisible(true);
		frame1.addMessages();
	}

}
