import java.awt.*;

import javax.swing.*;

/**
 * This class is a customized JPanel and is the main
 * container to hold content for the GUI. For a very
 * simple GUI, all of the program logic might be contained
 * in this class. In a more complex GUI, this class might
 * be the organizer and coordinator between many other
 * classes.
 * 
 * @author mvail
 */
@SuppressWarnings("serial")
public class GuiPanel extends JPanel {
	//TODO: Declare any necessary instance variables, here
	
	/**
	 * Constructor - this is where all instance variables
	 * should be initialized and any initial set up should
	 * occur.
	 */
	public GuiPanel() {
		this.setDoubleBuffered(false);//set to true if doing animation, else false
		
		//TODO: initialize instance variables,
		//  do any necessary set up 

	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 * 
	 * The paint() method is called whenever the panel needs to
	 * be redrawn. It can also be called whenever you want by
	 * calling repaint(), which handles things like creating the
	 * Graphics object needed in paint(). You usually do not
	 * call paint() directly. 
	 */
	public void paint(Graphics g) {
		//TODO: refresh this panel - may involve redrawing or
		//  resizing/repositioning components
		
	}

}
