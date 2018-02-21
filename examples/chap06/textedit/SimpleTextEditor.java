package textedit;

/**
   This application program implements a menu-based interface for a text
   editor. It contains a file menu, an edit menu, and a recent-cuts menu,
   a dynamic menu whose options are built during the editing process.
   The recent-cuts menu stores text that has been cut from the text
   being edited. Items from the cuts menu can be pasted into the document.

 @author: Java, Java, Java
*/

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.util.Vector;

public class SimpleTextEditor extends JFrame implements ActionListener {

    private JMenuBar mBar = new JMenuBar();		  // Create the menu bar
    private JMenu fileMenu, editMenu, cutsMenu;           // Menu references
    private JMenuItem cutItem, copyItem, pasteItem, selectItem,recentcutItem; // Edit items
    private JMenuItem quitItem, openItem, saveItem;       // File items
    private JTextArea display = new JTextArea();          // Here's where the editing occurs			              
    private String scratchPad = "";                       // Scratch pad for cut/paste
    private Vector<String> recentCuts = new Vector<String>();
		
    /**
     *  SimpleTextEditor() constructor sets the layout for the GUI
     *  and calls methods to initialize the menus.
     */
    public SimpleTextEditor() {
        /*super("Simple Text Editor");     // Set the window title*/
        setTitle("Simple Text Editor");     // Set the window title
        getContentPane().setLayout(new BorderLayout()); 
        getContentPane().add("Center", display);	
        getContentPane().add(new JScrollPane(display));
        display.setLineWrap(true);
        setJMenuBar(mBar);         // Set this program's menu bar
        initFileMenu();                 // Create the menus
        initEditMenu();	   
    } 
	
    /**
        Creates the edit menu and adds its individual menu items. 
		Note the each menu item is registered with an ActionListener.
     */
    private void initEditMenu() {
        editMenu = new JMenu("Edit");     // Create the edit menu
        mBar.add(editMenu);	          //  and add it to menu bar

        cutItem = new JMenuItem ("Cut");          // Cut item
        cutItem.addActionListener(this);
        editMenu.add(cutItem);				
		
        copyItem = new JMenuItem("Copy");         // Copy item
        copyItem.addActionListener(this);
        editMenu.add(copyItem);

        pasteItem = new JMenuItem("Paste");       // Paste item
        pasteItem.addActionListener(this);	
        editMenu.add(pasteItem);

        editMenu.addSeparator();

        selectItem = new JMenuItem("Select All"); // Select item
        selectItem.addActionListener(this);	
        editMenu.add(selectItem);	

        editMenu.addSeparator();

        cutsMenu = new JMenu("Recent Cuts");      // Recent cuts submenu
        editMenu.add(cutsMenu);
    } 

    /**
        Creates the file menu and adds its individual menu items. 
		Note the each menu item is registered with an ActionListener.
     */
    private void initFileMenu() {
        fileMenu = new JMenu("File");       // Create the file menu
        mBar.add(fileMenu);                 //  and add it to the menu bar

        openItem = new JMenuItem("Open");   // Open item
        openItem.addActionListener( this );
        openItem.setEnabled(false);
        fileMenu.add(openItem);

        saveItem = new JMenuItem("Save");   // Save item
        saveItem.addActionListener(this);
        saveItem.setEnabled(false);
        fileMenu.add(saveItem);	

        fileMenu.addSeparator();            // Logical separator

        quitItem = new JMenuItem("Quit");   // Quit item
        quitItem.addActionListener(this);
        fileMenu.add(quitItem);	
    } 
		
    /**
       Handles the user's menu selections.
       @param e -- the ActionEvent that led to this method call
     */
    public void actionPerformed(ActionEvent e) {
        JMenuItem m  = (JMenuItem)e.getSource();    // Get the selected menu item
        if ( m == quitItem ) {                      // Quit
            dispose();
			System.exit(0);
        } else if (m == cutItem) {                  // Cut the selected text
            scratchPad = display.getSelectedText(); // Copy the text to the scratchpad
            display.replaceRange("",                //  and delete 
                display.getSelectionStart(),        //  from the start of the selection
                display.getSelectionEnd());         //  to the end
            addRecentCut(scratchPad);               // Add the cut text to the cuts menu
        } else if (m == copyItem) {                 // Copy the selected text to the scratchpad
            scratchPad = display.getSelectedText();
        } else if (m == pasteItem) {                // Paste the scratchpad to the document
            display.insert(scratchPad, display.getCaretPosition());    // at the caret position
        } else if ( m == selectItem ) {               
            display.selectAll();                    // Select the entire document
        } else {
            JMenuItem item = (JMenuItem)e.getSource();  // Default case is the cutsMenu
            scratchPad = item.getActionCommand();       // Put the cut back in the scratchpad
        }	    	   
    } 
  	
    /**
       Adds its parameter to the recent cut menu, a menu which grows dynamically as the 
	   user cuts text from a document.  Recent cuts are stored in a vector. When inserting 
	   a cut into the menu the menu is first cleared (removeAll(), and then the recent cuts are
       inserted in last-in-first-out order. Each newly inserted cut is assigned an ActionListener.

       @param cut -- the text to be added as the menu item
     */
    private void addRecentCut(String cut) {
        recentCuts.insertElementAt(cut,0);
        cutsMenu.removeAll();
        for (int k = 0; k < recentCuts.size(); k++) {
            JMenuItem item = new JMenuItem((String)recentCuts.elementAt(k));
            cutsMenu.add( item );
            item.addActionListener(this);
        }	   
    } 
	
    /**
       Creates an instance of the SimpleTextEditor
     */
    public static void main(String args[]) {
        SimpleTextEditor f = new SimpleTextEditor(); 
        f.setSize(400, 400);  
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {      // Quit the application
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    } 
} 
