import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Create a frame and display it.
 * @author amit
 *
 */
public class FrameExample2 {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Uncomment to turn on the default look and feel for Java GUIs
		//JFrame.setDefaultLookAndFeelDecorated(true);
		
		JFrame hello = new JFrame("Hello Again World");
		//To set the default operation on closing the window to exit the program
		hello.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Use setPreferredSize instead of setSize or pack will ignore the size
		hello.setPreferredSize(new Dimension(400, 400));
		
		//To size the window to fit all the components without calculating it manually
		hello.pack();
		
		hello.setVisible(true);
	}
}
