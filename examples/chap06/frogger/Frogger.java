package frogger;

import javax.swing.JFrame;

/**
 * Creates a JFrame and TrafficFroggerPanel for a game of TrafficFrogger 
 *
 * @author mvail
 */
public class Frogger {
	/**
	 * @param args not used
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Traffic Frogger");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new FroggerPanel());
		
		frame.pack();
		frame.setVisible(true);
	}
}
