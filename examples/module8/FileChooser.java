import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
  Demonstrates the use of a file chooser and a text area.
  @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class FileChooser extends JPanel
{
	private JTextArea filePreview;
	private JButton openFileButton;
	
	/**
	 * Opens a file chooser dialog, reads the selected file and loads it into a
	 * text area.
	 */
	public FileChooser()
	{
		openFileButton = new JButton("Select File");
		openFileButton.addActionListener(new ButtonActionListener());
		
		filePreview = new JTextArea(20, 30);
		JScrollPane scrollPane = new JScrollPane(filePreview,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(scrollPane);
		add(openFileButton);
	}
	
	private class ButtonActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			// The following starts in the home folder
			//JFileChooser chooser = new JFileChooser();
			
			// The following starts in the current folder, which is often convenient
			JFileChooser chooser = new JFileChooser(".");
			
			int status = chooser.showOpenDialog(null);

			if (status != JFileChooser.APPROVE_OPTION) {
				filePreview.setText("No File Chosen");
			} else {
				File file = chooser.getSelectedFile();
				
				// Read the contents of the file and display.
				// We don't have to read the contents, we could just pass the
				// File along.
				try {
					Scanner scan = new Scanner(file);
					while (scan.hasNext()) {
						String line = scan.nextLine() + "\n";
						filePreview.append(line);
					}
					scan.close();
				} catch(FileNotFoundException e) {
					filePreview.setText("Could not open file: " + file.getPath());
				}
			}
		}
	}

	/**
	 * Creates and launches the JFrame.
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Display File");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new FileChooser());
		frame.pack();
		frame.setVisible(true);
	}
}
