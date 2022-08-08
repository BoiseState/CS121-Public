import java.awt.Dimension;

import javax.swing.JFrame;


/**
 * Demonstrates use of javax.swing.Timer. For a simpler example, see TimerDemo.java.
 * 
 * @author CS121 Instructors
 */
public class TimerDemoCooler
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Cooler Timer Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(300, 125));
		frame.getContentPane().add(new TimerDemoCoolerPanel());
		
		
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
}
