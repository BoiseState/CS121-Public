package basics;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 Demonstrates menus and menu usage. Also shows the use of JOptionPane to
 pop up an information window.
 @author amit
 */

/**
 * @author amit
 * 
 */
@SuppressWarnings("serial")
public class MenuDemo extends JFrame implements ActionListener
{
	private JMenuBar mBar = new JMenuBar(); // Create the menu bar
	
	private JMenu fileMenu;
	private JMenuItem saveItem, saveAsItem, quitItem, openItem; // File items
	
	private JMenu editMenu;
	private JMenuItem addItem, modifyItem;
	
	private JMenu helpMenu;
	private JMenuItem aboutItem, authorItem;

	private JPanel panel = new JPanel();
	private JTextArea display = new JTextArea(10, 30);

	private String authorInfo = "Amit Jain\n ajain@boisestate.edu";
	private String aboutInfo = "Menu demo program.\n"
			+ "   Written by Amit Jain (ajain@boisestate.edu)\n"
			+ "   You may copy and use this program freely\n"
			+ "   for any purpose. No written or implied warranties.";

	/**
	 * Sets up the main menu and main application window
	 */
	public MenuDemo()
	{
		setTitle("Menu Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createFileMenu();
		createEditMenu();
		createHelpMenu();
		setJMenuBar(mBar);

		display.setEditable(false);
		display.setLineWrap(true);
		JScrollPane scroller = new JScrollPane(display,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(scroller);

		Container c = getContentPane();
		c.add(panel);

	}

	/**
	 * Create the file menu
	 */
	private void createFileMenu()
	{
		fileMenu = new JMenu("File"); // Create the file menu
		mBar.add(fileMenu); // and add it to the menu bar

		openItem = new JMenuItem("Open"); // Open item
		openItem.addActionListener(this);
		openItem.setEnabled(true); // set to false if it is not implemented
		fileMenu.add(openItem);

		saveItem = new JMenuItem("Save"); // Save item
		saveItem.addActionListener(this);
		fileMenu.add(saveItem);

		saveAsItem = new JMenuItem("Save As"); // Save As item
		saveAsItem.addActionListener(this);
		fileMenu.add(saveAsItem);

		fileMenu.addSeparator(); // Logical separator

		quitItem = new JMenuItem("Quit"); // Quit item
		quitItem.addActionListener(this);
		fileMenu.add(quitItem);

	}

	/**
	 * Create the edit menu
	 */
	public void createEditMenu()
	{
		editMenu = new JMenu("Edit"); // Create the file menu
		mBar.add(editMenu); // and add it to the menu bar

		addItem = new JMenuItem("Add");
		addItem.addActionListener(this);
		editMenu.add(addItem);

		modifyItem = new JMenuItem("Modify"); // Save item
		modifyItem.addActionListener(this);
		modifyItem.setEnabled(false); // to show it is not implemented
		editMenu.add(modifyItem);
	}

	/**
	 * Create the help menu
	 */
	public void createHelpMenu()
	{
		helpMenu = new JMenu("Help"); // Create the file menu
		mBar.add(helpMenu); // and add it to the menu bar

		aboutItem = new JMenuItem("About...");
		aboutItem.addActionListener(this);
		helpMenu.add(aboutItem);

		authorItem = new JMenuItem("Author"); // Save item
		authorItem.addActionListener(this);
		helpMenu.add(authorItem);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent event)
	{
		Object source = event.getSource();

		if (source == openItem) {
			display.append("Open was selected\n");
			showFileChooser();
		} 
		else if (source == saveItem)
			display.append("Save was selected\n");
		else if (source == saveAsItem)
			display.append("Save As was selected\n");
		else if (source == quitItem) {
			display.append("Quit was selected\n");
			System.exit(0);
		} else if (source == addItem)
			display.append("Add was selected\n");
		else if (source == modifyItem)
			display.append("Modify was selected\n");
		else if (source == aboutItem) {
			display.append("About was selected\n");
			showAbout();
		} else if (source == authorItem) {
			display.append("Author was selected\n");
			showAuthor();
		}

	}

	private void showFileChooser()
	{
		JFileChooser chooser = new JFileChooser(".");
		
		int status = chooser.showOpenDialog(null);

		if (status != JFileChooser.APPROVE_OPTION)
			display.append("No File Chosen\n");
		else {
			display.append("File chosen was " + chooser.getSelectedFile() + "\n");
		}
		
	}

	/**
	 * Display the author information in a popup message
	 */
	public void showAuthor()
	{
		JOptionPane.showMessageDialog(this, authorInfo, "Author",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Display the about program information in a popup message
	 */
	public void showAbout()
	{
		JOptionPane.showMessageDialog(this, aboutInfo, "About MenuDemo...",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Start the main GUI
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		MenuDemo frame = new MenuDemo();
		frame.setSize(400, 300);
		frame.setVisible(true);
	}

}
