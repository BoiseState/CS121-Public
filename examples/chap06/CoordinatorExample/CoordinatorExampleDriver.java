package CoordinatorExample;

import javax.swing.JFrame;

/** Example GUI demonstrating coordination of components between panels.
 * This is the driver class, so it simply creates the top-level frame and puts the main panel in it.
 * @author mvail
 */
public class CoordinatorExampleDriver {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Colors!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new CoordinatorAndOrganizerPanel());
		
		frame.pack();
		frame.setVisible(true);
	}
}
