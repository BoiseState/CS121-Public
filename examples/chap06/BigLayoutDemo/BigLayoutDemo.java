package BigLayoutDemo;

import javax.swing.JFrame;

/**Sample GUI layout project
 * @author mvail
 */
public class BigLayoutDemo {

	/**
	 * The main() method is the starting method that creates the
	 * GUI's top-level JPanel object and displays it in a JFrame.
	 *  
	 * @param args not used
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Big Layout Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		TopCoordinatorPanel mainPanel = new TopCoordinatorPanel();

		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setVisible(true);
	}

}
