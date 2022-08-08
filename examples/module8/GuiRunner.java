import javax.swing.JFrame;

/**
 * The GuiRunner class can be modified to load a class that
 * extends the JPanel class with a few modifications to main().
 * 
 * @author mvail
 */
public class GuiRunner {

	/**
	 * The main() method is the starting method that creates an
	 * object that extends the JPanel class and displays it in
	 * a GUI JFrame.
	 * 
	 * The "TODO" comments show where modifications should be made.
	 *  
	 * @param args not used
	 */
	public static void main(String[] args) {
		//TODO: Change "Title" to the title of your program.
		JFrame frame = new JFrame("Title");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//TODO: Change "GuiPanel" to the name of your JPanel class.
		GuiPanel mainPanel = new GuiPanel();

		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setVisible(true);
	}

}
