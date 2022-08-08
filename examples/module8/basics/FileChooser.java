package basics;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


/**
  Demonstrates the use of a file chooser and a text area.
  @author Lewis and Loftus.
  @author amit
 */



public class FileChooser
{
	/**
	 * Opens a file chooser dialog, reads the selected file and loads it into a
	 * text area.
	 */
	public static void main(String[] args) throws IOException
	{
		JFrame frame = new JFrame("Display File");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTextArea ta = new JTextArea(20, 30);
		JScrollPane scrollpane = new JScrollPane(ta,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// The following starts in the home folder
		//JFileChooser chooser = new JFileChooser();

		// The following starts in the current folder, which is often convenient
		JFileChooser chooser = new JFileChooser(".");
		
		int status = chooser.showOpenDialog(null);

		if (status != JFileChooser.APPROVE_OPTION)
			ta.setText("No File Chosen");
		else {
			File file = chooser.getSelectedFile();
			Scanner scan = new Scanner(file);

			String info = "";
			while (scan.hasNext())
				info += scan.nextLine() + "\n";

			ta.setText(info);
		}

		frame.getContentPane().add(scrollpane);
		frame.pack();
		frame.setVisible(true);
	}
}
