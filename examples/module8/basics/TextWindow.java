package basics;


import java.awt.*;
import javax.swing.*;

/**
 Shows how to create a text area with a vertical scrollbar.
 @author amit
*/

@SuppressWarnings("serial")
public class TextWindow extends JFrame
{
	private JTextArea display = new JTextArea(10,20); //recommended size in (rows, columns)

	public TextWindow()
	{
		setTitle("TextWindow");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		display.setEditable(false);
		JScrollPane scroller = new JScrollPane(display, 
								JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
								JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroller.setMinimumSize(new Dimension(200,200));
		scroller.setMaximumSize(new Dimension(200,200));
		Container c = getContentPane();

		// The scrollpane now contains the the text area  via the display
		//  variable. So now we only need to add the scroll pane to the
		//  content pane.
		c.add(scroller);
	}

	public void addMessages()
	{
		for (int i=0; i<30; i++)
			display.append("This is message #"+i+"\n");
	}



	public static void main (String[] args)
	{
		TextWindow frame1 = new TextWindow();
		frame1.setSize(400,300);
		frame1.setVisible(true);
		frame1.addMessages();
	}

}
